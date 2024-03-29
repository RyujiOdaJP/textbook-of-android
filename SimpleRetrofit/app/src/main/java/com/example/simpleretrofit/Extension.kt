package com.example.simpleretrofit

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner

object Extension {
    fun <T: ViewDataBinding> T.bind(
        lifecycleOwner: LifecycleOwner,
        bind : (T) -> Unit
    ) : View =
        this.also {
            it.lifecycleOwner = lifecycleOwner
            bind(it)
        }.root

}