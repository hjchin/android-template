package world.trav.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetworkUtil{

    fun isNetworkAvailable(context:Context?): Boolean {
        val con : ConnectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return con.activeNetworkInfo?.isConnected ?: false
    }
}