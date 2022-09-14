package com.android.rebtelflags.data.network

import com.android.rebtelflags.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIServiceGenerator(host: String = BuildConfig.BASE_REST_COUNTRIES) {

    private var retrofit: Retrofit? = null

    init {
        createClient(host)
    }

    private fun createClient(host: String) {
        retrofit =
            Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private fun getOkHttpClient() =
        OkHttpClient.Builder()
            .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

    companion object {
        //  in seconds
        const val REQUEST_TIMEOUT = 15L
    }

    fun <T> createService(service: Class<T>): T {
        return retrofit!!.create(service)
    }
}