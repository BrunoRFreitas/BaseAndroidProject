package com.brfdev.navigation.navigators.feature1

import androidx.fragment.app.Fragment
import com.brfdev.feature1.frag1.FragOneFeatureOneDirections
import com.brfdev.feature1.frag1.FragOneFeatureOneNavigation
import com.brfdev.ui_components.extensions.navigate

class FragOneFeatureOneNavigationImpl(private val fragment: Fragment): FragOneFeatureOneNavigation {
    override fun navigateToNext() = fragment.navigate(
       FragOneFeatureOneDirections.navigateToFragTwoFeatureOne()
    )
}