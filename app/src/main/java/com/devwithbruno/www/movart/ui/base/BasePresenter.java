package com.devwithbruno.www.movart.ui.base;

import com.devwithbruno.www.movart.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Bruno on 15/01/2018.
 */

public class BasePresenter<V extends  MvpView, I extends MvpInteractor>
        implements MvpPresenter<V, I> {

    private final CompositeDisposable  compositeDisposable;
    private final SchedulerProvider schedulerProvider;

    private V mMvpView;
    private I mMvpInteractor;


    @Inject
    public BasePresenter(I mMvpInteractor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        this.mMvpInteractor = mMvpInteractor;
        this.compositeDisposable = compositeDisposable;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;

    }

    public I getmMvpInteractor() {
        return mMvpInteractor;
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }

    @Override
    public void onDetach() {
        compositeDisposable.dispose();
        mMvpView = null;
        mMvpInteractor = null;

    }

    @Override
    public V getMvpView() {
        return mMvpView;
    }

    @Override
    public I getInteractor() {
        return mMvpInteractor;
    }

    public  boolean isViewAttached(){
        return mMvpView != null;
    }



    public void checkViewAttached(){
        if (!isViewAttached()){
            //Acabar aqui
        }
    }





}
