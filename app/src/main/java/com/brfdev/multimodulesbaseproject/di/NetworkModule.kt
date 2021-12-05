package com.brfdev.multimodulesbaseproject.di

import com.brfdev.data.createService
import com.brfdev.domain.repository.ErrorRepository
import com.brfdev.domain.repository.SuccessRepository
import com.brfdev.repository_impl.ErrorRepositoryImpl
import com.brfdev.repository_impl.SuccessRepositoryImpl
import com.brfdev.services.TesteServiceError
import com.brfdev.services.TesteServiceSuccess
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val networkModule = module {
    factory<SuccessRepository> {
        SuccessRepositoryImpl(
            Dispatchers.IO,
            createService(TesteServiceSuccess::class.java)
        )
    }

    factory<ErrorRepository> {
        ErrorRepositoryImpl(
            Dispatchers.IO,
            createService(TesteServiceError::class.java)
        )
    }
}