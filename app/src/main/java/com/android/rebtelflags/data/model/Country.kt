package com.android.rebtelflags.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import com.google.gson.annotations.Expose

@Parcelize
@Entity(tableName = "countries")
data class Country (

    @PrimaryKey(autoGenerate = false)
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
): Parcelable {
    companion object {
        fun getPhilippines() =
            Country(
                cca2 = "PH",
                name = Name(
                    common = "Philippines",
                    official = "Republic of the Philippines"
                ),
                ccn3 = "608",
                cca3 = "PHL",
                cioc = "PHI",
                independent = true,
                unMember = true,
                flags = Flag(
                    png = "https://flagcdn.com/w320/ph.png",
                    svg = "https://flagcdn.com/ph.svg"
                ),
                region = "Asia",
                subregion = "South-Eastern Asia"
            )

        fun getCountryList(): List<Country> {
            val list = mutableListOf<Country>()
            for (i in 0..20) {
                list.add(getPhilippines())
            }
            return list
        }

    }
}