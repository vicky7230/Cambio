package com.vicky7230.cambio.data.db

import com.vicky7230.cambio.data.network.model.currencies.Currency
import kotlinx.coroutines.flow.Flow

interface DbHelper {
    suspend fun insertCurrencies(currencies: List<Currency>): List<Long>

    fun loadAllCurrencies(): Flow<List<Currency>>
}
