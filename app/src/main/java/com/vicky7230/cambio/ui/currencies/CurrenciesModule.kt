package com.vicky7230.cambio.ui.currencies

import dagger.Module
import dagger.Provides

@Module
class CurrenciesModule {

    @Provides
    fun provideCurrenciesAdapter(): CurrenciesAdapter {
        return CurrenciesAdapter(arrayListOf())
    }
}