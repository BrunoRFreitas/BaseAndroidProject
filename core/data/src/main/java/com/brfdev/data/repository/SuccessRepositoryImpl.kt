package com.brfdev.data.repository

import com.brfdev.data.remote.SuccessRemoteDataSource
import com.brfdev.domain.model.ErrorResponse
import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.ResponseTesteSuccess
import com.brfdev.domain.repository.SuccessRepository

class SuccessRepositoryImpl(
    private val successRemoteDataSource: SuccessRemoteDataSource
): SuccessRepository {

    override suspend fun getTeste(): NetworkResponse<ResponseTesteSuccess, ErrorResponse> {
        return successRemoteDataSource.getTeste()
    }
}