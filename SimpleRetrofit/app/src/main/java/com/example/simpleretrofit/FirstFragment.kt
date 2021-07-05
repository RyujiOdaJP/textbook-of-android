package com.example.simpleretrofit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.simpleretrofit.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentFirstBinding.inflate(inflater, container, false).also {
        it.firstText.text = "444"
    }.root
}