package com.brfdev.multimodulesbaseproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.brfdev.feature1.FeatureOneActivity
import com.brfdev.multimodulesbaseproject.BuildConfig
import com.brfdev.multimodulesbaseproject.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mViewModel: TesteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setVersionName(BuildConfig.VERSION_NAME)
//        getTestSuccess()
        val intent = Intent(this, FeatureOneActivity::class.java)
        startActivity(intent)
    }

    private fun getTestSuccess() {

        mViewModel.getTeste()
        mViewModel.testeSuccess.observe(this){
            Log.d("TESTE-BRUNO", it.nome)

            val intent = Intent(this, FeatureOneActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setVersionName(versionName: String) {
        val tvVersao = findViewById<TextView>(R.id.tv_versao)
        tvVersao.text = versionName
    }
}