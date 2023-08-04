package com.keepcoding.finalproject

import android.app.Application
import com.keepcoding.finalproject.di.dataModule
import com.keepcoding.finalproject.di.domainModule
import com.keepcoding.finalproject.di.presentationModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.INFO
                } else {
                    Level.NONE
                }
            )
            androidContext(this@MovieApplication)
            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }
    }
}
