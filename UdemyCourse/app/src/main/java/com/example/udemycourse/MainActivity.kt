package com.example.udemycourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate state:" + lifecycle.currentState)

        textView = findViewById<TextView>(R.id.text)
        textView.setOnClickListener {
            textView.text = (textView.text.toString().toInt() + 1).toString()
        }

        if (savedInstanceState != null) {
            textView.text = savedInstanceState.getString("count")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("count", textView.text.toString())
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart state:" + lifecycle.currentState)
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume state:" + lifecycle.currentState)
    }

    override fun onPostResume() { // onPostResume()はonResumeの後に呼ばれます。
        super.onPostResume()
        Log.d("MainActivity", "onPostResume state:" + lifecycle.currentState)
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause state:"+lifecycle.currentState)
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop state:"+lifecycle.currentState)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy state:"+lifecycle.currentState)
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}