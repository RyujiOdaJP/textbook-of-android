package com.example.simpleretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl("http://apppppp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val handler = Handler()

        thread {
            try {// Retrofitはメインスレッドで処理できない
                val service:JojoService = retrofit.create(JojoService::class.java)
                val jojo = service.fetchJojo().execute().body() ?: throw IllegalStateException("bodyがnullだよ！")

            } catch (e:Exception) {
                Log.d("mapi", "debug $e")
            }
        }
    }
    }
}