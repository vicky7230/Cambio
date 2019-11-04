package com.vicky7230.cambio.ui.home.currencies

import dagger.Module
import dagger.Provides

@Module
class CurrenciesModule {

    @Provides
    fun provideCurrenciesAdapter(): CurrenciesAdapter {
        return CurrenciesAdapter(arrayListOf())
    }
}