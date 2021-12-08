package com.brfdev.navigation.navigators.feature1

import androidx.fragment.app.Fragment
import com.brfdev.feature1.frag2.FragTwoFeatureOneDirections
import com.brfdev.feature1.frag2.FragTwoFeatureOneNavigation
import com.brfdev.ui_components.extensions.navigate

class FragTwoFeatureOneNavigationImpl(private val fragment: Fragment) :
    FragTwoFeatureOneNavigation {

    override fun navigateToNext() = fragment.navigate(
        FragTwoFeatureOneDirections.navigateToFragOneFeatureTwo()
    )
}