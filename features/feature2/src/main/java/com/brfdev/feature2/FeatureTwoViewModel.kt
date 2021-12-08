package com.brfdev.feature2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.repository.SuccessRepository
import com.brfdev.domain.model.ResponseTesteSuccess
import com.brfdev.domain.repository.ErrorRepository
import com.brfdev.ui_components.base.BaseViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class FeatureTwoViewModel(
    private val repositorySuccess: SuccessRepository,
): BaseViewModel() {

    private val _testeSuccess = MutableLiveData<ResponseTesteSuccess>()
    val testeSuccess: LiveData<ResponseTesteSuccess> = _testeSuccess

    fun getTeste(){

        viewModelScope.launch {
            onProgress.value = true
            when (val result = repositorySuccess.getTeste()) {
                is NetworkResponse.Success -> {
                    _testeSuccess.postValue(result.body)
                    onProgress.value = false
                }
                is NetworkResponse.ApiError -> {
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