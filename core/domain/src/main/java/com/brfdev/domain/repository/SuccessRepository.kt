package com.brfdev.domain.repository

import com.brfdev.domain.model.ResponseTesteSuccess

interface SuccessRepository {

    suspend fun getTeste(): ResponseTesteSuccess
}