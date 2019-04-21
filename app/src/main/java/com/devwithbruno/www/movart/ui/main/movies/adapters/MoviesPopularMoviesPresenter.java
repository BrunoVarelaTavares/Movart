package com.devwithbruno.www.movart.ui.main.movies.adapters;

import android.widget.ImageView;

import com.devwithbruno.www.movart.data.model.Trailer;
import com.devwithbruno.www.movart.data.model.TrailerResponse;
import com.devwithbruno.www.movart.ui.base.BasePresenter;
import com.devwithbruno.www.movart.ui.main.movies.MoviesMvpInteractor;
import com.devwithbruno.www.movart.ui.main.movies.MoviesMvpView;
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

public class MoviesPopularMoviesPresenter<V extends MoviesMvpView, I extends MoviesMvpInteractor> extends BasePresenter<V, I>
        implements MoviesPopularMoviesAdapterMvpPresenter<V, I> {

    private static final String TAG = "UpcomingPresenter";

    @Inject
    public MoviesPopularMoviesPresenter(I mMvpInteractor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(mMvpInteractor, compositeDisposable, schedulerProvider);
    }




    @Override
    public void getMovieImageTrailers(long movieId, final ImageView imageView) {
        if (movieId == -1) {
            return;
        }

        getInteractor().getTrailers(movieId).subscribe(new Observer<TrailerResponse>() {
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
