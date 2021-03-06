package com.svapp.coroutinessandbox.di

import com.svapp.coroutinessandbox.BuildConfig
import com.svapp.coroutinessandbox.data.network.ContributorService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
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
    interceptor.level =
        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    return OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder()

            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()
}

private fun createRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
    .baseUrl(BuildConfig.API_ENDPOINT)
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()

private inline fun <reified T> createService(retrofit: Retrofit) = retrofit.create(T::class.java)

private fun <T> createService(retrofit: Retrofit, serviceClass: Class<T>) =
    retrofit.create(serviceClass)

private fun resetRetrofit() {
    createOkHttpClient()
}