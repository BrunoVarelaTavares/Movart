package com.devwithbruno.www.movart.ui.profil.rating;

import com.devwithbruno.www.movart.data.network.ApiHelper;
import com.devwithbruno.www.movart.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by Bruno on 05/02/2018.
 */

public class RatingsInteractor extends BaseInteractor implements RatingsMvpInteractor {


    @Inject
    public RatingsInteractor(ApiHelper mApiHelper) {
        super(mApiHelper);
    }
}
