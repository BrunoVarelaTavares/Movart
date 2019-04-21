package com.devwithbruno.www.movart.ui.profil.rating;

import com.devwithbruno.www.movart.di.PerActivity;
import com.devwithbruno.www.movart.ui.base.MvpPresenter;

/**
 * Created by Bruno on 05/02/2018.
 */

@PerActivity
public interface RatingsMvpPresenter<V extends RatingsMvpView, I extends RatingsMvpInteractor>
        extends MvpPresenter<V,I> {
}
