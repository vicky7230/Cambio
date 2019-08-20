package com.vicky7230.cambio.di.component

import com.vicky7230.cambio.CambioApplication
import com.vicky7230.cambio.di.module.ActivityBindingModule
import com.vicky7230.cambio.di.module.ApplicationModule
import com.vicky7230.cambio.di.module.NetworkModule
import com.vicky7230.cambio.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by vicky on 12/2/18.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ApplicationModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(cambioApplication: CambioApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(cambioApplication: CambioApplication)
}