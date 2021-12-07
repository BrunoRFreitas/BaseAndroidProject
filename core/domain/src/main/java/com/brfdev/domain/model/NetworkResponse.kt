package com.brfdev.domain.model

import java.io.IOException

sealed class NetworkResponse<out T: Any, out U: Any>{

    /**
     * Success response with body
     */
    data class Success<T: Any>(val body: T) : NetworkResponse<T, Nothing>()

    /**
     * Failure response with body
     */
    data class ApiError<U: Any>(val body: U?, val code: Int?, val exception: NetworkException?) : NetworkResponse<Nothing, U>()

//    data class ApiErrorV2<U: Any>(val body: U?, val code: Int?, val exception: Exception?) : NetworkResponse<Nothing, U>()
}
