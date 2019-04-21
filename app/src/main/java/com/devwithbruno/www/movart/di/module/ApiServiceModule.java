package com.devwithbruno.www.movart.di.module;

import com.devwithbruno.www.movart.data.remote.ArtistsService;
import com.devwithbruno.www.movart.data.remote.MoviesService;
import com.devwithbruno.www.movart.data.remote.TvService;
import com.devwithbruno.www.movart.utils.Config;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bruno on 16/02/2018.
 */

@Module
public class ApiServiceModule {

    private static final String BASE_URL = "base_url";

    @Provides
    @Named(BASE_URL)
    String provideBaseUrl() {
        return Config.BASE_URL;
    }


    @Provides
  //  @Singleton
    Retrofit provideRetrofit(@Named(BASE_URL) String baseUrl) {
        return new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
  //  @Singleton
    MoviesService provideMoviesService(Retrofit retrofit){
        return retrofit.create(MoviesService.class);
    }


    @Provides
    TvService provideTvService(Retrofit retrofit){
        return retrofit.create(TvService.class);
    }


    @Provides
    ArtistsService provideArtistService(Retrofit retrofit){
        return retrofit.create(ArtistsService.class);
    }
}
