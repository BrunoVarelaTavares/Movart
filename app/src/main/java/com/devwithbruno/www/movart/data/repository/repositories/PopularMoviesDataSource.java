package com.devwithbruno.www.movart.data.repository.repositories;


import com.devwithbruno.www.movart.data.model.Movie;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Bruno on 15/02/2018.
 */

public interface PopularMoviesDataSource {
    Flowable<List<Movie>> loadMovies(boolean forceRemote);

    void addMovie(Movie movie);

    void clearData();
}
