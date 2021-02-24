package com.example.listsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lv_menu)
        //プロパティへの直接アクセスで、自動的にセッターの役割をする
        lvMenu.onItemClickListener = ListItemClickListener()
    }

    // リストがタップされた時の処理を記述
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            // parentはリスト全体、viewは1行に含まれる要素、positionは行番号0~..、idはDB主キー
            //タップされた定食名を取得
            val item = parent!!.getItemAtPosition(position) as String
            // トースト用文字列
            val show = "selected:" + item
            Toast.makeText(applicationContext, show, Toast.LENGTH_LONG).show()
        }
    }
}