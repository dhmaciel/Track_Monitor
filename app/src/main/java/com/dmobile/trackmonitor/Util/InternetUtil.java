package com.dmobile.trackmonitor.Util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Douglas on 07/09/2016.
 */
public class InternetUtil {

    public static boolean isInternetAtiva(Context ctx){
        ConnectivityManager cm =
                (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null &&
                cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
