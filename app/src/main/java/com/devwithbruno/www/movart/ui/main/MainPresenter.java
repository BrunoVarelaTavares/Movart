package com.devwithbruno.www.movart.ui.main;

import com.devwithbruno.www.movart.ui.base.BasePresenter;
import com.devwithbruno.www.movart.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Bruno on 15/01/2018.
 */

public class MainPresenter<V extends MainMvpView,I extends MainMvpInteractor>
        extends BasePresenter<V, I> implements MainMvpPresenter<V, I> {


    @Inject
    public MainPresenter(I mMvpInteractor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(mMvpInteractor, compositeDisposable, schedulerProvider);
    }

    @Override
    public void OnViewPrepared() {





    }
}
