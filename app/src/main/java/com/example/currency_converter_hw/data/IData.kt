package com.example.currency_converter_hw.data

interface IData {
    suspend fun getConverterCurrency(fromCurrency: String, toCurrency: String, amount: Double?): Status<String>
}