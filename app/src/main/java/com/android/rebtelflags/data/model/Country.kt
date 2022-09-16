package com.android.rebtelflags.data.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.Expose

@Parcelize
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
    var flags: Flag,

    @ColumnInfo(name = "region")
    @Expose
    var region: String?,

    @ColumnInfo(name = "subregion")
    @Expose
    var subregion: String?
): Parcelable