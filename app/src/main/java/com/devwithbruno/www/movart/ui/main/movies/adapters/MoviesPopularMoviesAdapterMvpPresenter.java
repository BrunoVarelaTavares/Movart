package com.devwithbruno.www.movart.ui.main.movies.adapters;

import android.widget.ImageView;

import com.devwithbruno.www.movart.ui.base.MvpPresenter;
import com.devwithbruno.www.movart.ui.main.movies.MoviesMvpInteractor;
import com.devwithbruno.www.movart.ui.main.movies.MoviesMvpView;

/**
 * Created by Bruno on 25/01/2018.
 */

public interface MoviesPopularMoviesAdapterMvpPresenter<V extends MoviesMvpView, I extends MoviesMvpInteractor> extends MvpPresenter<V, I> {

    void getMovieImageTrailers(long movieId, ImageView imageView);


}
