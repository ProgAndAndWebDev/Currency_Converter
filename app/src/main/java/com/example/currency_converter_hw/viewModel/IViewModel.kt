package com.example.currency_converter_hw.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.currency_converter_hw.data.Status
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

interface IViewModel {

    fun getConverter(): Job

    fun getCheckStatus(status: Status<String>) =
        when (status) {
            is Status.Error -> status.message
            is Status.Loading -> "Loading..."
            is Status.Success -> status.data
        }
}