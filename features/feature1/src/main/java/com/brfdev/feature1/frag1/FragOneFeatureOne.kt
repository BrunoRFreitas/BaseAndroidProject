package com.brfdev.feature1.frag1

import com.brfdev.feature1.databinding.FragmentOneFeatureOneBinding
import com.brfdev.ui_components.base.BaseFragment
import com.brfdev.ui_components.extensions.navDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragOneFeatureOne: BaseFragment<FragmentOneFeatureOneBinding>(FragmentOneFeatureOneBinding::inflate) {

    private val mNavigation: FragOneFeatureOneNavigation by navDirections()
    private val mViewModel: FragOneFeatureOneViewModel by viewModel()

    override fun mViewModel() = mViewModel

    override fun setupView() {

        binding.btnFragOneFeatureOne.setOnClickListener {
            mViewModel.getTesteSuccess()
        }

        mViewModel.testeSuccess.observe(this){
            mNavigation.navigateToNext()
        }
    }
}