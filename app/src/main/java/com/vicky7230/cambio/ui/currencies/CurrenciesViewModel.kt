package com.vicky7230.cambio.ui.currencies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vicky7230.cambio.data.Config
import com.vicky7230.cambio.data.DataManager
import com.vicky7230.cambio.data.network.RetrofitResult
import com.vicky7230.cambio.data.network.model.currencies.Currency
import com.vicky7230.cambio.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class CurrenciesViewModel @Inject constructor(
    private val dataManager: DataManager
) : BaseViewModel() {

    var loading = MutableLiveData<Boolean>()
    var error = MutableLiveData<String>()
    val currencies: LiveData<List<Currency>> = dataManager.loadAllCurrencies()

    fun getCurrencies() {

        viewModelScope.launch {

            //loading.value = true

            val response = safeApiCall { dataManager.getCurrencies(Config.API_KEY) }

            when (response) {
                is RetrofitResult.Success -> {
                    //currencies.value = response.data
                    dataManager.insertCurrencies(response.data)
                }
                is RetrofitResult.Error -> {
                    error.value = response.exception.message
                }
            }

            loading.value = false
        }

    }
}