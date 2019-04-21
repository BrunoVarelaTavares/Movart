package com.devwithbruno.www.movart.ui.profil.watchlist;

import android.util.Log;

import com.devwithbruno.www.movart.data.model.Watchlist;
import com.devwithbruno.www.movart.data.network.ApiHelper;
import com.devwithbruno.www.movart.data.repository.repositories.WatchlistRepository;
import com.devwithbruno.www.movart.ui.base.BaseInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Bruno on 05/02/2018.
 */

public class WatchListInteractor extends BaseInteractor implements WatchlistMvpInteractor {


    private WatchlistRepository mWatchlistRepository;

    private static final String TAG = "WatchListInteractor";
    @Inject
    public WatchListInteractor(ApiHelper mApiHelper, WatchlistRepository mWatchlistRepository) {
        super(mApiHelper);
        this.mWatchlistRepository = mWatchlistRepository;
        Log.d(TAG, "WatchListInteractor: ");
    }

    @Override
    public Flowable<List<Watchlist>> getAllWatchlist() {
        return mWatchlistRepository.getAll();
    }
}
