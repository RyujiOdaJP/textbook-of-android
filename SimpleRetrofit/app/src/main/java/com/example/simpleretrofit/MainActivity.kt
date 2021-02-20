package com.example.simpleretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.lang.Exception
import kotlin.concurrent.thread

data class Jojo(val name: String = "", val stand: String = "")

// fetchJoJoメソッドは、APIリクエストを行う関数。定義をするだけで、実装をやる必要はない。
// なんと素晴らしいことに、Retrofixが実装をやってくれるのだ！
interface JojoService {
    @GET("jojo.json")
    fun fetchJojo(): Call<Jojo>
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://apppppp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val handler = Handler()
        Log.d("sdddddf","as")

        thread {
            try {// Retrofitはメインスレッドで処理できない
                val service: JojoService = retrofit.create(JojoService::class.java)
                val jojo = service.fetchJojo().execute().body()
                    ?: throw IllegalStateException("bodyがnullだよ！")
                Log.d("sdf",jojo.name)

                handler.post(Runnable {
                    val nameTextView = findViewById<TextView>(R.id.name)
                    val standTextView = findViewById<TextView>(R.id.stand)

                    Log.d("a", jojo.stand)
                    nameTextView.text = jojo.name
                    standTextView.text = jojo.stand
                })

            } catch (e: Exception) {
                Log.d("mopi", "debug $e")
            }
        }

    }

}