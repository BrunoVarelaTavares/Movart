package com.devwithbruno.www.movart.data.repository.repositories;

import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.Watchlist;
import com.devwithbruno.www.movart.di.Local;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Bruno on 12/03/2018.
 */

public class WatchlistRepository implements WatchlistDataSource {

    private WatchlistDataSource mWatchlistDataSource;

    @Inject
    public WatchlistRepository(@Local WatchlistDataSource watchlistDataSource){
        this.mWatchlistDataSource = watchlistDataSource;
    }
    public void add(Watchlist watchlist) {
        mWatchlistDataSource.add(watchlist);
    }

    @Override
    public Flowable<List<Watchlist>> getAll() {
        return mWatchlistDataSource.getAll();
    }

    @Override
    public void removeOne(Watchlist watchlist) {
        mWatchlistDataSource.removeOne(watchlist);

    }

    @Override
    public void removeAll() {
        mWatchlistDataSource.removeAll();}

    @Override
    public boolean movieIsOnWatchlist(Movie movie) {
        return mWatchlistDataSource.movieIsOnWatchlist(movie);
    }

    @Override
    public boolean tvIsOnWatchlist(Tv tv) {
        return mWatchlistDataSource.tvIsOnWatchlist(tv);
    }
}
