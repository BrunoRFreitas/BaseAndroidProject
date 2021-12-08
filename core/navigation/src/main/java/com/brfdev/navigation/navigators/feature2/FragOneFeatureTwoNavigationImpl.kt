package com.brfdev.navigation.navigators.feature2

import androidx.fragment.app.Fragment
import com.brfdev.feature2.fragments.frag1.FragOneFeatureTwoDirections
import com.brfdev.feature2.fragments.frag1.FragOneFeatureTwoNavigation
import com.brfdev.ui_components.extensions.navigate

class FragOneFeatureTwoNavigationImpl(private val fragment: Fragment): FragOneFeatureTwoNavigation {
    override fun navigateToNext() = fragment.navigate(
        FragOneFeatureTwoDirections.navigateToFragTwoFeatureTwo()
    )
}