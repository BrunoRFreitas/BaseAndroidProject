package com.brfdev.feature1.base

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.brfdev.domain.model.NetworkException

abstract class BaseActivity: AppCompatActivity() {
    val progress by lazy {
        ProgressUtil(this)
    }

    private lateinit var viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentView())

        viewModel = mViewModel()
        setupView()
        progresso(progress())
        erro()
    }

    protected abstract fun contentView(): Int

    private fun erro() {
        viewModel.onError.observe(this) {
            viewModel.onProgress.value = false
            if (it != null) {
                if (it.body != null) {
                    baseError(it.body!!.erro)
                } else {
                    baseError(getString(it.exception!!.message))
                }
            } else {
                baseError(getString(NetworkException.getNotFoundException().message))
            }
        }
    }

    protected abstract fun mViewModel(): BaseViewModel

    protected abstract fun setupView()

    open fun progress(): Boolean {
        return true
    }

    open fun baseError(error: String) {
        DialogUtils().showDialog(
            this,
            "Oops",
            error,
            false,
            "Ok",
        ) { _: DialogInterface, _: Int ->
            this.onBackPressed();
        }
    }

    open fun esconderTeclado() {
        if (this.currentFocus != null) {
            val imm =
                this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.hideSoftInputFromWindow(this.currentFocus!!.windowToken, 0)
        }
    }

    private fun progresso(ativo: Boolean) {
        if (ativo) {
            viewModel.onProgress.observe(this) {
                if (it) {
                    progress.showProgress()
                    esconderTeclado()
                } else {
                    object : CountDownTimer(200, 50) {
                        override fun onTick(millisUntilFinished: Long) {}

                        override fun onFinish() {
                            progress.hideProgress()
                        }
                    }.start()
                }
            }
        }
    }
}