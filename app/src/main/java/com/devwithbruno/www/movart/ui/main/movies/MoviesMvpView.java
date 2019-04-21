package com.devwithbruno.www.movart.ui.main.movies;

import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.Trailer;
import com.devwithbruno.www.movart.ui.base.MvpView;

import java.util.List;

/**
 * Created by Bruno on 26/01/2018.
 */

public interface MoviesMvpView extends MvpView {

    void updatePopularMovies(List<Movie> movieList);

    void updatePlayingNowMovies(List<Movie> movieList);

    void updateTopRatedMovies(List<Movie> movieList);

    void updateComingSoonMovies(List<Movie> movieList);

    void updateLatestMovies(List<Movie> movieList);

    void openVideoOnVideoActivity(List<Movie> movieList, Movie movie,String position, List<Trailer> trailerList);

    void openDetailsActivity(Movie movie);
}
