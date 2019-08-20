package com.vicky7230.cambio.data

import com.vicky7230.cambio.data.network.AppApiHelper
import com.vicky7230.cambio.data.network.model.currencies.Currency
import javax.inject.Inject

class AppDataManager @Inject
constructor(
    private val appApiHelper: AppApiHelper
) : DataManager {

    override suspend fun getCurrencies(key: String): MutableList<Currency> {
        return appApiHelper.getCurrencies(key)
    }

}