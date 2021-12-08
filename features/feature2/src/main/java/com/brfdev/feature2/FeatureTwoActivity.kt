package com.brfdev.feature2

import com.brfdev.ui_components.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class FeatureTwoActivity: BaseActivity() {

    private val mViewModel: FeatureTwoViewModel by viewModel()

    override fun contentView() = R.layout.layout

    override fun mViewModel() = mViewModel

    override fun setupView() {

    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        setVersionName(BuildConfig.VERSION_NAME)
////        getTestSuccess()
//        val intent = Intent(this, FeatureOneActivity::class.java)
//        startActivity(intent)
//    }
//
//    private fun getTestSuccess() {
//
//        mViewModel.getTeste()
//        mViewModel.testeSuccess.observe(this){
//            Log.d("TESTE-BRUNO", it.nome)
//
//            val intent = Intent(this, FeatureOneActivity::class.java)
//            startActivity(intent)
//        }
//    }
//
//    private fun setVersionName(versionName: String) {
//        val tvVersao = findViewById<TextView>(R.id.tv_versao)
//        tvVersao.text = versionName
//    }
}