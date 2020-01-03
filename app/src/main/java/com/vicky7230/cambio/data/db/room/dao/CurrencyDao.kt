package com.vicky7230.cambio.data.db.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vicky7230.cambio.data.network.model.currencies.Currency
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrencies(currencies: List<Currency>): List<Long>

    @Query("SELECT * FROM currencies")
    fun loadAllCurrencies(): Flow<List<Currency>>
}