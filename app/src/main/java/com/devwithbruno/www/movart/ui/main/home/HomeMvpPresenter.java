package com.devwithbruno.www.movart.ui.main.home;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.Watchlist;
import com.devwithbruno.www.movart.ui.base.MvpPresenter;

import java.util.List;

/**
 * Created by Bruno on 17/01/2018.
 */

public interface HomeMvpPresenter<V extends HomeMvpView, I extends HomeMvpInteractor> extends MvpPresenter<V, I> {

    void onViewPrepared();

    void onMovieImageSelect(long movieID);

    void onTvImageSelect(long tvId);

    void onArtistImageSelect(long artistId, Artist artist);

    void onUpcomingImageSelect(List<Movie> movieList, Movie movie, String position);

    void addToWatchlist(Watchlist watchlist);

    void removeFromWatchlist(Watchlist watchlist);

    boolean movieIsOnWatchlist(Movie movie);

    boolean tvIsOnWatchlist(Tv tv);

    //void onUpMovieImageSelect(List<Movie>  movieList, Movie movie, int movieId, String position);




}
