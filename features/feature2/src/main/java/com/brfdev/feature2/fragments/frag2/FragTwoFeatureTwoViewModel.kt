package com.brfdev.feature2.fragments.frag2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.ResponseTesteSuccess
import com.brfdev.domain.repository.ErrorRepository
import com.brfdev.domain.repository.SuccessRepository
import com.brfdev.ui_components.base.BaseViewModel
import kotlinx.coroutines.launch

class FragTwoFeatureTwoViewModel(
    private val repositoryError: ErrorRepository
): BaseViewModel() {

    private val _testeError = MutableLiveData<Void>()
    val testeError: LiveData<Void> = _testeError

    fun getTesteSuccess() {

        viewModelScope.launch {
            onProgress.value = true
            when (val result = repositoryError.getTesteError()) {
                is NetworkResponse.Success -> {
                    onProgress.value = false
                    _testeError.postValue(result.body)
                }
                is NetworkResponse.ApiError -> {
                    onErrorReturn(result)
                }
            }
        }
    }
}