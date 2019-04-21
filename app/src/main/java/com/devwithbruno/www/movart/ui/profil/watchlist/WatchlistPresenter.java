package com.devwithbruno.www.movart.ui.profil.watchlist;

import android.util.Log;

import com.devwithbruno.www.movart.ui.base.BasePresenter;
import com.devwithbruno.www.movart.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Bruno on 05/02/2018.
 */

public class WatchlistPresenter<V extends WatchlistMvpView, I extends WatchlistMvpInteractor>
        extends BasePresenter<V, I> implements WatchlistMvpPresenter<V, I> {


    @Inject
    public WatchlistPresenter(I mMvpInteractor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(mMvpInteractor, compositeDisposable, schedulerProvider);
    }

    @Override
    public void onViewPrepared() {
        updateList();
    }


    private static final String TAG = "WatchlistPresenter";
    private void updateList() {


        getCompositeDisposable().add(getInteractor().getAllWatchlist()
        .subscribeOn(getSchedulerProvider().io())
        .observeOn(getSchedulerProvider().ui())
        .subscribe(watchlist -> getMvpView().updateWatchlistList(watchlist),
                throwable -> Log.e(TAG, "updateList: ",  throwable)));





//        try {
//            if (getAllWatchlist() != null && !getAllWatchlist().isEmpty()) {
//                getMvpView().updateWatchlistList(getAllWatchlist());
//            } else {
//                //  getMvpView().showNoDataMessage();
//            }
//
//        } catch (Exception e) {
//
//        }
    }


//    @Override
//    public List<Watchlist> getAllWatchlist() {
//        return getInteractor().getAllWatchlist();
//    }
}
