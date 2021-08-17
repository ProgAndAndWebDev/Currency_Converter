package com.example.currency_converter_hw.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currency_converter_hw.Constroucter.TAG
import com.example.currency_converter_hw.data.repository.IRespository
import com.example.currency_converter_hw.data.repository.CurrencyConverterRespository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.catch


class MainViewModel : ViewModel() , IViewModel{

    private val repository: IRespository = CurrencyConverterRespository()

    private var _convertCurrency = MutableLiveData<String>()
    private var _currentCurrency = MutableLiveData<String>(" ")
    var fromCurrency = MutableLiveData<String>("")
    var toCurrency = MutableLiveData<String>("")

    val convertCurrency : MutableLiveData<String>
        get() = _convertCurrency

    val currentCurrency : MutableLiveData<String>
        get() = _currentCurrency

    override fun getConverter() =
        viewModelScope.launch {
            repository.convertedCurrency( fromCurrency.value!!
                , toCurrency.value!!, currentCurrency.value?.toDoubleOrNull())
                .catch { e -> Log.i(TAG, "${e.message}") }
                .collect { _convertCurrency.postValue(getCheckStatus(it)) }
        }



}
