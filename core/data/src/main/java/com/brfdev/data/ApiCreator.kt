package com.brfdev.data

import android.util.Log
import com.brfdev.utils.Consts
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val moshi: Moshi by lazy {
    Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}


private val retrofit = Retrofit.Builder()
    .baseUrl(Consts.BASE_URL)
//        .addCallAdapterFactory(NetworkResponseAdapterFactory())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(NetworkSetup.getClient())
    .build()


//fun <S> createService(serviceClass: Class<S>, factory: CallAdapter.Factory): S {
//    retrofit.addCallAdapterFactory(factory)
//    val retrofitService by lazy { retrofit.create(serviceClass) }
//    return retrofitService
//}

fun <S> createService(serviceClass: Class<S>): S {
    val retrofitService by lazy {
        Log.e("TESTE-BRUNO", "Criou servico -${serviceClass.name}")
        retrofit.create(serviceClass)
    }
    return retrofitService
}

//fun provideRetrofit(moshi: Moshi, client: OkHttpClient): Retrofit {
//    return Retrofit.Builder()
//        .baseUrl(BASE_URL_API)
//        .addCallAdapterFactory(NetworkResponseAdapterFactory())
//        .addConverterFactory(MoshiConverterFactory.create(moshi))
//        .client(client)
//        .build()
//}