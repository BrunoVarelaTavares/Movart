package com.devwithbruno.www.movart.data.repository.remote;


import com.devwithbruno.www.movart.BuildConfig;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.MovieResponse;
import com.devwithbruno.www.movart.data.remote.MoviesService;
import com.devwithbruno.www.movart.data.repository.repositories.PopularMoviesDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Bruno on 15/02/2018.
 */

public class PopularMoviesRemoteDataSource implements PopularMoviesDataSource {

    private MoviesService moviesService;

    @Inject
    public PopularMoviesRemoteDataSource(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @Override
    public Flowable<List<Movie>> loadMovies(boolean forceRemote) {
        return moviesService.getPopularMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN).map(MovieResponse::getResults);
    }

    @Override
    public void addMovie(Movie movie) {
        //Currently, we do not need this for remote source.
        throw new UnsupportedOperationException("Unsupported operation");

    }

    @Override
    public void clearData() {
        //Currently, we do not need this for remote source.
        throw new UnsupportedOperationException("Unsupported operation");

    }
}
