package com.brfdev.data

import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class NetworkSetup {

    companion object{
        private const val CONTENT_TYPE = "Content-Type"

        fun getClient(): OkHttpClient {
            return OkHttpClient()
                .newBuilder()
                .addInterceptor(requestIntercept())
                .addInterceptor(getLoggingCapableHttpClient())
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()
        }

        private fun requestIntercept(): Interceptor {

            return Interceptor { chain -> {}
                val original = chain.request()
                val requestBuilder: Request.Builder = original.newBuilder()

                requestBuilder.addHeader(CONTENT_TYPE, "application/json; charset=utf-8")

                val request = requestBuilder.build()
                val response: Response = chain.proceed(request)
                val headers = response.headers

                response
            }
        }

        private fun getLoggingCapableHttpClient(): HttpLoggingInterceptor {
            val mLogging = HttpLoggingInterceptor()
            mLogging.setLevel(if (BuildConfig.LOG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
            return mLogging
        }
    }


}