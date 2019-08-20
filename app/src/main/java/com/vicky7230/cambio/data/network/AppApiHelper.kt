package com.vicky7230.cambio.data.network

import com.vicky7230.cambio.data.network.model.currencies.Currency
import javax.inject.Inject

class AppApiHelper @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getCurrencies(key: String): MutableList<Currency> {
        return apiService.getCurrencies(key)
    }
}