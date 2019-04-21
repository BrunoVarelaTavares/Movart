package com.devwithbruno.www.movart.ui.base;

import com.devwithbruno.www.movart.data.network.ApiHelper;

import javax.inject.Inject;

/**
 * Created by Bruno on 18/01/2018.
 */

public class BaseInteractor implements MvpInteractor{


    private final ApiHelper mApiHelper;

    @Inject
    public BaseInteractor(ApiHelper mApiHelper) {
        this.mApiHelper = mApiHelper;
    }

    @Override
    public ApiHelper getApiHelper() {
        return mApiHelper;
    }
}
