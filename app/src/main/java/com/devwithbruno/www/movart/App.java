package com.devwithbruno.www.movart;


import android.app.Application;

import com.devwithbruno.www.movart.data.model.MyObjectBox;
import com.devwithbruno.www.movart.di.component.ApplicationComponent;
import com.devwithbruno.www.movart.di.component.DaggerApplicationComponent;
import com.devwithbruno.www.movart.di.module.ApplicationModule;

import io.objectbox.BoxStore;

/**
 * Created by Bruno on 15/01/2018.
 */

public class App extends Application {

    private ApplicationComponent mApplicationComponent;

    private static BoxStore mBoxStore;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        mBoxStore = MyObjectBox.builder().androidContext(App.this).build();




    }

    public ApplicationComponent getComponent(){
        return  mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent){
        mApplicationComponent = applicationComponent;
    }


    public static BoxStore geBoxStore() {
        return mBoxStore;
    }
}
