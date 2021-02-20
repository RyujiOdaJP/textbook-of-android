package com.example.simplerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), RecyclerViewHolder.ItemClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var viewAdapter: RecyclerView.Adapter<*>
    lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewAdapter = RecyclerAdapter(this, this, createApiData())
        viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
    }

    override fun onItemClick(itemView: View, position: Int) {
        Toast.makeText(applicationContext, "position $position was tapped", Toast.LENGTH_SHORT)
            .show()
    }

    private fun createData(): List<RowData> {
        val dataList: MutableList<RowData> = mutableListOf()
        for (i in 1..50) {
            val data = RowData()
            data.title = "No.$i"
            data.detail = "detail $i"

            dataList.add(data)
        }
        return dataList
    }

    private fun createService(): ApiService {
        val httpLogging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder().addInterceptor(httpLogging)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://qiita.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        return retrofit.create(ApiService::class.java)
    }

    private fun createApiData (): List<Model> {

        val dataList = mutableListOf<Model>()

        createService().apiDemo(page = 1, perPage = 20).enqueue(object: Callback<List<QiitaResponse>> {

            //非同期処理
            override fun onResponse(call: Call<List<QiitaResponse>>, response: Response<List<QiitaResponse>>) {
                Log.d("TAGres","onResponse")

                //ステータスコードが200：OKなので、ここではちゃんと通信できたよ
                if (response.isSuccessful) {
                    response.body()?.let {
                        for (item in it) {
                            val data: Model = Model().also {
                                //取得したいものをAPIから手元のリスト（Model）に
                                it.title = item.title
                                it.url = item.url
                                it.id = item.user!!.id
                            }
                            //取得したデータをModelに追加
                            dataList.add(data)
                        }
                        //今回recyclerViewを利用しているが、これを書かないと先に画面の処理が終えてしまうので表示されなくなります。
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
                } else {
                }
            }
            override fun onFailure(call: Call<List<QiitaResponse>>, t: Throwable) {
                Log.d("TAGres","onFailure")
            }
        })
        Log.d("dataList", dataList.toString())
        return dataList
    }

}