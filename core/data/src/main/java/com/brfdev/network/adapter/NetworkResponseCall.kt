package com.brfdev.network.adapter

import com.brfdev.domain.model.NetworkResponse
import com.brfdev.domain.model.ErrorResponse
import com.brfdev.domain.model.NetworkException
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException

class NetworkResponseCall<S : Any, E : Any>(
    private val delegate: Call<S>,
    private val errorConverter: Converter<ResponseBody, E>
) : CallDelegate<S, NetworkResponse<S, E>>(delegate) {

    override fun enqueueImpl(callback: Callback<NetworkResponse<S, E>>) =
        delegate.enqueue(object : Callback<S> {
            override fun onResponse(call: Call<S>, response: Response<S>) {
                val body = response.body()
                val code = response.code()
                val error = response.errorBody()

                val result = if (response.isSuccessful) {
                    if (body != null) { //TODO - Ver se vai aceitar retorno VOID
                        NetworkResponse.Success(body)
                    } else {
                        // Response is successful but the body is null
                            NetworkResponse.ApiError(null, code, NetworkException.getNotFoundException())
                    }
                } else {
                    val errorBody = when {
                        error == null -> null
                        error.contentLength() == 0L -> null
                        else -> try {
                            errorConverter.convert(error)
                        } catch (ex: Exception) {
                            null
                        }
                    }

                    if (errorBody != null) {
                        NetworkResponse.ApiError(errorBody, code, null)
                    } else {
                        NetworkResponse.ApiError(null, null, null)
                    }
                }

                callback.onResponse(this@NetworkResponseCall, Response.success(result))

            }

            override fun onFailure(call: Call<S>, throwable: Throwable) {
                val networkResponse = when (throwable) {
                    is IOException -> NetworkResponse.ApiError(null, null, NetworkException.getNotFoundException())
                    else -> NetworkResponse.ApiError(null, null, NetworkException.getNotFoundException())
                }
                callback.onResponse(this@NetworkResponseCall, Response.success(networkResponse))
            }

        })

    override fun cloneImpl(): Call<NetworkResponse<S, E>> =
        NetworkResponseCall(delegate.clone(), errorConverter)

//    private fun exceptionError(
//        errorResponse: ErrorResponse,
//        call: Call<*>,
//        callback: Callback<Result<S>>
//    ): GenericResponse<ErrorResponse> {
//        val error = GenericResponse<ErrorResponse>()
//        error.error = errorResponse
//        error.error.callback = callback
//        error.error.call = call.clone()
//        return error
//    }
}