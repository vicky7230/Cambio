package com.vicky7230.cambio.data

import com.vicky7230.cambio.data.network.AppApiHelper
import com.vicky7230.cambio.data.network.model.currencies.Currency
import retrofit2.Response
import javax.inject.Inject

class AppDataManager @Inject
constructor(
    private val appApiHelper: AppApiHelper
) : DataManager {

    override suspend fun getCurrencies(key: String): Response<List<Currency>> {
        return appApiHelper.getCurrencies(key)
    }

}