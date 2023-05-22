package com.android.rebtelflags.data.remote

import com.android.rebtelflags.data.CountryDataSource
import com.android.rebtelflags.data.model.Country
import com.android.rebtelflags.data.model.Result
import retrofit2.Response

class CountryRemoteDataSource (
    private val countryApiService: CountriesApiService
): CountryDataSource() {

    override suspend fun fetchAllCountries(): Result<List<Country>> =
        getResponse(
            request = { countryApiService.getAllCountries() },
            defaultErrorMessage = "Error fetching Country list remotely"
        )

    private suspend fun <T> getResponse(
        request: suspend () -> Response<T>,
        defaultErrorMessage: String = ERROR_DEFAULT
    ): Result<T> {
        return try {
            request.invoke().let {
                return if (it.isSuccessful) Result.success(it.body())
                else Result.error(request.invoke().message())
            }
        } catch (e: Throwable) {
            Result.error(e.localizedMessage ?: ERROR_DEFAULT)
        }
    }

    companion object {
        const val ERROR_DEFAULT = "Ooops.. Something went wrong"
    }
}