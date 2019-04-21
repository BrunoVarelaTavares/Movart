package com.devwithbruno.www.movart.di.component;

import android.app.Application;
import android.content.Context;

import com.devwithbruno.www.movart.App;
import com.devwithbruno.www.movart.data.network.ApiHelper;
import com.devwithbruno.www.movart.di.ApplicationContext;
import com.devwithbruno.www.movart.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bruno on 15/01/2018.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(App app);

    @ApplicationContext
    Context context();

    Application application();

    ApiHelper getApiHelper();



}
