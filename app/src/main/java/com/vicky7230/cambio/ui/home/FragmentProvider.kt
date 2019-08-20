package com.vicky7230.cambio.ui.home

import com.vicky7230.cambio.ui.home.currencies.CurrenciesFragment
import com.vicky7230.cambio.ui.home.currencies.CurrenciesModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {

    @ContributesAndroidInjector(modules = [(CurrenciesModule::class)])
    internal abstract fun provideCurrenciesFragmentFactory(): CurrenciesFragment

    /*@ContributesAndroidInjector(modules = [(DiscoverModule::class)])
    internal abstract fun provideDiscoverFragmentFactory(): DiscoverFragment*/

    /*@ContributesAndroidInjector(modules = [(WatchListModule::class)])
    internal abstract fun provideWatchListFragmentFactory(): WatchListFragment

    @ContributesAndroidInjector(modules = [(FavoriteModule::class)])
    internal abstract fun provideProfileFragmentFactory(): FavoriteFragment*/
}
