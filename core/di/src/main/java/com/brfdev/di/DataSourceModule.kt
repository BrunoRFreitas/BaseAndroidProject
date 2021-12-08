package com.brfdev.di

import com.brfdev.data.remote.ErrorRemoteDataSource
import com.brfdev.data.remote.SuccessRemoteDataSource
import com.brfdev.datasource.ErrorRemoteDataSourceImpl
import com.brfdev.datasource.SuccessRemoteDataSourceImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dataSourceModule = module {
    factory<SuccessRemoteDataSource> { SuccessRemoteDataSourceImpl(Dispatchers.IO, get()) }
    factory<ErrorRemoteDataSource> { ErrorRemoteDataSourceImpl(Dispatchers.IO, get()) }
}