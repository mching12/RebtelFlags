package com.android.rebtelflags.di

import com.android.rebtelflags.data.CountryRepository
import com.android.rebtelflags.data.network.CountriesApiService
import com.android.rebtelflags.data.network.APIServiceGenerator
import com.android.rebtelflags.flaglist.FlagListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val countriesApiService = APIServiceGenerator().createService(CountriesApiService::class.java)

val viewModelModule = module {
    viewModel { FlagListViewModel(get()) }
}

val networkModule = module {
    single { countriesApiService }
}

val repositoryModule = module {
    single {
        CountryRepository(get())
    }
}

