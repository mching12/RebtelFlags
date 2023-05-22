package com.android.rebtelflags.flaglist


sealed class FlagListEvent {
    object Refresh: FlagListEvent()
}