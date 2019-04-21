package com.devwithbruno.www.movart.ui.base;

/**
 * Created by Bruno on 15/01/2018.
 */

public interface MvpPresenter<V extends  MvpView, I extends  MvpInteractor> {

    void onAttach(V mvpView);

    void onDetach();

    V getMvpView();

    I getInteractor();

    boolean isViewAttached();


}
