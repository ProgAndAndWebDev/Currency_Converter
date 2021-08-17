package com.example.currency_converter_hw.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import androidx.annotation.LayoutRes
import com.example.currency_converter_hw.viewModel.IViewModel
import com.example.currency_converter_hw.viewModel.MainViewModel

abstract class BaseActivity<VB : ViewBinding , VM : IViewModel > : AppCompatActivity() {

    abstract val LOG_TAG: String

    abstract val viewModel:VM
    private var _binding: ViewBinding? = null
    protected var binding = _binding as VB?

    @LayoutRes
    protected abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,getLayout())

        setup()
    }

    //basic function in this project
    protected abstract fun setup()
    protected abstract fun addCallbacks()
    protected fun log(value: Any) {
        Log.v(LOG_TAG, value.toString())
    }
}