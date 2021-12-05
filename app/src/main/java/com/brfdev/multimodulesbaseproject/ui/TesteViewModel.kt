package com.brfdev.multimodulesbaseproject.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brfdev.domain.repository.SuccessRepository
import com.brfdev.domain.model.ResponseTesteSuccess
import com.brfdev.domain.repository.ErrorRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class TesteViewModel(
    private val repositorySuccess: SuccessRepository,
    private val repositoryError: ErrorRepository
): ViewModel() {

    private val _testeSuccess = MutableLiveData<ResponseTesteSuccess>()
    val testeSuccess: LiveData<ResponseTesteSuccess> = _testeSuccess

    fun getTeste(){

        viewModelScope.launch {
            try {
                val response = repositorySuccess.getTeste()
                _testeSuccess.postValue(response)

                getTesteError()
            }
            catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    private val _testeError = MutableLiveData<Void>()
    val testeError: LiveData<Void> = _testeError

    fun getTesteError(){

        viewModelScope.launch {
            try {
                val response = repositoryError.getTesteError()
                _testeError.postValue(response)
                Log.d("TESTE-BRUNO", "Teste Error")
            }
            catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}