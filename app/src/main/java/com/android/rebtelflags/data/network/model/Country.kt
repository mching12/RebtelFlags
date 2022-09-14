package com.android.rebtelflags.data.network.model

import com.google.gson.annotations.Expose

data class Country (
    @Expose var name: Name?,
    @Expose var cca2: String?,
    @Expose var ccn3: String?,
    @Expose var cca3: String?,
    @Expose var cioc: String?,
    @Expose var independent: Boolean?,
    @Expose var unMember: Boolean?,
    @Expose var flags: Flag
)