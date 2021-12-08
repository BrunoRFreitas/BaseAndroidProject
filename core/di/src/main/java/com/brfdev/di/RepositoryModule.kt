package com.brfdev.di

import com.brfdev.data.repository.ErrorRepositoryImpl
import com.brfdev.data.repository.SuccessRepositoryImpl
import com.brfdev.domain.repository.ErrorRepository
import com.brfdev.domain.repository.SuccessRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<SuccessRepository> { SuccessRepositoryImpl(get()) }
    factory<ErrorRepository> { ErrorRepositoryImpl(get()) }
}