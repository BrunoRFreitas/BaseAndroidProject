package com.brfdev.domain.repository

import com.brfdev.domain.model.Error
import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.ResponseTesteSuccess

interface SuccessRepository {

    suspend fun getTeste(): NetworkResponse<ResponseTesteSuccess, Error>
}