package com.example.udemycourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel : ViewModel() {
    var count: Int = 0
}

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate state:" + lifecycle.currentState)

        textView = findViewById(R.id.text)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        textView.text = viewModel.count.toString()
        textView.setOnClickListener {
            viewModel.count++
            textView.text = viewModel.count.toString()
        }

//        if (savedInstanceState != null) {
//            textView.text = savedInstanceState.getString("count")
//        }


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

}