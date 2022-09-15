package com.android.rebtelflags.data.remote

import com.android.rebtelflags.data.CountryDataSource
import com.android.rebtelflags.data.model.Country
import com.android.rebtelflags.data.model.Result

class CountryRemoteDataSource (
    private val countryApiService: CountriesApiService
): CountryDataSource() {

    override suspend fun fetchAllCountries(): Result<List<Country>> =
        getResponse(
            request = { countryApiService.getAllCountries() },
            defaultErrorMessage = "Error fetching Country list remotely"
        )
}