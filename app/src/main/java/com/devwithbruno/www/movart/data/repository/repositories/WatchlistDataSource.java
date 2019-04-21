package com.devwithbruno.www.movart.data.repository.repositories;

import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.Watchlist;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Bruno on 12/03/2018.
 */

public interface WatchlistDataSource {

    void add(Watchlist watchlist);

    Flowable<List<Watchlist>> getAll();

    void removeOne(Watchlist recentVisited);

    void removeAll();

    boolean movieIsOnWatchlist(Movie movie);

    boolean tvIsOnWatchlist(Tv tv);



}
