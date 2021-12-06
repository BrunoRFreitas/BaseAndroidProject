package com.brfdev.domain.repository

import com.brfdev.domain.model.Error
import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.ResponseTesteSuccess

interface ErrorRepository {
    suspend fun getTesteError(): NetworkResponse<Void, Error>
}