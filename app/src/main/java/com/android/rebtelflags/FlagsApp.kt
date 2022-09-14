package com.android.rebtelflags

import android.app.Application
import com.android.rebtelflags.di.repositoryModule
import com.android.rebtelflags.di.viewModelModule
import com.android.rebtelflags.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FlagsApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@FlagsApp)
            modules(listOf(repositoryModule, networkModule, viewModelModule))
        }
    }
}