package com.brfdev.feature1

import android.util.Log
import android.widget.Button
import com.brfdev.ui_components.base.BaseActivity
import com.brfdev.ui_components.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeatureOneActivityV2 : BaseActivity() {

    private val mViewModel: FeatureOneViewModel by viewModel()

    override fun contentView(): Int {
        return R.layout.activity_feature_one
    }

    override fun mViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun setupView() {
        Log.e("BRUNO-TESTE", "teste")
        setButton()
    }

    private fun setButton() {

        val btnFeatureOne = findViewById<Button>(R.id.btn_feature_one)

        btnFeatureOne.setOnClickListener {
            mViewModel.getTesteError()
        }

        mViewModel.testeError.observe(this) {
            Log.e("BRUNO-TESTE", it.erro)
        }
    }
}