package com.devwithbruno.www.movart.ui.main.series;

import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.ui.base.MvpPresenter;

import java.util.List;

/**
 * Created by Bruno on 29/01/2018.
 */

public interface SeriesMvpPresenter<V extends SeriesMvpView, I extends SeriesMvpInteractor> extends MvpPresenter<V, I> {

     void onViewPrepared();

     void onPopularSeriesImageSelect(List<Tv> tvList, Tv tv, String position);

     void onTvImageSelected(long tvId);

}
