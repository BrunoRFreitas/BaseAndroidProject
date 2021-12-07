package com.brfdev.repository_impl

import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.ErrorResponse
import com.brfdev.domain.repository.ErrorRepository
import com.brfdev.services.TesteServiceError
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ErrorRepositoryImpl(
    private val dispatcher: CoroutineDispatcher,
    private val api: TesteServiceError
) : ErrorRepository {
    override suspend fun getTesteError(): NetworkResponse<Void, ErrorResponse> {
        return withContext(dispatcher) {
            delay(3000)
            api.getErrorTeste()
        }
    }
}