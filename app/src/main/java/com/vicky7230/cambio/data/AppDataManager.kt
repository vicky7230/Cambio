package com.vicky7230.cambio.data

import androidx.lifecycle.LiveData
import com.vicky7230.cambio.data.db.AppDbHelper
import com.vicky7230.cambio.data.network.AppApiHelper
import com.vicky7230.cambio.data.network.model.currencies.Currency
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class AppDataManager @Inject
constructor(
    private val appApiHelper: AppApiHelper,
    private val appDbHelper: AppDbHelper
) : DataManager {

    override suspend fun getCurrencies(key: String): Response<List<Currency>> {
        return appApiHelper.getCurrencies(key)
    }

    override suspend fun insertCurrencies(currencies: List<Currency>): List<Long> {
        return appDbHelper.insertCurrencies(currencies)
    }

    override fun loadAllCurrencies(): Flow<List<Currency>> {
        return appDbHelper.loadAllCurrencies()
    }

}