package com.devwithbruno.www.movart.ui.profil;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.ui.base.MvpView;

/**
 * Created by Bruno on 31/01/2018.
 */

public interface ProfileMvpView extends MvpView{

    void showFavoriteFragment();

    void showListsFragment();

    void showRatingFragment();

    void showWatchlistFragment();

    void hideProfileLayout();

    void showProfileLayout();

    void openTvDetailsOnDetailsActivity(Tv tv);

    void openMovieDetailsOnDetailsActivity(Movie movie);

    void openArtistDetails(Artist artist);




}
