package com.devwithbruno.www.movart.ui.main.series.adapters;

import android.widget.ImageView;

import com.devwithbruno.www.movart.data.model.Trailer;
import com.devwithbruno.www.movart.data.model.TrailerResponse;
import com.devwithbruno.www.movart.ui.base.BasePresenter;
import com.devwithbruno.www.movart.ui.main.series.SeriesMvpInteractor;
import com.devwithbruno.www.movart.ui.main.series.SeriesMvpView;
import com.devwithbruno.www.movart.utils.rx.SchedulerProvider;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Bruno on 25/01/2018.
 */

public class SeriesPopularSeriesPresenter<V extends SeriesMvpView, I extends SeriesMvpInteractor> extends BasePresenter<V, I>
        implements SeriesPopularSeriesAdapterMvpPresenter<V, I> {

    private static final String TAG = "SeriesPopularSeriesPresenter";

    @Inject
    public SeriesPopularSeriesPresenter(I mMvpInteractor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(mMvpInteractor, compositeDisposable, schedulerProvider);
    }



    @Override
    public void getSerieImageTrailer(long tvId, final ImageView imageView) {
        if (tvId == -1) {
            return;
        }
        getInteractor().getTrailers(tvId).subscribe(new Observer<TrailerResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TrailerResponse trailerResponse) {
                List<Trailer> trailers = trailerResponse.getResult();
                StringBuilder urlsVideo = new StringBuilder();
                urlsVideo.append("https://img.youtube.com/vi/");
                try {
                    if (trailers.size() > -1) {
                        if (trailers.get(0).getKey() != null) {
                            urlsVideo.append(trailers.get(0).getKey());
                        } else if (trailers.get(1).getKey() != null) {
                            urlsVideo.append(trailers.get(1).getKey());
                        }
                    } else {
                        urlsVideo.append("NOT");
                    }

                    urlsVideo.append("/0.jpg");
                    String urls = urlsVideo.toString();
                    if (!urls.isEmpty()) {
                        ImageLoader imageLoader = ImageLoader.getInstance();
                        imageLoader.displayImage(urls, imageView);
                    }


                } catch (IndexOutOfBoundsException e) {

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
