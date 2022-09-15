package com.android.rebtelflags.data.local

import androidx.room.*
import com.android.rebtelflags.data.model.Country

@Dao
interface CountryDao {

    @Query("Select * FROM countries")
    fun getCountries(): List<Country>

    @Query("DELETE FROM countries")
    suspend fun deleteAllCountries()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCountries(countryList: List<Country>)
}