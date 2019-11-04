package com.vicky7230.cambio.data.network

import com.vicky7230.cambio.data.network.model.currencies.Currency
import retrofit2.Response

interface ApiHelper {
    suspend fun getCurrencies(key: String): Response<List<Currency>>
}