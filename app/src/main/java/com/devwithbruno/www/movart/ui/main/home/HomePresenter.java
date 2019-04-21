package com.devwithbruno.www.movart.ui.main.home;


import android.util.Log;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.Trailer;
import com.devwithbruno.www.movart.data.model.TrailerResponse;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.Watchlist;
import com.devwithbruno.www.movart.ui.base.BasePresenter;
import com.devwithbruno.www.movart.utils.GeneralConfig;
import com.devwithbruno.www.movart.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Bruno on 17/01/2018.
 */

public class HomePresenter<V extends HomeMvpView, I extends HomeMvpInteractor> extends BasePresenter<V, I>
        implements HomeMvpPresenter<V, I> {

    private static final String TAG = "HomePresenter";

    @Inject
    public HomePresenter(I mMvpInteractor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(mMvpInteractor, compositeDisposable, schedulerProvider);
    }


    @Override
    public void onViewPrepared() {
        setUpPopularMovies();
        setUpUpcomingMovies();
        setUpPopularSeries();
        setUpPopularArtists();

    }







    @Override
    public void onMovieImageSelect(long movieID) {
        getInteractor().getMovie(movieID).subscribe(new Observer<Movie>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Movie movie) {
                if (movie != null) {
                    Movie myMovie = movie;
                    getInteractor().addRecentVisited(GeneralConfig.movieToRecentVisited(movie));
                    getMvpView().openMovieDetailsOnDetailsActivity(myMovie);
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
    public void onTvImageSelect(long tvId) {
        getInteractor().getTv(tvId).subscribe(new Observer<Tv>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Tv tv) {
                if (tv != null) {
                    Tv myTv = tv;
                    getInteractor().addRecentVisited(GeneralConfig.tvToRecentVisited(tv));
                    getMvpView().openTvDatailsOnDetailsActivity(myTv);
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
    public void onArtistImageSelect(final long artistId, final Artist artistInfo) {
        getInteractor().getArtist(artistId).subscribe(new Observer<Artist>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Artist artist) {
                if (artist != null) {
                    Artist myArtist = artist;
                    getInteractor().addRecentVisited(GeneralConfig.artistToRecentVisited(artist));
                    getMvpView().openArtistOnArtistActivity(myArtist, artistInfo);

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
    public void onUpcomingImageSelect(final List<Movie> movieList, final Movie movie, final String position) {
        getInteractor().getTrailers(movie.getId()).subscribe(new Observer<TrailerResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TrailerResponse trailerResponse) {
                final List<Trailer> trailers = trailerResponse.getResult();
                if (trailers != null) {
                    getMvpView().openVideoOnVideoActivity(movieList, movie, position, trailers);
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
    public void addToWatchlist(Watchlist watchlist) {
        getInteractor().addToWatchlist(watchlist);
    }

    @Override
    public void removeFromWatchlist(Watchlist watchlist) {
        getInteractor().removeFromWatchlist(watchlist);

    }

    @Override
    public boolean movieIsOnWatchlist(Movie movie) {
     return getInteractor().movieIsOnWatchlist(movie);
    }

    @Override
    public boolean tvIsOnWatchlist(Tv tv) {
        return getInteractor().tvisOnWatchlist(tv);
    }


    private void getPopularMoviesReturnedData(List<Movie> list) {
//        view.stopLoadingIndicator();
        if (list != null && !list.isEmpty()) {
            getMvpView().showPopularMovies(list);
        } else {
            getMvpView().showNoDataMessage();
        }
    }


    private void getUpcomingMoviesReturnedData(List<Movie> movieList) {
        if (movieList != null && !movieList.isEmpty()) {
            getMvpView().showUpcomingMovies(movieList);
            for (int i = 0; i < movieList.size(); i++) {
                Log.i(TAG, "getUpcomingMoviesReturnedData: " + movieList.get(i).toString());
            }

        } else {
            getMvpView().showNoDataMessage();
        }


    }


    private void callPopularMovies(boolean isNetworkConnected) {
        getCompositeDisposable().add(getInteractor()
                .getPopularMovies(isNetworkConnected)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui()
                ).subscribe(this::getPopularMoviesReturnedData, this::handleError,
                        () -> getMvpView().stopLoadingIndicator()));
    }



    private void setUpPopularMovies() {
        if (getMvpView().isNetworkConnected()) {
            getMvpView().clearPopularMovies();
            callPopularMovies(true);
        }else {
            callPopularMovies(false);
        }






//        getInteractor().getPopularMovies().subscribe(new Observer<MovieResponse>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//            @Override
//            public void onNext(MovieResponse movieResponse) {
//                List<Movie> movies = movieResponse.getMovies();
//                getMvpView().updatePopularMovies(movies);
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

    }

//    getCompositeDisposable().add(getInteractor()
//        .getPopularMovies()
//        .subscribeOn(getSchedulerProvider().io())
//            .observeOn(getSchedulerProvider().ui()
//        ).subscribe(this::getPopularMoviesReturnedData,this::handleError,() -> getMvpView().stopLoadingIndicator()));


    private void getPopularSeriesReturnedData(List<Tv> list) {
        if (list != null && !list.isEmpty()) {
            getMvpView().showPopularSeries(list);
        } else {
            getMvpView().showNoDataMessage();
        }
    }


    private void callPopularSeries(boolean isNetworkConnected){
        getCompositeDisposable().add(getInteractor()
                .getPopularSeries(isNetworkConnected)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui()
                ).subscribe(this::getPopularSeriesReturnedData, this::handleError, ()
                        -> getMvpView().stopLoadingIndicator()));
    }


    private void setUpPopularSeries() {
        if (getMvpView().isNetworkConnected()) {
            getMvpView().clearPopularSeries();
            callPopularSeries(true);
        }else
            callPopularSeries(false);


        //        getInteractor().getPopularSeries().subscribe(new Observer<TvResponse>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(TvResponse tvResponse) {
//                List<Tv> seriesList = tvResponse.getResults();
//                getMvpView().updatePopularSeries(seriesList);
//
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
    }



    private void callUpcomingMovies(boolean isNetworkConnected){
        getCompositeDisposable().add(getInteractor()
                .getUpcomingMovies(isNetworkConnected)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui()
                ).subscribe(this::getUpcomingMoviesReturnedData, this::handleError,
                        () -> getMvpView().stopLoadingIndicator()));
    }

    private void setUpUpcomingMovies() {
        if (getMvpView().isNetworkConnected()) {
            getMvpView().clearUpcomingMovies();
            callUpcomingMovies(true);
        }else
            callUpcomingMovies(false);

//        getInteractor().getUpcomingMovies().subscribe(new Observer<MovieResponse>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//            }
//
//            @Override
//            public void onNext(MovieResponse movieResponse) {
//                List<Movie> movies = movieResponse.getMovies();
//                getMvpView().updateUpcomingMovies(movies);
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//            }
//
//            @Override
//            public void onComplete() {
//            }
//        });
    }

    private void callPopularArtists(boolean isNetworkConnected){
        getCompositeDisposable().add(getInteractor()
                .getPopularArtist(isNetworkConnected)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui()
                ).subscribe(this::getPopularArtistReturnedData, this::handleError,
                        () -> getMvpView().stopLoadingIndicator()));
    }


    private void getPopularArtistReturnedData(List<Artist> movieList) {
        if (movieList != null && !movieList.isEmpty()) {
            getMvpView().showPopularArtists(movieList);

        } else {
            getMvpView().showNoDataMessage();
        }


    }


    private void setUpPopularArtists() {
        if (getMvpView().isNetworkConnected()) {
            getMvpView().clearPopularArtists();
            callPopularArtists(true);
        }else
            callPopularArtists(false);




//        getInteractor().getPopularArtist().subscribe(new Observer<ArtistResponse>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(ArtistResponse artistResponse) {
//                List<Artist> artists = artistResponse.getResults();
//                getMvpView().updatePopularArtists(artists);
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
    }


    public void getMoviesTrailes(List<Movie> moviesList) {
        if (moviesList == null) {
            Log.d(TAG, "getMoviesTrailes: ESTA");
            return;
        }


    }


    private void handleError(Throwable error) {
        getMvpView().stopLoadingIndicator();
        getMvpView().showErrorMessage(error.getLocalizedMessage());
    }

}
