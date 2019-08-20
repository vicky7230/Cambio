package com.vicky7230.cambio.ui.home

import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun providePagerAdapter(homeActivity: HomeActivity): PagerAdapter {
        return PagerAdapter(homeActivity.supportFragmentManager)
    }
}