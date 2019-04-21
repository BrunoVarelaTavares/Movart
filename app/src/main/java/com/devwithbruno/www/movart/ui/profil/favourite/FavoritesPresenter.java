package com.devwithbruno.www.movart.ui.profil.favourite;

import com.devwithbruno.www.movart.ui.base.BasePresenter;
import com.devwithbruno.www.movart.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Bruno on 05/02/2018.
 */

public class FavoritesPresenter<V extends FavoritesMvpView, I extends FavoritesMvpInteractor>
        extends BasePresenter<V, I> implements FavoritesMvpPresenter<V, I> {


    @Inject
    public FavoritesPresenter(I mMvpInteractor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(mMvpInteractor, compositeDisposable, schedulerProvider);
    }
}
