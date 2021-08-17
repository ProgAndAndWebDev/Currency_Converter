package com.example.currency_converter_hw.ui

import androidx.activity.viewModels
import com.example.currency_converter_hw.databinding.ActivityMainBinding
import com.example.currency_converter_hw.viewModel.MainViewModel
import com.example.currency_converter_hw.R


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val LOG_TAG: String = "MAIN"
    override val viewModel: MainViewModel by viewModels()
    override fun getLayout(): Int = R.layout.activity_main

    override fun setup(){
        binding!!.viewModel = viewModel
        binding!!.lifecycleOwner = this
    }

    override fun addCallbacks() {
        settingSpinners()
    }

    fun settingSpinners() {
        binding!!.spinnerToCurrency.setSelection(1)
    }

}

