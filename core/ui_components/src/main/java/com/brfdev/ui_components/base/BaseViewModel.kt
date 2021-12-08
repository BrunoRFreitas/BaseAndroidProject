package com.brfdev.ui_components.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.brfdev.domain.model.ErrorResponse
import com.brfdev.domain.model.NetworkResponse

open class BaseViewModel() : ViewModel() {

    val onError = MutableLiveData<NetworkResponse.ApiError<ErrorResponse>>()
    val onProgress = MutableLiveData<Boolean>()

    fun onErrorReturn(result: NetworkResponse.ApiError<ErrorResponse>) {
        onProgress.value = false
        onError.value = result

    }
}