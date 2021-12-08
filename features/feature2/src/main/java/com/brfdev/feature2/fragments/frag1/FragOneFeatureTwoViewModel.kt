package com.brfdev.feature2.fragments.frag1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.ResponseTesteSuccess
import com.brfdev.domain.repository.SuccessRepository
import com.brfdev.ui_components.base.BaseViewModel
import com.brfdev.ui_components.utils.SingleLiveData
import kotlinx.coroutines.launch

class FragOneFeatureTwoViewModel(
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
                    _testeSuccess.postValue(result.body)
                }
                is NetworkResponse.ApiError -> {
                    onErrorReturn(result)
                }
            }
        }
    }
}