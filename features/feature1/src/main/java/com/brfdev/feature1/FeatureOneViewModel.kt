package com.brfdev.feature1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brfdev.domain.model.Error
import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.ResponseTesteSuccess
import com.brfdev.domain.repository.ErrorRepository
import com.brfdev.domain.repository.SuccessRepository
import kotlinx.coroutines.launch

class FeatureOneViewModel(
    private val repositoryError: ErrorRepository
) : ViewModel() {

    private val _testeError = MutableLiveData<Error>()
    val testeError: LiveData<Error> = _testeError

    fun getTesteError() {

        viewModelScope.launch {
            when (val result = repositoryError.getTesteError()) {
                is NetworkResponse.Success -> {
                    Log.e("BRUNO-TESTE", "NetworkSuccess")
                }
                is NetworkResponse.ApiError -> {
                    _testeError.postValue(result.body)
                }
                is NetworkResponse.NetworkError -> Log.e("BRUNO-TESTE", "NetworkError")
                is NetworkResponse.UnknownError -> Log.e("BRUNO-TESTE", "UnknownError")
            }
        }
    }
}