package com.devwithbruno.www.movart.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Bruno on 15/01/2018.
 */

public class NetworkUtils {

    private NetworkUtils() {

    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }


}
