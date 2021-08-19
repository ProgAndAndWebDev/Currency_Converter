package com.example.currency_converter_hw.ui

import android.widget.Spinner
import androidx.activity.viewModels
import com.example.currency_converter_hw.databinding.ActivityMainBinding
import com.example.currency_converter_hw.viewModel.MainViewModel
import com.example.currency_converter_hw.R


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val LOG_TAG: String = "Main_Activity"
    override val viewModel: MainViewModel by viewModels()
    override fun getLayout(): Int = R.layout.activity_main

    override fun setup(){
        binding!!.viewModel = viewModel
        binding!!.lifecycleOwner = this

        settingSpinner()

    }

    override fun addCallbacks() {

        binding!!.switchSpinner.setOnClickListener {
            switchSpinners(binding!!.spinnerFromCurrency , binding!!.spinnerToCurrency)
        }

    }

    private fun settingSpinner(){
        binding!!.spinnerFromCurrency.setSelection(1)
    }

    fun switchSpinners(from: Spinner , to: Spinner) {
        val switch = to.selectedItemPosition
        to.setSelection(from.selectedItemPosition)
        from.setSelection(switch)
    }

}

