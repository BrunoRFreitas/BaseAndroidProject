package com.brfdev.feature2.fragments.frag1

import com.brfdev.feature2.databinding.FragmentOneFeatureTwoBinding
import com.brfdev.ui_components.base.BaseFragment
import com.brfdev.ui_components.base.BaseViewModel
import com.brfdev.ui_components.extensions.navDirections

class FragOneFeatureTwo: BaseFragment<FragmentOneFeatureTwoBinding>(FragmentOneFeatureTwoBinding::inflate) {

    private val mNavigation: FragOneFeatureTwoNavigation by navDirections()


    override fun mViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    override fun setupView() {
        binding.btnFragOneFeatureOne.setOnClickListener {
            mNavigation.navigateToNext()
        }
    }
}