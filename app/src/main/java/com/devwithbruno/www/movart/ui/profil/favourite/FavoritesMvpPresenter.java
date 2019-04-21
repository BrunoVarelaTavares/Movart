package com.devwithbruno.www.movart.ui.profil.favourite;

import com.devwithbruno.www.movart.di.PerActivity;
import com.devwithbruno.www.movart.ui.base.MvpPresenter;

/**
 * Created by Bruno on 05/02/2018.
 */

@PerActivity
public interface FavoritesMvpPresenter<V extends FavoritesMvpView, I extends FavoritesMvpInteractor>
        extends MvpPresenter<V,I> {
}
