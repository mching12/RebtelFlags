package com.android.rebtelflags.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class Name (
    @Expose var common: String?,
    @Expose var official: String?
): Parcelable