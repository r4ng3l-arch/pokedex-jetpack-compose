package com.r4ng3l.jetpackcomposepokedex

import android.app.Application
import com.r4ng3l.jetpackcomposepokedex.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokedexApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokedexApp)
            modules(appModule)  // Add your Koin module here
        }
    }
}