package com.vicky7230.cambio.data.db

import androidx.lifecycle.LiveData
import com.vicky7230.cambio.data.db.room.AppDatabase
import com.vicky7230.cambio.data.network.model.currencies.Currency
import javax.inject.Inject

class AppDbHelper @Inject constructor(private val appDatabase: AppDatabase) : DbHelper {

    override suspend fun insertCurrencies(currencies: List<Currency>): List<Long> {
        return appDatabase.currencyDao().insertCurrencies(currencies)
    }

    override fun loadAllCurrencies(): LiveData<List<Currency>> {
        return appDatabase.currencyDao().loadAllCurrencies()
    }

}