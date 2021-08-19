package com.example.currency_converter_hw.data.database

import com.example.currency_converter_hw.data.IData
import com.example.currency_converter_hw.data.Status
import com.example.currency_converter_hw.data.database.model.Currency
import kotlinx.coroutines.delay
import java.lang.Exception
import java.math.BigDecimal
import java.math.RoundingMode

class Database : IData {
    private val currencyList:List<Currency> =
        listOf(
                Currency("IQD",1460.0  ),
                Currency("USD",1.0  )
            )

    override suspend fun getConverterCurrency(fromCurrency: String, toCurrency: String, amount: Double?): Status<String>
        = try{
               val result = BigDecimal(
                   amount!! *
                           currencyList.getInfoCurrency(toCurrency) /
                           currencyList.getInfoCurrency(fromCurrency))
                   .setScale(3, RoundingMode.HALF_EVEN).toString()

               delay(600)
               Status.Success(result)
        } catch (e:Exception) {
               Status.Error("There is no amount!")
        }

}

fun List<Currency>.getInfoCurrency(currency: String): Double {
    return this.first { it.nameCurrency == currency }.valueCurrency
}