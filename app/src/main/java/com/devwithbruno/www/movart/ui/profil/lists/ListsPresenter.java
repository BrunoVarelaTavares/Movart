package com.devwithbruno.www.movart.ui.profil.lists;

import com.devwithbruno.www.movart.ui.base.BasePresenter;
import com.devwithbruno.www.movart.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Bruno on 05/02/2018.
 */

public class ListsPresenter<V extends ListsMvpView, I extends ListsMvpInteractor>
        extends BasePresenter<V, I> implements ListsMvpPresenter<V, I> {


    @Inject
    public ListsPresenter(I mMvpInteractor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(mMvpInteractor, compositeDisposable, schedulerProvider);
    }
}
