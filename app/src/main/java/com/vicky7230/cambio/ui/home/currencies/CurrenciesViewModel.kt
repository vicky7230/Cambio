package com.vicky7230.cambio.ui.home.currencies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vicky7230.cambio.data.Config
import com.vicky7230.cambio.data.DataManager
import com.vicky7230.cambio.data.network.model.currencies.Currency
import kotlinx.coroutines.launch
import javax.inject.Inject

class CurrenciesViewModel @Inject constructor(
    private val dataManager: DataManager
) : ViewModel() {

    val liveData = MutableLiveData<MutableList<Currency>>()
    /*fun getWeatherData(lat: String, lng: String): Observable<CurrentWeather> {
        return dataManager.getCurrentLocationWeather(
            lat,
            lng,
            Config.API_KEY,
            "metric"
        )
    }

    fun getForecastData(lat: String, lng: String): Observable<Forecast> {
        return dataManager.getCurrentLocationForecast(
            lat,
            lng,
            Config.API_KEY,
            "metric",
            "5"
        )
    }*/

    fun getCurrencies() {
        viewModelScope.launch {
            liveData.value = dataManager.getCurrencies(Config.API_KEY)
        }
    }
}