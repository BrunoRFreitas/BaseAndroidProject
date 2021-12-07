package com.brfdev.domain.repository

import com.brfdev.domain.model.ErrorResponse
import com.brfdev.domain.model.NetworkResponse

interface ErrorRepository {
    suspend fun getTesteError(): NetworkResponse<Void, ErrorResponse>
}