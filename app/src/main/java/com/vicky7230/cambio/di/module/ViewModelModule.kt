package com.vicky7230.cambio.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vicky7230.cambio.ViewModelFactory
import com.vicky7230.cambio.di.ViewModelKey
import com.vicky7230.cambio.ui.currencies.CurrenciesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CurrenciesViewModel::class)
    internal abstract fun postCurrenciesViewModel(viewModel: CurrenciesViewModel): ViewModel

    /*@Binds
    @IntoMap
    @ViewModelKey(CurrentLocationWeatherViewModel::class)
    internal abstract fun postCurrentLocationWeatherViewModel(currentLocationWeatherViewModel: CurrentLocationWeatherViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddCityViewModel::class)
    internal abstract fun postAddCityViewModel(addCityViewModel: AddCityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CityWeatherViewModel::class)
    internal abstract fun postCityWeatherViewModel(cityWeatherViewModel: CityWeatherViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SavedCitiesViewModel::class)
    internal abstract fun postSavedCitiesViewModel(savedCitiesViewModel: SavedCitiesViewModel): ViewModel
*/
}