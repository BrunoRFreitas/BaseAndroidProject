package com.brfdev.feature1

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeatureOneActivity: AppCompatActivity() {

    private val mViewModel: FeatureOneViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_one)

        setButton()
    }

    private fun setButton() {

        val btnFeatureOne = findViewById<Button>(R.id.btn_feature_one)

        btnFeatureOne.setOnClickListener{
            mViewModel.getTesteError()
        }

        mViewModel.testeError.observe(this){
            Toast.makeText(this, it.erro, Toast.LENGTH_SHORT).show()
        }
    }
}