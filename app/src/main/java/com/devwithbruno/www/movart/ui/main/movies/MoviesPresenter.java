package com.devwithbruno.www.movart.ui.main.movies;

import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.MovieResponse;
import com.devwithbruno.www.movart.data.model.Trailer;
import com.devwithbruno.www.movart.data.model.TrailerResponse;
import com.devwithbruno.www.movart.ui.base.BasePresenter;
import com.devwithbruno.www.movart.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Bruno on 26/01/2018.
 */

public class MoviesPresenter<V extends MoviesMvpView, I extends MoviesMvpInteractor> extends BasePresenter<V, I>
        implements MoviesMvpPresenter<V, I> {


    @Inject
    public MoviesPresenter(I mMvpInteractor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(mMvpInteractor, compositeDisposable, schedulerProvider);
    }


    @Override
    public void onViewPrepared() {
        setUpPopularMovies();
        setUpPlayingNowMovies();
        setUpTopRatedMovies();
        setUpUpcomingMovies();
        setUpLatestMovies();

    }

    @Override
    public void onPopularMoviesImageSelect(final List<Movie> movieList,final Movie movie,final String position) {
        getInteractor().getTrailers(movie.getId()).subscribe(new Observer<TrailerResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TrailerResponse trailerResponse) {
                final List<Trailer> trailers = trailerResponse.getResult();
                if (trailers != null){
                    getMvpView().openVideoOnVideoActivity(movieList,movie,position, trailers);
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
    public void onMovieImageSelected(long movieId) {
        getInteractor().getMovie(movieId).subscribe(new Observer<Movie>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Movie movie) {
                if (movie != null){
                    Movie myMovie = movie;
                    getMvpView().openDetailsActivity(myMovie);
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


    private void setUpPopularMovies(){
        getInteractor().getPopularMovies().subscribe(new Observer<MovieResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onNext(MovieResponse movieResponse) {
                List<Movie> movies = movieResponse.getMovies();
                getMvpView().updatePopularMovies(movies);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    private void setUpPlayingNowMovies(){
        getInteractor().getPlayingNowMovies().subscribe(new Observer<MovieResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MovieResponse movieResponse) {
                if (movieResponse != null) {
                    List<Movie> movies = movieResponse.getMovies();
                    getMvpView().updatePlayingNowMovies(movies);

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


    private void setUpTopRatedMovies(){
        getInteractor().getTopRatedMovies().subscribe(new Observer<MovieResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MovieResponse movieResponse) {
                if (movieResponse != null) {
                    List<Movie> movies = movieResponse.getMovies();
                    getMvpView().updateTopRatedMovies(movies);

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


    private void setUpUpcomingMovies(){
       // getMvpView().showLoading();
        getInteractor().getUpcomingMovies().subscribe(new Observer<MovieResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MovieResponse movieResponse) {
                if (movieResponse != null) {
                    List<Movie> movies = movieResponse.getMovies();
                    getMvpView().updateComingSoonMovies(movies);
                    getMvpView().hideLoading();

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

    private void setUpLatestMovies(){
        getInteractor().getPopularMovies().subscribe(new Observer<MovieResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MovieResponse movieResponse) {
                if (movieResponse != null) {
                    List<Movie> movies = movieResponse.getMovies();
                    getMvpView().updateLatestMovies(movies);

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
