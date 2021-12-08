package com.brfdev.feature1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.brfdev.domain.model.ErrorResponse
import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.repository.ErrorRepository
import com.brfdev.ui_components.base.BaseViewModel
import kotlinx.coroutines.launch

class FeatureOneViewModel(
    private val repositoryError: ErrorRepository
) : BaseViewModel() {

    private val _testeError = MutableLiveData<ErrorResponse>()
    val testeError: LiveData<ErrorResponse> = _testeError

    fun getTesteError() {

        viewModelScope.launch {
            onProgress.value = true
            when (val result = repositoryError.getTesteError()) {
                is NetworkResponse.Success -> {
                    onProgress.value = false
                    Log.e("BRUNO-TESTE", "NetworkSuccess")
                }
                is NetworkResponse.ApiError -> {
                    onErrorReturn(result)

                    if(result.body != null){
                        Log.e("BRUNO-TESTE", "ApiError ${result.body!!.erro}")
                    }else{
                        Log.e("BRUNO-TESTE", "ApiError ${result.exception!!.message}")
                    }
                }
            }
        }
    }
}