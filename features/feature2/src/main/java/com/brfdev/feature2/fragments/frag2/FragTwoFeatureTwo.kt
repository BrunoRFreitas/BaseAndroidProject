package com.brfdev.feature2.fragments.frag2

import com.brfdev.feature2.databinding.FragmentTwoFeatureTwoBinding
import com.brfdev.feature2.fragments.frag1.FragOneFeatureTwoViewModel
import com.brfdev.ui_components.base.BaseFragment
import com.brfdev.ui_components.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragTwoFeatureTwo:BaseFragment<FragmentTwoFeatureTwoBinding>(FragmentTwoFeatureTwoBinding::inflate) {

    private val mViewModel: FragTwoFeatureTwoViewModel by viewModel()

    override fun mViewModel() = mViewModel

    override fun setupView() {
        binding.btnFragOneFeatureOne.setOnClickListener {
            mViewModel.getTesteSuccess()
        }
    }
}