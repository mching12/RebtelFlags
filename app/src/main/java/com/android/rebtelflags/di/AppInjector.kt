package com.android.rebtelflags.di

import androidx.room.Room
import com.android.rebtelflags.data.CountryRepository
import com.android.rebtelflags.data.local.AppDatabase
import com.android.rebtelflags.data.remote.CountriesApiService
import com.android.rebtelflags.data.remote.APIServiceGenerator
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

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .build()
    }
    single { get<AppDatabase>().countryDao() }
}

val repositoryModule = module {
    single {
        CountryRepository(get(), get())
    }
}

