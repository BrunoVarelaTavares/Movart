package com.devwithbruno.www.movart.ui.main.movies;

import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.ui.base.MvpPresenter;

import java.util.List;

/**
 * Created by Bruno on 26/01/2018.
 */

public interface MoviesMvpPresenter<V extends MoviesMvpView, I extends MoviesMvpInteractor> extends MvpPresenter<V,I> {

    void onViewPrepared();

    void onPopularMoviesImageSelect(List<Movie> movieList, Movie movie, String position);

    void onMovieImageSelected(long movieId);
}
