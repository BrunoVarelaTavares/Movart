package com.devwithbruno.www.movart.data.repository.local;


import android.util.Log;

import com.devwithbruno.www.movart.App;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.Movie_;
import com.devwithbruno.www.movart.data.repository.repositories.UpcomingMoviesDataSource;
import com.devwithbruno.www.movart.utils.Config;

import java.util.List;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.query.Query;
import io.reactivex.Flowable;

/**
 * Created by Bruno on 15/02/2018.
 */

public class UpcomingMoviesLocalDataSource implements UpcomingMoviesDataSource {


    public Box<Movie> upcomingMovieBox;

    @Inject
    public UpcomingMoviesLocalDataSource() {
      //  this.upcomingMoviesDao = upcomingMoviesDao;
        upcomingMovieBox = App.geBoxStore().boxFor(Movie.class);
    }

    @Override
    public Flowable<List<Movie>> loadUpcomingMovies(boolean forceRemote) {
        List<Movie> movieList = upcomingMovieBox.query().equal(Movie_.type, Config.UPCOMING_MOVIES_TYPE).build().find();
        Flowable<List<Movie>> listFlowable = Flowable.fromArray(movieList);
        return listFlowable;
    }

    @Override
    public void addMovie(Movie movie) {
        upcomingMovieBox.put(movie);
    }

    private static final String TAG = "UpcomingMoviesLocalData";
    @Override
    public void clearData() {
        Query<Movie> query = upcomingMovieBox.query().equal(Movie_.type, Config.UPCOMING_MOVIES_TYPE).build();
        Log.d(TAG, "clearData: DADADAD " + query.count());
        query.remove();

    }
}
