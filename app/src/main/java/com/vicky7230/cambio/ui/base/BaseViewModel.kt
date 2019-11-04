package com.vicky7230.cambio.ui.base

import androidx.lifecycle.ViewModel
import com.vicky7230.cambio.data.network.RetrofitResult
import retrofit2.Response
import timber.log.Timber
import java.io.IOException

open class BaseViewModel : ViewModel() {

    suspend fun <T : Any> safeApiCall(
        call: suspend () -> Response<T>
    ): RetrofitResult<T>? {
        try {
            val response = call.invoke()
            if (response.isSuccessful) {
                /** Called for [200, 300) responses. */
                return RetrofitResult.Success(response.body()!!)
            } else {
                return when (response.code()) {
                    401 -> {
                        RetrofitResult.Error(IOException("HTTP ${response.code()} : Unauthorized"))
                    }
                    in 400..499 -> {
                        RetrofitResult.Error(IOException("HTTP ${response.code()} : Client Error"))
                    }
                    in 500..599 -> {
                        RetrofitResult.Error(IOException("HTTP ${response.code()} : Server Error"))
                    }
                    else -> {
                        RetrofitResult.Error(IOException("HTTP ${response.code()} : Something went wrong"))
                    }
                }
            }
        } catch (e: Exception) {
            //Log exception
            Timber.e(e)
            return RetrofitResult.Error(IOException(e))
        }
    }
}

