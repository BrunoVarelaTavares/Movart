package com.devwithbruno.www.movart.ui.profil;

import com.devwithbruno.www.movart.data.model.RecentVisited;
import com.devwithbruno.www.movart.di.PerActivity;
import com.devwithbruno.www.movart.ui.base.MvpPresenter;

import java.util.List;

/**
 * Created by Bruno on 31/01/2018.
 */

@PerActivity
public interface ProfileMvpPresenter<V extends ProfileMvpView, I extends ProfileMvpInteractor> extends MvpPresenter<V,I> {

    void openFavoritesFragment();

    void openListsFragment();

    void openRatingsFragment();

    void openWatchlistFragment();

    void clearVisitedHistory();

    void onMovieImageSelect(long movieID);

    void onTvImageSelect(long tvId);

    void onArtistImageSelect(long artistId);

    List<RecentVisited> getAllRecentVisited();


}
