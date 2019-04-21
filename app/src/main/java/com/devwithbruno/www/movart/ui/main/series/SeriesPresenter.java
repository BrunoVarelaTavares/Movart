package com.devwithbruno.www.movart.ui.main.series;

import com.devwithbruno.www.movart.data.model.Trailer;
import com.devwithbruno.www.movart.data.model.TrailerResponse;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.TvResponse;
import com.devwithbruno.www.movart.ui.base.BasePresenter;
import com.devwithbruno.www.movart.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Bruno on 29/01/2018.
 */

public class SeriesPresenter<V extends SeriesMvpView, I extends SeriesMvpInteractor> extends BasePresenter<V,I>
        implements SeriesMvpPresenter<V,I> {

    @Inject
    public SeriesPresenter(I mMvpInteractor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(mMvpInteractor, compositeDisposable, schedulerProvider);
    }

    @Override
    public void onViewPrepared() {
        setUpPopularSeries();
        setUpTopRatedSeries();
        setOnTheAirSeries();
        setUpAiringTodaySeries();
    }

    @Override
    public void onPopularSeriesImageSelect(final List<Tv> tvList,final  Tv tv, final String position) {
        getInteractor().getTrailers(tv.getId()).subscribe(new Observer<TrailerResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TrailerResponse trailerResponse) {
                final List<Trailer> trailers = trailerResponse.getResult();
                if (trailers != null){
                    getMvpView().openVideoOnVideoActivity(tvList,tv,position, trailers);
                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onTvImageSelected(long tvId) {
        getInteractor().getTv(tvId).subscribe(new Observer<Tv>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Tv tv) {
                Tv myTv = tv;
                if (myTv != null){
                    getMvpView().openDetailsActivity(tv);
                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    private void setUpPopularSeries(){
        getInteractor().getPopularSeries().subscribe(new Observer<TvResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TvResponse tvResponse) {
                List<Tv> tvs = tvResponse.getResults();
                if (tvs != null){
                    getMvpView().updatePopularSeries(tvs);

                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    private void setUpTopRatedSeries(){
        getInteractor().getTopRatedSeries().subscribe(new Observer<TvResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TvResponse tvResponse) {
                List<Tv> tvs = tvResponse.getResults();
                if (tvs != null){
                    getMvpView().updateTopRatedSeries(tvs);

                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    private void setOnTheAirSeries(){
        getInteractor().getOnTheAirSeries().subscribe(new Observer<TvResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TvResponse tvResponse) {
                List<Tv> tvs = tvResponse.getResults();
                if (tvs != null){
                    getMvpView().updateOnTheAirSeries(tvs);

                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    private void setUpAiringTodaySeries(){
        getInteractor().getAiringTodaySeries().subscribe(new Observer<TvResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TvResponse tvResponse) {
                List<Tv> tvs = tvResponse.getResults();
                if (tvs != null){
                    getMvpView().updateAiringTodaySeries(tvs);

                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }




}
