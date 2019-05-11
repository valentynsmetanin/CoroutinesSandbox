package com.svapp.coroutinessandbox.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.svapp.coroutinessandbox.BuildConfig
import com.svapp.coroutinessandbox.data.network.ContributorService
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
    single { createService<ContributorService>(get()) }
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

private fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(okHttpClient)
        .build()
}

private inline fun <reified T> createService(retrofit: Retrofit): T = retrofit.create(T::class.java)

private fun <T> createService(retrofit: Retrofit, serviceClass: Class<T>): T {
    return retrofit.create(serviceClass)
}

private fun resetRetrofit() {
    createOkHttpClient()
}