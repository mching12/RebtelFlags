package com.android.rebtelflags.util.converter

import androidx.room.TypeConverter
import com.android.rebtelflags.data.model.Flag
import com.google.gson.Gson

open class FlagConverter {
    /**
     * Convert a Flag object to json
     */
    @TypeConverter
    fun fromFlagJson(flag: Flag?): String = Gson().toJson(flag)

    /**
     * Convert json to Flag object
     */
    @TypeConverter
    fun toFlagObject(json: String): Flag = Gson().fromJson(json, Flag::class.java)
}