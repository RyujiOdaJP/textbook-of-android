package com.example.sampleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.btSave)
        button.setOnClickListener {

        }
    }

    private inner class Hello : View.OnClickListener {
        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }


}