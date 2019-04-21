package com.devwithbruno.www.movart.ui.profil.watchlist;

import com.devwithbruno.www.movart.data.model.Watchlist;
import com.devwithbruno.www.movart.ui.base.MvpInteractor;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Bruno on 05/02/2018.
 */

public interface WatchlistMvpInteractor extends MvpInteractor {


    Flowable<List<Watchlist>> getAllWatchlist();
}
