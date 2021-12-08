package com.brfdev.data.remote

import com.brfdev.domain.model.ErrorResponse
import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.ResponseTesteSuccess

interface SuccessRemoteDataSource {

    suspend fun getTeste(): NetworkResponse<ResponseTesteSuccess, ErrorResponse>
}