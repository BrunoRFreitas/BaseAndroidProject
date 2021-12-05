package com.brfdev.services

import com.brfdev.domain.model.ResponseTesteSuccess
import retrofit2.http.GET
import retrofit2.http.Path

interface TesteServiceSuccess {

    @GET("teste")
    suspend fun getTeste(): ResponseTesteSuccess
}