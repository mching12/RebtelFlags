package com.android.rebtelflags.data.local

import com.android.rebtelflags.data.CountryDataSource
import com.android.rebtelflags.data.model.Country
import com.android.rebtelflags.data.model.Result

class CountryLocalDataSource (
    private val countryDao: CountryDao
): CountryDataSource() {

    override suspend fun fetchAllCountries(): Result<List<Country>> =
        countryDao.getCountries().let {
            Result.success(it)
        }

    suspend fun saveCountries(countryList: List<Country>) {
        countryDao.saveCountries(countryList)
    }
}