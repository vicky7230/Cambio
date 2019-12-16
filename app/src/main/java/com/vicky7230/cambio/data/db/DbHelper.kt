package com.vicky7230.cambio.data.db

import androidx.lifecycle.LiveData
import com.vicky7230.cambio.data.network.model.currencies.Currency

interface DbHelper {
    suspend fun insertCurrencies(currencies: List<Currency>): List<Long>

    fun loadAllCurrencies(): LiveData<List<Currency>>
}
