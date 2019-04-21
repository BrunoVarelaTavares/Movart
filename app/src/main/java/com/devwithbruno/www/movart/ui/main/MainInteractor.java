package com.devwithbruno.www.movart.ui.main;

import com.devwithbruno.www.movart.data.network.ApiHelper;
import com.devwithbruno.www.movart.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by Bruno on 18/01/2018.
 */

public class MainInteractor extends BaseInteractor
        implements MainMvpInteractor {


    @Inject
    public MainInteractor(ApiHelper mApiHelper) {
        super(mApiHelper);
    }
}
