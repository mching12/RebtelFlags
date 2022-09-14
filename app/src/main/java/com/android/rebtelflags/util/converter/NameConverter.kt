package com.android.rebtelflags.util.converter

import androidx.room.TypeConverter
import com.android.rebtelflags.data.model.Name
import com.google.gson.Gson

open class NameConverter {
    /**
     * Convert a Name object to json
     */
    @TypeConverter
    fun fromNameJson(name: Name?): String = Gson().toJson(name)

    /**
     * Convert json to Name object
     */
    @TypeConverter
    fun toNameObject(json: String): Name = Gson().fromJson(json, Name::class.java)
}