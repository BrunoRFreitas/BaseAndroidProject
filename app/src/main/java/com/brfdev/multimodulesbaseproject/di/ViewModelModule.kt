package com.brfdev.multimodulesbaseproject.di

import com.brfdev.feature1.FeatureOneViewModel
import com.brfdev.multimodulesbaseproject.ui.TesteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { TesteViewModel(get()) }
    viewModel { FeatureOneViewModel(get()) }
}