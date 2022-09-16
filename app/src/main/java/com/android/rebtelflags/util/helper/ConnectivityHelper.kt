package com.android.rebtelflags.util.helper

import android.content.Context
import android.net.ConnectivityManager

class ConnectivityHelper(private val context: Context) {
    fun isConnectedToNetwork(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}