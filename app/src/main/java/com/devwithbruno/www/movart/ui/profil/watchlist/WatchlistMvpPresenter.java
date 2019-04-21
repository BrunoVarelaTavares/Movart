package com.devwithbruno.www.movart.ui.profil.watchlist;

import com.devwithbruno.www.movart.di.PerActivity;
import com.devwithbruno.www.movart.ui.base.MvpPresenter;

/**
 * Created by Bruno on 05/02/2018.
 */

@PerActivity
public interface WatchlistMvpPresenter<V extends WatchlistMvpView, I extends WatchlistMvpInteractor>
        extends MvpPresenter<V,I> {

    void onViewPrepared();

//    List<Watchlist> getAllWatchlist();
}
