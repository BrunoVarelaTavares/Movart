package com.devwithbruno.www.movart.ui.main.series;

import com.devwithbruno.www.movart.data.network.ApiHelper;
import com.devwithbruno.www.movart.data.model.TrailerResponse;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.TvResponse;
import com.devwithbruno.www.movart.ui.base.BaseInteractor;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Bruno on 29/01/2018.
 */

public class SeriesInteractor extends BaseInteractor implements SeriesMvpInteractor {

    @Inject
    public SeriesInteractor(ApiHelper mApiHelper) {
        super(mApiHelper);
    }

    @Override
    public Observable<TrailerResponse> getTrailers(long tvId) {
        return getApiHelper().getTvTrailers(tvId);
    }

    @Override
    public Observable<TvResponse> getPopularSeries() {
        return getApiHelper().getPopularSeries();
    }

    @Override
    public Observable<TvResponse> getTopRatedSeries() {
        return getApiHelper().getTopRatedSeries();
    }

    @Override
    public Observable<TvResponse> getOnTheAirSeries() {
        return getApiHelper().getOnTheAirSeries();
    }

    @Override
    public Observable<TvResponse> getAiringTodaySeries() {
        return getApiHelper().getAiringTodaySeries();
    }

    @Override
    public Observable<Tv> getTv(long tvId) {
        return getApiHelper().getTv(tvId);
    }
}
