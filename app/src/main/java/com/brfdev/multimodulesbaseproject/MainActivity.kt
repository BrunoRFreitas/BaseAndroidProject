package com.brfdev.multimodulesbaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setVersionName(BuildConfig.VERSION_NAME)
    }

    private fun setVersionName(versionName: String) {
        val tvVersao = findViewById<TextView>(R.id.tv_versao)
        tvVersao.text = versionName
    }
}