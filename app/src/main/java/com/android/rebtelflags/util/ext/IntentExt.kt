package com.android.rebtelflags.util.ext

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Parcelable

/**
 * Extension method to get Parcelables from Intent.
 * Old method of using `intent.extras?.getParcelable(<String>)` is now deprecated
 */
inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
    Build.VERSION.SDK_INT >= 33 -> getParcelableExtra(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
}

inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
    Build.VERSION.SDK_INT >= 33 -> getParcelable(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelable(key) as? T
}