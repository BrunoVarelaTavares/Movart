package com.devwithbruno.www.movart.ui.main.movies;

import com.devwithbruno.www.movart.data.network.ApiHelper;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.MovieResponse;
import com.devwithbruno.www.movart.data.model.TrailerResponse;
import com.devwithbruno.www.movart.ui.base.BaseInteractor;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Bruno on 26/01/2018.
 */

public class MoviesInteractor extends BaseInteractor implements MoviesMvpInteractor {


    @Inject
    public MoviesInteractor(ApiHelper mApiHelper) {
        super(mApiHelper);
    }


    @Override
    public Observable<TrailerResponse> getTrailers(long movieID) {
        return getApiHelper().getMoviesTrailers(movieID);
    }

    @Override
    public Observable<MovieResponse> getPopularMovies() {
        return getApiHelper().getPopularMovies();
    }

    @Override
    public Observable<MovieResponse> getPlayingNowMovies() {
        return getApiHelper().getPlayingNowMovies();
    }

    @Override
    public Observable<MovieResponse> getUpcomingMovies() {
      return   getApiHelper().getUpcomingMovies();
    }

    @Override
    public Observable<MovieResponse> getTopRatedMovies() {
        return getApiHelper().getTopRatedMovies();
    }



    @Override
    public Observable<Movie> getMovie(long movieId) {
        return getApiHelper().getMovie(movieId);
    }
}
