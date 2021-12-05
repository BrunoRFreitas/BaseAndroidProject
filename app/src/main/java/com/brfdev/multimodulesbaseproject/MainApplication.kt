package com.brfdev.multimodulesbaseproject

import android.app.Application
import com.brfdev.multimodulesbaseproject.di.networkModule
import com.brfdev.multimodulesbaseproject.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }

    private fun setupKoin(){
        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    viewModelModule,
                    networkModule
                )
            )
        }
    }
}