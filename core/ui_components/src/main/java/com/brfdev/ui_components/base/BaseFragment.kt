package com.brfdev.ui_components.base

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.brfdev.domain.model.NetworkException
import com.brfdev.ui_components.utils.DialogUtils
import com.brfdev.ui_components.utils.ProgressUtil

abstract class BaseFragment : Fragment() {

    val progress by lazy {
        ProgressUtil(activity)
    }

    private lateinit var viewModel: BaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getResourceView(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = mViewModel()
        setupView()
        progresso(progress())
        erro()
    }

    private fun erro() {
        viewModel.onError.observe(viewLifecycleOwner) {
            viewModel.onProgress.value = false
            if (it != null) {
                if (it.body != null) {
                    baseError(it.body!!.erro)
                } else {
                    baseError(getString(it.exception!!.message))
                }

//                if (it.errors != null && it.errors.isNotEmpty()) {
//                    errors(it.errors)
//                } else if (it.error != null) {
//                    error(it.error)
//                } else {
//                    error(ErrorResponse().genericError)
//                }
            } else {
                baseError(getString(NetworkException.getNotFoundException().message))
            }
        }
    }

    protected abstract fun mViewModel(): BaseViewModel

    @LayoutRes
    protected abstract fun getResourceView(): Int

    protected abstract fun setupView()

    open fun progress(): Boolean {
        return false
    }

    open fun baseError(error: String) {
        DialogUtils().showDialog(
            requireActivity(),
            "Oops",
            error,
            false,
            "Ok",
        ) { _: DialogInterface, _: Int ->
            requireActivity().onBackPressed();
        }
    }

    open fun esconderTeclado() {
        if (activity != null && requireActivity().currentFocus != null) {
            val imm =
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.hideSoftInputFromWindow(requireActivity().currentFocus!!.windowToken, 0)
        }
    }

    private fun progresso(ativo: Boolean) {
        if (ativo) {
            viewModel.onProgress.observe(viewLifecycleOwner) {
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