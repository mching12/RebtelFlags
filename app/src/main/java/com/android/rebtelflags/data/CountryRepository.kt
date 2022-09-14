package com.android.rebtelflags.data

import com.android.rebtelflags.data.network.CountriesApiService
import com.android.rebtelflags.data.network.model.Country
import com.android.rebtelflags.ui.model.GridItem
import retrofit2.Response

class CountryRepository (
    private val countriesApiService: CountriesApiService
) {
    suspend fun fetchFlags(): Response<List<Country>> =
        countriesApiService.getAllCountries()

    fun getFlags() = listOf(
        GridItem("Anderson", "https://countryflagsapi.com/png/ad"),
        GridItem("Bisping", "https://countryflagsapi.com/png/ae"),
        GridItem("Chuck", "https://countryflagsapi.com/png/af"),
        GridItem("Dodson", "https://countryflagsapi.com/png/ag"),
        GridItem("Elephant", "https://countryflagsapi.com/png/ai"),
        GridItem("Figureido", "https://countryflagsapi.com/png/al"),
        GridItem("Gorilla", "https://countryflagsapi.com/png/am"),
        GridItem("Holly", "https://countryflagsapi.com/png/be"),
        GridItem("Iran", "https://countryflagsapi.com/png/bf"),
        GridItem("Joana", "https://countryflagsapi.com/png/bg"),
        GridItem("Karolina", "https://countryflagsapi.com/png/bh"),
        GridItem("Lemon", "https://countryflagsapi.com/png/ma"),
        GridItem("Mark", "https://countryflagsapi.com/png/mc"),
        GridItem("Nunes", "https://countryflagsapi.com/png/md"),
        GridItem("Oliveira", "https://countryflagsapi.com/png/me"),
        GridItem("Paddy", "https://countryflagsapi.com/png/mf"),
        GridItem("Qatar", "https://countryflagsapi.com/png/mg"),
        GridItem("Ronda", "https://countryflagsapi.com/png/mh"),
        GridItem("Stephen", "https://countryflagsapi.com/png/mk"),
        GridItem("Tai", "https://countryflagsapi.com/png/ml"),
        GridItem("Undertaker", "https://countryflagsapi.com/png/mm"),
        GridItem("Viera", "https://countryflagsapi.com/png/mn")
    )
}