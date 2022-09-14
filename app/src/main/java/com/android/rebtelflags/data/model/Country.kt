package com.android.rebtelflags.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

@Entity(tableName = "countries")
data class Country (

    @PrimaryKey(autoGenerate = false)
    @NonNull
    @Expose
    var cca2: String,

    @ColumnInfo(name = "name")
    @Expose
    var name: Name?,

    @ColumnInfo(name = "ccn3")
    @Expose
    var ccn3: String?,

    @ColumnInfo(name = "cca3")
    @Expose
    var cca3: String?,

    @ColumnInfo(name = "cioc")
    @Expose
    var cioc: String?,

    @ColumnInfo(name = "independent")
    @Expose
    var independent: Boolean = false,

    @ColumnInfo(name = "unMember")
    @Expose
    var unMember: Boolean = false,

    @ColumnInfo(name = "flags")
    @Expose
    var flags: Flag
)