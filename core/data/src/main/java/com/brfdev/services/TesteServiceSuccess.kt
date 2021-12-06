package com.brfdev.services

import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.Error
import com.brfdev.domain.model.ResponseTesteSuccess
import retrofit2.http.GET

interface TesteServiceSuccess {

    @GET("teste")
    suspend fun getTeste(): NetworkResponse<ResponseTesteSuccess, Error>
}