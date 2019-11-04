package com.vicky7230.cambio.data.network

import com.vicky7230.cambio.data.network.model.currencies.Currency
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("currencies/ticker")
    suspend fun getCurrencies(
        @Query("key") key: String
    ): Response<List<Currency>>
}