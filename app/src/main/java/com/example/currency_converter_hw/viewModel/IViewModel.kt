package com.example.currency_converter_hw.viewModel

import com.example.currency_converter_hw.data.Status
import kotlinx.coroutines.Job

interface IViewModel {

    fun getConverter(): Job

    fun getCheckStatus(status: Status<String>) =
        when (status) {
            is Status.Error -> status.message
            is Status.Loading -> "Loading..."
            is Status.Success -> status.data
        }
}