package com.android.rebtelflags.flaglist

import com.android.rebtelflags.data.model.Country

sealed class FlagListViewState {
    object Empty: FlagListViewState()
    object Loading: FlagListViewState()
    class Loaded(val data: List<Country>): FlagListViewState()
    class Error(val message: String?): FlagListViewState()
}