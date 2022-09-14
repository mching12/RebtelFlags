package com.android.rebtelflags.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.rebtelflags.util.converter.FlagConverter
import com.android.rebtelflags.util.converter.NameConverter
import com.android.rebtelflags.data.model.Country

@Database(entities = [Country::class], version = 1, exportSchema = false)
@TypeConverters(NameConverter::class, FlagConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun countryDao(): CountryDao

    companion object {
        const val DATABASE_NAME = "country_database.db"
    }
}