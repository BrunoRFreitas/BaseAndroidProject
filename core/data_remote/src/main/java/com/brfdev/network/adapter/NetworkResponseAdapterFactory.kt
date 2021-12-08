package com.brfdev.network.adapter

import com.brfdev.domain.model.NetworkResponse
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class NetworkResponseAdapterFactory : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        // suspend functions wrap the response type in `Call`
        if (Call::class.java != getRawType(returnType)) {
            return null
        }

        // check first that the return type is `ParameterizedType`
        check(returnType is ParameterizedType) {
            "return type must be parameterized as Call<NetworkResponse<<Foo>> or Call<NetworkResponse<out Foo>>"
        }

        // get the response type inside the `Call` type
        val responseType = getParameterUpperBound(0, returnType)
        // if the response type is not ApiResponse then we can't handle this type, so we return null
        if (getRawType(responseType) != NetworkResponse::class.java) {
            return null
        }

        // the response type is ApiResponse and should be parameterized
        check(responseType is ParameterizedType) { "Response must be parameterized as NetworkResponse<Foo> or NetworkResponse<out Foo>" }

        val successBodyType = getParameterUpperBound(0, responseType)
        val errorBodyType = getParameterUpperBound(1, responseType)

        val errorBodyConverter =
            retrofit.nextResponseBodyConverter<Any>(null, errorBodyType, annotations)

        return NetworkResponseAdapter<Any, Any>(successBodyType, errorBodyConverter)
    }

//    override fun getV2(
//        returnType: Type,
//        annotations: Array<out Annotation>,
//        retrofit: Retrofit
//    ) =
//        when (getRawType(returnType)) {
//            Call::class.java -> {
//                val callType = getParameterUpperBound(0, returnType as ParameterizedType)
//                when (getRawType(callType)) {
//                    Result::class.java -> {
//                        val successBodyType = getParameterUpperBound(0, responseType)
//                        val errorBodyType = getParameterUpperBound(1, responseType)
//
//                        val resultType = getParameterUpperBound(0, callType as ParameterizedType)
//                        val errorBodyConverter = retrofit.nextResponseBodyConverter<Any>(null, errorBodyType, annotations)
//                        NetworkResponseAdapter<Any, Any>((resultType))
//                    }
//                    else -> null
//                }
//            }
//            else -> null
//        }
//}
}