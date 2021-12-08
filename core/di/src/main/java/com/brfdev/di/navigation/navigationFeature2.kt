package com.brfdev.di.navigation

import androidx.fragment.app.Fragment
import com.brfdev.feature2.fragments.frag1.FragOneFeatureTwoNavigation
import com.brfdev.navigation.navigators.feature2.FragOneFeatureTwoNavigationImpl
import org.koin.dsl.module

val navigationFeature2 = module {
    factory <FragOneFeatureTwoNavigation>{ (fragment: Fragment) -> FragOneFeatureTwoNavigationImpl(fragment) }
}