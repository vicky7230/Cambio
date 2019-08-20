package com.vicky7230.cambio.di.module

import com.vicky7230.cambio.ui.home.FragmentProvider
import com.vicky7230.cambio.ui.home.HomeActivity
import com.vicky7230.cambio.ui.home.HomeModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by vicky on 1/1/18.
 */
@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [(HomeModule::class), (FragmentProvider::class)])
    abstract fun bindHomeActivity(): HomeActivity

    /*@ContributesAndroidInjector(modules = [(AddCityModule::class)])
    abstract fun bindAddCityActivity(): AddCityActivity

    @ContributesAndroidInjector(modules = [(SavedCitiesModule::class)])
    abstract fun bindSavedCitiesActivity(): SavedCitiesActivity*/

}