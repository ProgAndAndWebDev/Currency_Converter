package com.example.currency_converter_hw

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.core.view.get
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData

@BindingAdapter("theCurrency")
fun listenClicks(spinner: Spinner, theCurrency: MutableLiveData<String>) {
    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) { }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            theCurrency.value = ( parent!!.getItemAtPosition(position) as String)
        }
    }
}
