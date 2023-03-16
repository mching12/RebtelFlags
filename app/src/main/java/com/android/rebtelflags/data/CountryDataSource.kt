package com.android.rebtelflags.data

import com.android.rebtelflags.data.model.Country
import com.android.rebtelflags.data.model.Result

abstract class CountryDataSource {
    abstract suspend fun fetchAllCountries(): Result<List<Country>>
}