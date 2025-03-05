package com.amoferreira.runiverse

import android.app.Application
import com.amoferreira.auth.data.di.authDataModule
import com.amoferreira.auth.presentation.di.authViewModelModule
import com.amoferreira.runiverse.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniverseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniverseApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
            )
        }
    }
}