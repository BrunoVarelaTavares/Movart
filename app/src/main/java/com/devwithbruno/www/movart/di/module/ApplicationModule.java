package com.devwithbruno.www.movart.di.module;

import android.app.Application;
import android.content.Context;

import com.devwithbruno.www.movart.BuildConfig;
import com.devwithbruno.www.movart.data.network.ApiHelper;
import com.devwithbruno.www.movart.data.network.AppApiHelper;
import com.devwithbruno.www.movart.di.ApiInfo;
import com.devwithbruno.www.movart.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bruno on 12/01/2018.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return mApplication;
    }


    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides  @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @ApiInfo
    String provideMovieDBApiKey(){
        return BuildConfig.THE_MOVIE_DB_API_TOKEN;
    }




}
