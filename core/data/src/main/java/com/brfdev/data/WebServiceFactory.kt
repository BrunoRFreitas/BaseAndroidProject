package com.brfdev.data

object WebServiceFactory {


}

//class RetrofitBuilder {
//
//    companion object {
//
//        private const val BASE_URL = "https://correios.contrateumdev.com.br/api"
//
//        private val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(getClient())
//            .addConverterFactory(GsonConverterFactory.create(GsonUtil.gson))
//            .build()
////            .create()
//    }
//
//
////    fun <S> createService(serviceClass: Class<S>, factory: CallAdapter.Factory): S {
////        retrofit.addCallAdapterFactory(factory)
////        val retrofit = retrofit.client(getClient()).build()
////        return retrofit.create(serviceClass)
////    }
//}

//fun provideRetrofit(): Retrofit {
//    return Retrofit.Builder()
//        .baseUrl(Consts.BASE_URL)
////        .addCallAdapterFactory(NetworkResponseAdapterFactory())
//        .addConverterFactory(GsonConverterFactory.create(GsonUtil.gson))
//        .client(getClient())
//        .build()
//}

///**
// * The Retrofit object with the Moshi converter.
// */
//private val retrofit = Retrofit.Builder()
//    .baseUrl(Consts.BASE_URL)
////        .addCallAdapterFactory(NetworkResponseAdapterFactory())
//    .addConverterFactory(GsonConverterFactory.create(GsonUtil.gson))
//    .client(getClient())
//    .build()

//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()

///**
// * The Retrofit object with the Moshi converter.
// */
//private val retrofit = Retrofit.Builder()
//    .baseUrl(Consts.BASE_URL)
////        .addCallAdapterFactory(NetworkResponseAdapterFactory())
//    .addConverterFactory(MoshiConverterFactory.create(MoshiUtil.moshi))
//    .client(getClient())
//    .build()
//
///**
// * A public Api object that exposes the lazy-initialized Retrofit service
// */
//object TesteServiceApi {
//    val retrofitService: TesteService by lazy { retrofit.create(TesteService::class.java) }
//}
//
//object TesteServiceErrorApi {
//    val retrofitService: TesteServiceError by lazy { retrofit.create(TesteServiceError::class.java) }
//}