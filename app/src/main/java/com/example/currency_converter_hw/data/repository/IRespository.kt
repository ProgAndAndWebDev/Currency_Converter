package com.example.currency_converter_hw.data.repository

import com.example.currency_converter_hw.data.Status
import kotlinx.coroutines.flow.Flow

interface IRespository {

    fun convertedCurrency(fromCurrency: String, toCurrency: String, amount: Double?):  Flow<Any>

    fun getCheckStatus(status: Status<String>): String =
        when (status) {
            is Status.Error -> status.message
            is Status.Loading -> "Loading..."
            is Status.Success -> status.data
        }
}