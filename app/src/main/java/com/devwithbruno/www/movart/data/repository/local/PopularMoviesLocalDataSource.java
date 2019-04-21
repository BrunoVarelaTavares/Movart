package com.devwithbruno.www.movart.data.repository.local;


import com.devwithbruno.www.movart.App;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.Movie_;
import com.devwithbruno.www.movart.data.repository.repositories.PopularMoviesDataSource;
import com.devwithbruno.www.movart.utils.Config;

import java.util.List;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.query.Query;
import io.reactivex.Flowable;

/**
 * Created by Bruno on 15/02/2018.
 */

public class PopularMoviesLocalDataSource implements PopularMoviesDataSource {



    public Box<Movie> movieBox;

   @Inject
    public PopularMoviesLocalDataSource() {
        movieBox = App.geBoxStore().boxFor(Movie.class);
    }

    @Override
    public Flowable<List<Movie>> loadMovies(boolean forceRemote) {
        List<Movie> movieList = movieBox.query().equal(Movie_.type, Config.POPULAR_MOVIES_TYPE).build().find();
        Flowable<List<Movie>> listFlowable = Flowable.fromArray(movieList);
        return listFlowable;
    }

    @Override
    public void addMovie(Movie movie) {
        movieBox.put(movie);
    }


    @Override
    public void clearData() {
        Query<Movie> query = movieBox.query().equal(Movie_.type, Config.POPULAR_MOVIES_TYPE).build();
        query.remove();
    }
}
