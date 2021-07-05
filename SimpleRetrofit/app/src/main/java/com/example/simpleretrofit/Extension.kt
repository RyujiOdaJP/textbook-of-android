package com.example.simpleretrofit

import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner

object Extension {
    fun <T: ViewDataBinding> T.bind(
        lifecycleOwner: LifecycleOwner
    ) : View =
        this.also {
            it.lifecycleOwner = lifecycleOwner
        }.root

}