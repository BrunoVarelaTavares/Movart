package com.devwithbruno.www.movart.ui.main.series.adapters;

import android.widget.ImageView;

import com.devwithbruno.www.movart.ui.base.MvpPresenter;
import com.devwithbruno.www.movart.ui.main.series.SeriesMvpInteractor;
import com.devwithbruno.www.movart.ui.main.series.SeriesMvpView;

/**
 * Created by Bruno on 25/01/2018.
 */

public interface SeriesPopularSeriesAdapterMvpPresenter<V extends SeriesMvpView, I extends SeriesMvpInteractor> extends MvpPresenter<V, I> {

    void getSerieImageTrailer(long tvId, ImageView imageView);


}
