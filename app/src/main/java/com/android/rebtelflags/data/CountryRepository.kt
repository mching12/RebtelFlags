package com.android.rebtelflags.data

import com.android.rebtelflags.data.local.CountryLocalDataSource
import com.android.rebtelflags.data.model.Country
import com.android.rebtelflags.data.model.Result
import com.android.rebtelflags.data.remote.CountryRemoteDataSource
import com.android.rebtelflags.util.helper.ConnectivityHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CountryRepository (
    private val local: CountryLocalDataSource,
    private val remote: CountryRemoteDataSource,
    private val connectivityHelper: ConnectivityHelper
) {
    suspend fun fetchCountries(): Flow<Result<List<Country>>> =
        flow {
            if(connectivityHelper.isConnectedToNetwork())
                emit(remote.fetchAllCountries()
                    .also {
                        if(it.status == Result.Status.SUCCESS) {
                            it.data?.let { countries ->
                                local.saveCountries(countries)
                            }
                        }
                    }
                )
            else emit(local.fetchAllCountries())
        }.flowOn(Dispatchers.IO)
}