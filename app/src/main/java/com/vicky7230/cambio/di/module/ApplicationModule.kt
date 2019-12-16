package com.vicky7230.cambio.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.vicky7230.cambio.CambioApplication
import com.vicky7230.cambio.data.AppDataManager
import com.vicky7230.cambio.data.Config
import com.vicky7230.cambio.data.DataManager
import com.vicky7230.cambio.data.db.AppDbHelper
import com.vicky7230.cambio.data.db.DbHelper
import com.vicky7230.cambio.data.db.room.AppDatabase
import com.vicky7230.cambio.data.network.ApiHelper
import com.vicky7230.cambio.data.network.AppApiHelper
import com.vicky7230.cambio.di.ApplicationContext
import com.vicky7230.cambio.di.BaseUrl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by vicky on 31/12/17.
 */
@Module
class ApplicationModule {

    @Provides
    @ApplicationContext
    internal fun provideContext(cambioApplication: CambioApplication): Context {
        return cambioApplication.applicationContext
    }

    @Provides
    internal fun provideApplication(cambioApplication: CambioApplication): Application {
        return cambioApplication
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)!!
    }

    @Provides
    @BaseUrl
    internal fun provideBaseUrl(): String {
        return Config.BASE_URL
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }

    /*@Provides
    @Singleton
    internal fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }*/
}