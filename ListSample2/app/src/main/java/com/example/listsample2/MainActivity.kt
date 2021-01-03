package com.example.listsample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        var menuList = mutableListOf<String>(
                "唐揚げ定食",
                "ハンバーグ定食",
                "唐揚げ定食",
                "唐揚げ定食",
                "野菜炒め",
                "とんかつ",
                "ミンチカツ",
                "生姜焼き",
                "ちゃーはん"
        )
        // アダプタオブジェクトの生成
        // アダプタはリストビューの各行にリストデータを当てはめていくためのオブジェクト
        val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, menuList)
        // .adapter はListViewのプロパティ
        lvMenu.adapter = adapter

        lvMenu.onItemClickListener = ListItemClickListener()
    }
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            // ダイアログフラグメントオブジェクトの生成
            val dialogFragment = OrderConfirmDialogFragment()
            // ダイアログ表示
            dialogFragment.show(supportFragmentManager, "OrderConfirmDialogFragment")
        }
    }
}