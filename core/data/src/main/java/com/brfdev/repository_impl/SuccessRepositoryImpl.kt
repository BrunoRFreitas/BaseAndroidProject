package com.brfdev.repository_impl

//import com.brfdev.data.TesteServiceApi
import com.brfdev.domain.model.Error
import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.ResponseTesteSuccess
import com.brfdev.domain.repository.SuccessRepository
import com.brfdev.services.TesteServiceSuccess
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SuccessRepositoryImpl(
    private val dispatcher: CoroutineDispatcher,
    private val api: TesteServiceSuccess
) : SuccessRepository {
    override suspend fun getTeste(): NetworkResponse<ResponseTesteSuccess, Error> {
        return withContext(dispatcher) {
            api.getTeste()
        }
    }
}