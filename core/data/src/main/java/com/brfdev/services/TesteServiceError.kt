package com.brfdev.services

import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.ErrorResponse
import retrofit2.http.GET

interface TesteServiceError {

    @GET("errorTeste")
    suspend fun getErrorTeste(): NetworkResponse<Void, ErrorResponse>
}