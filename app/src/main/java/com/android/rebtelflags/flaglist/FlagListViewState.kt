package com.android.rebtelflags.flaglist

import com.android.rebtelflags.data.model.Country

sealed class FlagListViewState {
    object Empty: FlagListViewState()
    object Loading: FlagListViewState()
    data class Loaded(val data: List<Country>): FlagListViewState()
    data class Error(val message: String?): FlagListViewState()
}