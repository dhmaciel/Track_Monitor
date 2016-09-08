package com.dmobile.trackmonitor.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Douglas on 07/09/2016.
 */
public class ApiClient {
    public static final String BASE_URL = "*URL here*";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
