package com.eversoft.api;

import android.content.Context;
import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static String PORT_NUMBER = "8088";
    private static String ROOT_DIRECTORY = "traverse";
    private static Context mContext;

    public static Retrofit getRetrofitInstance(String ipaddress) {
//        OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(getBaseUrl(ipaddress))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static String getBaseUrl(String ipaddress){
        String s =  "http://" + ipaddress + ":" + PORT_NUMBER + "/" + ROOT_DIRECTORY + "/";
        Log.d("MYAPI", s);
        return s;
    }

}
