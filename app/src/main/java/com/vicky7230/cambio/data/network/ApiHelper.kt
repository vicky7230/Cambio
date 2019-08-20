package com.vicky7230.cambio.data.network

import com.vicky7230.cambio.data.network.model.currencies.Currency

interface ApiHelper {
    suspend fun getCurrencies(key: String): MutableList<Currency>
}