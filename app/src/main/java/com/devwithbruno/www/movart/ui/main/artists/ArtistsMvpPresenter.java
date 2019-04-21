package com.devwithbruno.www.movart.ui.main.artists;

import com.devwithbruno.www.movart.ui.base.MvpPresenter;

/**
 * Created by Bruno on 29/01/2018.
 */

public interface ArtistsMvpPresenter<V extends ArtistsMvpView, I extends ArtistsMvpInterator> extends MvpPresenter<V,I> {

    void onViewPrepared();



}
