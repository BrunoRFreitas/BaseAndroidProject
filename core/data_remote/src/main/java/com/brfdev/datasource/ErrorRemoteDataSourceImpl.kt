package com.brfdev.datasource

import com.brfdev.data.remote.ErrorRemoteDataSource
import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.ErrorResponse
import com.brfdev.services.TesteServiceError
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ErrorRemoteDataSourceImpl(
    private val dispatcher: CoroutineDispatcher,
    private val api: TesteServiceError
) : ErrorRemoteDataSource {

    override suspend fun getTesteError(): NetworkResponse<Void, ErrorResponse> {
        return withContext(dispatcher) {
            delay(3000)
            api.getErrorTeste()
        }
    }

}