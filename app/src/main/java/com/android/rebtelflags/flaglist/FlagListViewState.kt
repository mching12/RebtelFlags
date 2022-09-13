package com.android.rebtelflags.flaglist

import com.android.rebtelflags.ui.model.GridItem

sealed class FlagListViewState {
    object Empty: FlagListViewState()
    object Loading: FlagListViewState()
    class Loaded(val data: List<GridItem>): FlagListViewState()
    class Error(val message: String): FlagListViewState()
}