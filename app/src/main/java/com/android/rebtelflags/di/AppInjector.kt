package com.android.rebtelflags.di

import androidx.room.Room
import com.android.rebtelflags.data.CountryRepository
import com.android.rebtelflags.data.local.AppDatabase
import com.android.rebtelflags.data.local.CountryLocalDataSource
import com.android.rebtelflags.data.remote.CountriesApiService
import com.android.rebtelflags.data.remote.APIServiceGenerator
import com.android.rebtelflags.data.remote.CountryRemoteDataSource
import com.android.rebtelflags.flaglist.FlagListViewModel
import com.android.rebtelflags.util.helper.ConnectivityHelper
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val countriesApiService = APIServiceGenerator().createService(CountriesApiService::class.java)

val viewModelModule = module {
    viewModel { FlagListViewModel(get()) }
}

val networkModule = module {
    single { countriesApiService }
    single { CountryRemoteDataSource(get()) }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .build()
    }
    single { get<AppDatabase>().countryDao() }
    single { CountryLocalDataSource(get()) }
}

val repositoryModule = module {
    single {
        ConnectivityHelper(androidContext())
    }
    single {
        CountryRepository(get(), get(), get())
    }
}

