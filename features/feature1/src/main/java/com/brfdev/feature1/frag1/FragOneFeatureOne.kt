package com.brfdev.feature1.frag1

import android.widget.Button
import com.brfdev.feature1.R
import com.brfdev.feature1.databinding.FragmentOneFeatureOneBinding
import com.brfdev.ui_components.base.BaseFragment
import com.brfdev.ui_components.base.BaseViewModel
import com.brfdev.ui_components.extensions.navDirections

class FragOneFeatureOne: BaseFragment<FragmentOneFeatureOneBinding>(FragmentOneFeatureOneBinding::inflate) {

    private val mNavigation: FragOneFeatureOneNavigation by navDirections()

    override fun mViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    override fun setupView() {
        binding.btnFragOneFeatureOne.setOnClickListener {
            mNavigation.navigateToNext()
        }
    }
}