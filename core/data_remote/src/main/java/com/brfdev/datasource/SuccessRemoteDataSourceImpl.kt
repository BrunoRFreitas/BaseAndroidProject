package com.brfdev.datasource

import com.brfdev.data.remote.SuccessRemoteDataSource
import com.brfdev.domain.model.ErrorResponse
import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.ResponseTesteSuccess
import com.brfdev.services.TesteServiceSuccess
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SuccessRemoteDataSourceImpl(
    private val dispatcher: CoroutineDispatcher,
    private val api: TesteServiceSuccess
) : SuccessRemoteDataSource {
    override suspend fun getTeste(): NetworkResponse<ResponseTesteSuccess, ErrorResponse> {
        return withContext(dispatcher) {
            api.getTeste()
        }
    }
}