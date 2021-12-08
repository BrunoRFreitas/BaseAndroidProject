package com.brfdev.feature1.frag2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.ResponseTesteSuccess
import com.brfdev.domain.repository.SuccessRepository
import com.brfdev.ui_components.base.BaseViewModel
import com.brfdev.ui_components.utils.SingleLiveData
import kotlinx.coroutines.launch

class FragTwoFeatureOneViewModel(
    private val repositorySuccess: SuccessRepository
): BaseViewModel() {

    private val _testeSuccess = SingleLiveData<ResponseTesteSuccess>()
    val testeSuccess: LiveData<ResponseTesteSuccess> = _testeSuccess

    fun getTesteSuccess() {

        viewModelScope.launch {
            onProgress.value = true
            when (val result = repositorySuccess.getTeste()) {
                is NetworkResponse.Success -> {
                    onProgress.value = false
                    _testeSuccess.value = result.body
                }
                is NetworkResponse.ApiError -> {
                    onErrorReturn(result)
                }
            }
        }
    }
}