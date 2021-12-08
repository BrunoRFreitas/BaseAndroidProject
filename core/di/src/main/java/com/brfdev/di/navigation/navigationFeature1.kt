package com.brfdev.di.navigation

import androidx.fragment.app.Fragment
import com.brfdev.feature1.frag1.FragOneFeatureOneNavigation
import com.brfdev.feature1.frag2.FragTwoFeatureOneNavigation
import com.brfdev.navigation.navigators.feature1.FragOneFeatureOneNavigationImpl
import com.brfdev.navigation.navigators.feature1.FragTwoFeatureOneNavigationImpl
import org.koin.dsl.module

val navigationFeature1 = module {
    factory <FragOneFeatureOneNavigation>{ (fragment: Fragment) -> FragOneFeatureOneNavigationImpl(fragment) }
    factory <FragTwoFeatureOneNavigation>{ (fragment: Fragment) -> FragTwoFeatureOneNavigationImpl(fragment) }
}