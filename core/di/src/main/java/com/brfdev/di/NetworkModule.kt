package com.brfdev.di

import com.brfdev.network.adapter.NetworkResponseAdapterFactory
import com.brfdev.network.createService
import com.brfdev.services.TesteServiceError
import com.brfdev.services.TesteServiceSuccess
import org.koin.dsl.module

val networkModule = module {
    val myCallAdapter = NetworkResponseAdapterFactory()

    single {
        createService(TesteServiceError::class.java, myCallAdapter)
    }

    single {
        createService(TesteServiceSuccess::class.java, myCallAdapter)
    }
}