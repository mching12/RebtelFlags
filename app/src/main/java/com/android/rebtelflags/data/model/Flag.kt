package com.android.rebtelflags.data.model

import com.google.gson.annotations.Expose

data class Flag (
    @Expose var svg: String?,
    @Expose var png: String?
)