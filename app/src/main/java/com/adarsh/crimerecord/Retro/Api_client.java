package com.adarsh.crimerecord.Retro;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class Api_client {
    private static Retrofit retrofit = null;

    public static Retrofit CitizenRegister() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://sicspython.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}