package com.vicky7230.cambio.di.module

import com.vicky7230.cambio.ui.currencies.CurrenciesModule
import com.vicky7230.cambio.ui.currencies.CurrenciesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by vicky on 1/1/18.
 */
@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [(CurrenciesModule::class)])
    abstract fun bindCurrencyActivity(): CurrenciesActivity

    /*@ContributesAndroidInjector(modules = [(AddCityModule::class)])
    abstract fun bindAddCityActivity(): AddCityActivity

    @ContributesAndroidInjector(modules = [(SavedCitiesModule::class)])
    abstract fun bindSavedCitiesActivity(): SavedCitiesActivity*/

}