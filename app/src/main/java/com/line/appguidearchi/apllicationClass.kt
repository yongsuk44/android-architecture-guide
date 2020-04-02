package com.line.appguidearchi

import android.app.Application
import com.line.appguidearchi.modules.apiModule
import com.line.appguidearchi.modules.networkModule
import com.line.appguidearchi.modules.profileModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class applicationClass : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@applicationClass)
            modules(listOf(profileModule , networkModule , apiModule))
        }
    }
}