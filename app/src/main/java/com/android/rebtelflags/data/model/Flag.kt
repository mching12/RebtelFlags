package com.android.rebtelflags.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class Flag (
    @Expose var svg: String?,
    @Expose var png: String?
): Parcelable