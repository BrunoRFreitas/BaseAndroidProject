package com.brfdev.feature1.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brfdev.domain.model.ErrorResponse
import com.brfdev.domain.model.NetworkResponse
import kotlinx.coroutines.launch

open class BaseViewModel() : ViewModel() {

    val onError = MutableLiveData<NetworkResponse.ApiError<ErrorResponse>>()
    val onProgress = MutableLiveData<Boolean>()

    fun onErrorReturn(result: NetworkResponse.ApiError<ErrorResponse>) {
        onProgress.value = false
        onError.value = result

    }
}