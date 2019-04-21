package com.devwithbruno.www.movart.ui.main.home.adapters;

import android.widget.ImageView;

import com.devwithbruno.www.movart.ui.base.MvpPresenter;
import com.devwithbruno.www.movart.ui.main.home.HomeMvpInteractor;
import com.devwithbruno.www.movart.ui.main.home.HomeMvpView;

/**
 * Created by Bruno on 25/01/2018.
 */

public interface UpcomingAdapterMvpPresenter<V extends HomeMvpView, I extends HomeMvpInteractor> extends MvpPresenter<V, I> {


    void getMovieImageTrailers(long movieId, ImageView imageView);







}
