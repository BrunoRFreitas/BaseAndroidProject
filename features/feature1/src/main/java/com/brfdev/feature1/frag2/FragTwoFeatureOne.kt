package com.brfdev.feature1.frag2

import android.util.Log
import com.brfdev.feature1.databinding.FragmentTwoFeatureOneBinding
import com.brfdev.feature1.frag1.FragOneFeatureOneViewModel
import com.brfdev.ui_components.base.BaseFragment
import com.brfdev.ui_components.base.BaseViewModel
import com.brfdev.ui_components.extensions.navDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragTwoFeatureOne: BaseFragment<FragmentTwoFeatureOneBinding>(FragmentTwoFeatureOneBinding::inflate) {

    private val mViewModel: FragTwoFeatureOneViewModel by viewModel()
    private val mNavigation: FragTwoFeatureOneNavigation by navDirections()

    override fun mViewModel() = mViewModel

    override fun setupView() {
        binding.btnFragTwoFeatureOne.setOnClickListener {
            mViewModel.getTesteSuccess()
        }

        mViewModel.testeSuccess.observe(this){
            mNavigation.navigateToNext()
        }
    }
}