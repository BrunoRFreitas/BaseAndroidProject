package com.brfdev.services

import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.Error
import retrofit2.http.GET

interface TesteServiceError {

    @GET("errorTeste")
    suspend fun getErrorTeste(): NetworkResponse<Void, Error>
}