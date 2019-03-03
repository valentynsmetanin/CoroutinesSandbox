package com.svapp.coroutinessandbox.di

import com.svapp.coroutinessandbox.BuildConfig
import com.svapp.coroutinessandbox.data.network.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Valentyn on 03.03.2019.
 */

val retrofitModule = module {
    single { createOkHttpClient() }
    single { createRetrofit(get()) }
    single { createService<Api>(get()) }
}

private fun createOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    return OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder()

            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()
}

fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

inline fun <reified T> createService(retrofit: Retrofit): T = retrofit.create(T::class.java)

fun <T> createService(retrofit: Retrofit, serviceClass: Class<T>): T {
    return retrofit.create(serviceClass)
}

fun resetRetrofit() {
    createOkHttpClient()
}