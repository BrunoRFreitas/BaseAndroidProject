package com.brfdev.multimodulesbaseproject.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.repository.SuccessRepository
import com.brfdev.domain.model.ResponseTesteSuccess
import com.brfdev.domain.repository.ErrorRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class TesteViewModel(
    private val repositorySuccess: SuccessRepository,
): ViewModel() {

    private val _testeSuccess = MutableLiveData<ResponseTesteSuccess>()
    val testeSuccess: LiveData<ResponseTesteSuccess> = _testeSuccess

    fun getTeste(){

        viewModelScope.launch {
            when (val result = repositorySuccess.getTeste()) {
                is NetworkResponse.Success -> {
                    _testeSuccess.postValue(result.body)
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