package com.devwithbruno.www.movart.ui.profil.favourite;

import com.devwithbruno.www.movart.data.network.ApiHelper;
import com.devwithbruno.www.movart.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by Bruno on 05/02/2018.
 */

public class FavoritesInteractor extends BaseInteractor implements FavoritesMvpInteractor{


    @Inject
    public FavoritesInteractor(ApiHelper mApiHelper) {
        super(mApiHelper);
    }
}
