package com.vicky7230.aqua

import android.app.Application
import timber.log.Timber

class Aqua : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}