package com.devwithbruno.www.movart.ui.profil.rating;

import com.devwithbruno.www.movart.ui.base.BasePresenter;
import com.devwithbruno.www.movart.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Bruno on 05/02/2018.
 */

public class RatingsPresenter<V extends RatingsMvpView, I extends RatingsMvpInteractor>
        extends BasePresenter<V, I> implements RatingsMvpPresenter<V, I> {


    @Inject
    public RatingsPresenter(I mMvpInteractor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(mMvpInteractor, compositeDisposable, schedulerProvider);
    }
}
