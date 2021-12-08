package com.brfdev.data.remote

import com.brfdev.domain.model.ErrorResponse
import com.brfdev.domain.model.NetworkResponse

interface ErrorRemoteDataSource {

    suspend fun getTesteError(): NetworkResponse<Void, ErrorResponse>
}