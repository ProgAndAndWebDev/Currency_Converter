package com.example.currency_converter_hw.data.repository

import android.util.Log
import com.example.currency_converter_hw.Constroucter.TAG
import com.example.currency_converter_hw.data.IData
import com.example.currency_converter_hw.data.Status
import com.example.currency_converter_hw.data.database.Database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class CurrencyConverterRespository : IRespository {

    private val fakeDatabase:IData = Database()

    override fun convertedCurrency(fromCurrency: String, toCurrency: String, amount: Double?): Flow<Any> =
        flow {
               emit(getCheckStatus(Status.Loading))
               val statusCurrency = fakeDatabase
                        .getConverterCurrency(fromCurrency, toCurrency, amount)
               emit(getCheckStatus(statusCurrency))
        }
            .onCompletion { Log.i(TAG , "Done convertedCurrency()") }
            .flowOn(Dispatchers.IO)


}