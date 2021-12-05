package com.brfdev.services

import retrofit2.http.GET

interface TesteServiceError {

    @GET("errorTeste")
    suspend fun getErrorTeste(): Void
}