package com.example.intentsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()
        var menu = mutableMapOf("name" to "唐揚げ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "850円")
        menuList.add(menu)

        val from = arrayOf("name", "price")

        val to = intArrayOf(android.R.id.text1, android.R.id.text2)

        val adapter = SimpleAdapter(
            applicationContext,
            menuList,
            android.R.layout.simple_list_item_2,
            from,
            to
        )
        lvMenu.adapter = adapter
    }
}