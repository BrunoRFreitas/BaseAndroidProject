package com.brfdev.feature2.fragments.frag1

import com.brfdev.feature2.databinding.FragmentOneFeatureTwoBinding
import com.brfdev.ui_components.base.BaseFragment
import com.brfdev.ui_components.extensions.navDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragOneFeatureTwo: BaseFragment<FragmentOneFeatureTwoBinding>(FragmentOneFeatureTwoBinding::inflate) {

    private val mViewModel: FragOneFeatureTwoViewModel by viewModel()
    private val mNavigation: FragOneFeatureTwoNavigation by navDirections()

    override fun mViewModel() = mViewModel

    override fun setupView() {
        binding.btnFragOneFeatureOne.setOnClickListener {
            mNavigation.navigateToNext()
        }
    }
}