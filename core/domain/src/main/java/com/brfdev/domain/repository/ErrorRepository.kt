package com.brfdev.domain.repository

import com.brfdev.domain.model.ResponseTesteSuccess

interface ErrorRepository {
    suspend fun getTesteError(): Void
}