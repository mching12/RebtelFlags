package com.android.rebtelflags.data.network

import com.android.rebtelflags.data.network.model.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountriesApiService {
    @GET("all")
    suspend fun getAllCountries(): Response<List<Country>>
}