package com.sonahjin.savemysearch.network

import android.content.Context
import android.net.ConnectivityManager

/**
 *
 * Check Network is Connected
 *
 * */

object ConnectivityHelper {
    fun isConnectedToNetwork(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        var isConnected = false
        if (connectivityManager != null) {
            val activeNetwork = connectivityManager.activeNetworkInfo
            isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting
        }

        return isConnected
    }
}