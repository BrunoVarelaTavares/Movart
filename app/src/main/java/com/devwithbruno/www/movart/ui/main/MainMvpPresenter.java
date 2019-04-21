package com.devwithbruno.www.movart.ui.main;

import com.devwithbruno.www.movart.di.PerActivity;
import com.devwithbruno.www.movart.ui.base.MvpPresenter;

/**
 * Created by Bruno on 16/01/2018.
 */

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView, I extends MainMvpInteractor > extends MvpPresenter<V, I> {

    void OnViewPrepared();




}
