package com.brfdev.feature2.fragments.frag2

import com.brfdev.feature2.databinding.FragmentTwoFeatureTwoBinding
import com.brfdev.ui_components.base.BaseFragment
import com.brfdev.ui_components.base.BaseViewModel

class FragTwoFeatureTwo:BaseFragment<FragmentTwoFeatureTwoBinding>(FragmentTwoFeatureTwoBinding::inflate) {
    override fun mViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    override fun setupView() {
        binding.btnFragOneFeatureOne.setOnClickListener {

        }
    }
}