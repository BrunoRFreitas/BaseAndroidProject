package com.brfdev.multimodulesbaseproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.brfdev.multimodulesbaseproject.BuildConfig
import com.brfdev.multimodulesbaseproject.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mViewModel: TesteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getTestSuccess()
        setVersionName(BuildConfig.VERSION_NAME)
    }

    private fun getTestSuccess() {

        mViewModel.getTeste()
        mViewModel.testeSuccess.observe(this){
            Log.d("TESTE-BRUNO", it.nome)
        }
    }

    private fun setVersionName(versionName: String) {
        val tvVersao = findViewById<TextView>(R.id.tv_versao)
        tvVersao.text = versionName
    }
}