package com.devwithbruno.www.movart.ui.main.movies;

import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.MovieResponse;
import com.devwithbruno.www.movart.data.model.TrailerResponse;
import com.devwithbruno.www.movart.ui.base.MvpInteractor;

import io.reactivex.Observable;

/**
 * Created by Bruno on 26/01/2018.
 */

public interface MoviesMvpInteractor extends MvpInteractor {


    Observable<TrailerResponse> getTrailers(long movieID);

    Observable<MovieResponse>  getPopularMovies();

    Observable<MovieResponse> getPlayingNowMovies();

    Observable<MovieResponse> getUpcomingMovies();

    Observable<MovieResponse> getTopRatedMovies();

    Observable<Movie>  getMovie(long movieId);

}
