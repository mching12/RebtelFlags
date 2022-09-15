package com.android.rebtelflags.data

import android.util.Log
import com.android.rebtelflags.data.model.Country
import com.android.rebtelflags.data.model.Result
import retrofit2.Response

abstract class CountryDataSource {

    abstract suspend fun fetchAllCountries(): Result<List<Country>>

    suspend fun <T> getResponse(
        request: suspend () -> Response<T>,
        defaultErrorMessage: String = ERROR_DEFAULT
    ): Result<T> {
        return try {
            Log.d("testqwerty", "I'm working in thread ${Thread.currentThread().name}")
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