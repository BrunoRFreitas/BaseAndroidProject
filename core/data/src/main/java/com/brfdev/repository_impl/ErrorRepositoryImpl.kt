package com.brfdev.repository_impl

import com.brfdev.domain.repository.ErrorRepository
import com.brfdev.services.TesteServiceError
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ErrorRepositoryImpl(
    private val dispatcher: CoroutineDispatcher,
    private val api: TesteServiceError
) : ErrorRepository {
//    override suspend fun getTesteError(): Void {
//        return withContext(dispatcher) {
//            TesteServiceErrorApi.retrofitService.getErrorTeste()
//        }
//    }
    override suspend fun getTesteError(): Void {
        return withContext(dispatcher) {
            api.getErrorTeste()
        }
    }
}