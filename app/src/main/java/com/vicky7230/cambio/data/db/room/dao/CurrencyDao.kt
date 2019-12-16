package com.vicky7230.cambio.data.db.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vicky7230.cambio.data.network.model.currencies.Currency

@Dao
interface CurrencyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrencies(currencies: List<Currency>): List<Long>

    @Query("SELECT * FROM currencies")
    fun loadAllCurrencies(): LiveData<List<Currency>>
}