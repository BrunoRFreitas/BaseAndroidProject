package com.brfdev.network

import android.util.Log
import com.brfdev.utils.Consts
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val retrofit = Retrofit.Builder()
    .baseUrl(Consts.BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(MoshiUtil.moshi))
    .client(NetworkSetup.getClient())

fun <S> createService(serviceClass: Class<S>, factory: CallAdapter.Factory): S {
    retrofit.addCallAdapterFactory(factory)
    val retrofitService by lazy {
        Log.e("TESTE-BRUNO", "Criou servico -${serviceClass.name}")
        retrofit.build().create(serviceClass)
    }
    return retrofitService
}