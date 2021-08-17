package com.example.currency_converter_hw.data.network

import com.example.currency_converter_hw.data.IData
import com.example.currency_converter_hw.data.Status

object Client : IData{
    override suspend fun getConverterCurrency(
        fromCurrency: String,
        toCurrency: String,
        amount: Double?,
    ): Status<String> {
        TODO("Not yet implemented")
    }
}