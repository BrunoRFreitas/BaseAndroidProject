package com.brfdev.di

import com.brfdev.feature1.FeatureOneViewModel
import com.brfdev.feature2.FeatureTwoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { FeatureOneViewModel(get()) }
    viewModel { FeatureTwoViewModel(get()) }
}