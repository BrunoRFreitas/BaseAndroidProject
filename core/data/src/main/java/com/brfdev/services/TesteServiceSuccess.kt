package com.brfdev.services

import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.ErrorResponse
import com.brfdev.domain.model.ResponseTesteSuccess
import retrofit2.http.GET

interface TesteServiceSuccess {

    @GET("teste")
    suspend fun getTeste(): NetworkResponse<ResponseTesteSuccess, ErrorResponse>
}