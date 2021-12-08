package com.brfdev.multimodulesbaseproject.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.brfdev.multimodulesbaseproject.BuildConfig
import com.brfdev.multimodulesbaseproject.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setVersionName(BuildConfig.VERSION_NAME)
        showActivityFeatureOne()
    }

    private fun setVersionName(versionName: String) {
        val tvVersao = findViewById<TextView>(R.id.tv_versao)
        tvVersao.text = versionName
    }

    fun showActivityFeatureOne() {
        val bundle = Bundle()
        replaceActivity(
            "com.brfdev.feature1.FeatureOneActivity",
            bundle,
            true
        )
    }

    fun replaceActivity(modulePath: String?, bundle: Bundle?, finish: Boolean) {
        replaceActivity(this, modulePath, bundle, finish)
    }

    fun replaceActivity(context: Context, modulePath: String?, bundle: Bundle?, finish: Boolean) {
        var intent: Intent? = null
        try {
            intent = Intent(
                context,
                Class.forName(modulePath)
            )
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
        if (bundle != null) intent!!.putExtras(bundle)
        if (intent?.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
//            (context as Activity).overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
//            if (finish) {
//                context.finish()
//            }
        } else {
//            errorIntent(context)
            Log.d("Error", "No Intent available to handle action")
        }
    }
}