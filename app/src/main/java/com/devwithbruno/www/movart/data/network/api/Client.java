package com.devwithbruno.www.movart.data.network.api;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bruno on 28/11/2017.
 */

@Singleton
public class Client {

    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    public static Retrofit retrofit = null;


    @Inject
    public Client(){

    }

    public  static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
