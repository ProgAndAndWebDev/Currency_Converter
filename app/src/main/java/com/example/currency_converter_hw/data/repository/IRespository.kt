package com.example.currency_converter_hw.data.repository

import com.example.currency_converter_hw.data.Status
import kotlinx.coroutines.flow.Flow

interface IRespository {
    fun convertedCurrency(fromCurrency: String, toCurrency: String, amount: Double?): Flow<Status<String>>
}