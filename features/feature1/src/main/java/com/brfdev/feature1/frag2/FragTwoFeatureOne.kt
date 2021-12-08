package com.brfdev.feature1.frag2

import android.util.Log
import com.brfdev.feature1.databinding.FragmentTwoFeatureOneBinding
import com.brfdev.ui_components.base.BaseFragment
import com.brfdev.ui_components.base.BaseViewModel
import com.brfdev.ui_components.extensions.navDirections

class FragTwoFeatureOne: BaseFragment<FragmentTwoFeatureOneBinding>(FragmentTwoFeatureOneBinding::inflate) {

    private val mNavigation: FragTwoFeatureOneNavigation by navDirections()

    override fun mViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    override fun setupView() {
        binding.btnFragTwoFeatureOne.setOnClickListener {
            mNavigation.navigateToNext()
        }
    }
}