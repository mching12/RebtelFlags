package com.android.rebtelflags.data.remote

import com.android.rebtelflags.data.model.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountriesApiService {
    @GET("all")
    suspend fun getAllCountries(): Response<List<Country>>
}