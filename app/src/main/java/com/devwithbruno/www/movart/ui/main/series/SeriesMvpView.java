package com.devwithbruno.www.movart.ui.main.series;

import com.devwithbruno.www.movart.data.model.Trailer;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.ui.base.MvpView;

import java.util.List;

/**
 * Created by Bruno on 29/01/2018.
 */

public interface SeriesMvpView extends MvpView {

    void updatePopularSeries(List<Tv> tvList);

    void updateTopRatedSeries(List<Tv> tvList);

    void updateOnTheAirSeries(List<Tv> tvList);

    void updateAiringTodaySeries(List<Tv> tvList);

    void openVideoOnVideoActivity(List<Tv> tvList ,Tv tv,String position, List<Trailer> trailers);

    void openDetailsActivity(Tv tv);
}
