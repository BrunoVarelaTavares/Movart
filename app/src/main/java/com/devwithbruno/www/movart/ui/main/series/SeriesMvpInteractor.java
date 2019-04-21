package com.devwithbruno.www.movart.ui.main.series;

import com.devwithbruno.www.movart.data.model.TrailerResponse;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.TvResponse;
import com.devwithbruno.www.movart.ui.base.MvpInteractor;

import io.reactivex.Observable;

/**
 * Created by Bruno on 29/01/2018.
 */

public interface SeriesMvpInteractor extends MvpInteractor {

    Observable<TrailerResponse> getTrailers(long tvId);

    Observable<TvResponse> getPopularSeries();

    Observable<TvResponse> getTopRatedSeries();

    Observable<TvResponse> getOnTheAirSeries();

    Observable<TvResponse> getAiringTodaySeries();

    Observable<Tv>  getTv(long tvId);
}
