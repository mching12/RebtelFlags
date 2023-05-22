package com.android.rebtelflags.data

import com.android.rebtelflags.data.local.CountryLocalDataSource
import com.android.rebtelflags.data.model.Country
import com.android.rebtelflags.data.model.Result
import com.android.rebtelflags.data.remote.CountryRemoteDataSource
import com.android.rebtelflags.util.helper.ConnectivityHelper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CountryRepository (
    private val local: CountryLocalDataSource,
    private val remote: CountryRemoteDataSource,
    private val connectivityHelper: ConnectivityHelper,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend fun fetchCountries(): Result<List<Country>> =
        withContext(defaultDispatcher) {
            if(connectivityHelper.isConnectedToNetwork())
                remote.fetchAllCountries()
                    .also {
                        if(it.status == Result.Status.SUCCESS) {
                            it.data?.let { countries ->
                                local.saveCountries(countries)
                            }
                        }
                    }
            else local.fetchAllCountries()
        }
}