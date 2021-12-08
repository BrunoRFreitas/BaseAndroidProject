package com.brfdev.di

import com.brfdev.feature1.frag1.FragOneFeatureOneViewModel
import com.brfdev.feature1.frag2.FragTwoFeatureOneViewModel
import com.brfdev.feature2.FeatureTwoViewModel
import com.brfdev.feature2.fragments.frag1.FragOneFeatureTwoViewModel
import com.brfdev.feature2.fragments.frag2.FragTwoFeatureTwoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { FragOneFeatureOneViewModel(get()) }
    viewModel { FragTwoFeatureOneViewModel(get()) }
    viewModel { FragOneFeatureTwoViewModel(get()) }
    viewModel { FragTwoFeatureTwoViewModel(get()) }
}