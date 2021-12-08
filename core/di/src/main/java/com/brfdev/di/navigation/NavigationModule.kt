package com.brfdev.di.navigation

import androidx.fragment.app.Fragment
import com.brfdev.feature1.frag1.FragOneFeatureOneNavigation
import com.brfdev.navigation.navigators.feature1.FragOneFeatureOneNavigationImpl
import org.koin.dsl.module

val navigationModule = module {
    factory <FragOneFeatureOneNavigation>{ (fragment: Fragment) -> FragOneFeatureOneNavigationImpl(fragment) }
}