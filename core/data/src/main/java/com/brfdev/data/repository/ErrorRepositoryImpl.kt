package com.brfdev.data.repository

import com.brfdev.data.remote.ErrorRemoteDataSource
import com.brfdev.domain.model.ErrorResponse
import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.repository.ErrorRepository

class ErrorRepositoryImpl(
    private val erroRemoteDataSource: ErrorRemoteDataSource
): ErrorRepository {

    override suspend fun getTesteError(): NetworkResponse<Void, ErrorResponse> {
        return erroRemoteDataSource.getTesteError()
    }
}