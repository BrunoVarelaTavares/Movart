package com.devwithbruno.www.movart.ui.profil.lists;

import com.devwithbruno.www.movart.data.network.ApiHelper;
import com.devwithbruno.www.movart.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by Bruno on 05/02/2018.
 */

public class ListsInteractor extends BaseInteractor implements ListsMvpInteractor {


    @Inject
    public ListsInteractor(ApiHelper mApiHelper) {
        super(mApiHelper);
    }
}
