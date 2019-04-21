package com.devwithbruno.www.movart.ui.profil.watchlist;

import com.devwithbruno.www.movart.data.model.Watchlist;
import com.devwithbruno.www.movart.ui.base.MvpView;

import java.util.List;

/**
 * Created by Bruno on 05/02/2018.
 */

public interface WatchlistMvpView extends MvpView {


    void updateWatchlistList(List<Watchlist>  watchlists);

    void clearData();
}
