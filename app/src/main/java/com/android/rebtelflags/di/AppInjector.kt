package com.android.rebtelflags.di

import com.android.rebtelflags.data.FlagRepository
import com.android.rebtelflags.flaglist.FlagListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { FlagListViewModel(get()) }
}

val repositoryModule = module {
    single {
        FlagRepository()
    }
}

