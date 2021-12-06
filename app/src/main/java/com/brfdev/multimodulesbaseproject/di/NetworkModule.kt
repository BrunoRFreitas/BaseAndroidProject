package com.brfdev.multimodulesbaseproject.di

import com.brfdev.network.adapter.NetworkResponseAdapterFactory
import com.brfdev.network.createService
import com.brfdev.domain.repository.ErrorRepository
import com.brfdev.domain.repository.SuccessRepository
import com.brfdev.repository_impl.ErrorRepositoryImpl
import com.brfdev.repository_impl.SuccessRepositoryImpl
import com.brfdev.services.TesteServiceError
import com.brfdev.services.TesteServiceSuccess
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val repositoryModule = module {
    factory<SuccessRepository> { SuccessRepositoryImpl(Dispatchers.IO, get()) }
    factory<ErrorRepository> { ErrorRepositoryImpl(Dispatchers.IO, get()) }
}

val networkModule = module {
    val myCallAdapter = NetworkResponseAdapterFactory()

    single {
        createService(TesteServiceError::class.java, myCallAdapter)
    }

    single {
        createService(TesteServiceSuccess::class.java, myCallAdapter)
    }
}