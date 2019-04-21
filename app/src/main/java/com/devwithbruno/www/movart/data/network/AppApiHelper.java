package com.devwithbruno.www.movart.data.network;

import com.devwithbruno.www.movart.BuildConfig;
import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.ArtistResponse;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.MovieResponse;
import com.devwithbruno.www.movart.data.model.TrailerResponse;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.TvResponse;
import com.devwithbruno.www.movart.data.network.api.ArtistsService;
import com.devwithbruno.www.movart.data.network.api.Client;
import com.devwithbruno.www.movart.data.network.api.MoviesService;
import com.devwithbruno.www.movart.data.network.api.TvService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Bruno on 18/01/2018.
 */

@Singleton
public class AppApiHelper implements ApiHelper{

    private Client mClient;


    @Inject
    public AppApiHelper(Client client){
        mClient = client;

    }

    @Override
    public Client getClient() {
        return mClient;
    }

    @Override
    public Observable<Movie> getMovie(long movieID) {
        MoviesService apiService = mClient.getClient().create(MoviesService.class);
        Observable<Movie> observable = apiService.getMovie(movieID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;

    }

    @Override
    public Observable<Tv> getTv(long tvId) {
        TvService apiTvService = mClient.getClient().create(TvService.class);
        Observable<Tv> observable = apiTvService.getTv(tvId, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        return observable;
    }

    @Override
    public Observable<Artist> getArtist(long tvId) {
        ArtistsService apiService = mClient.getClient().create(ArtistsService.class);
        Observable<Artist> observable = apiService.getArtist(tvId, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }


    @Override
    public Observable<MovieResponse> getPopularMovies() {
        MoviesService apiService = mClient.getClient().create(MoviesService.class);
        Observable<MovieResponse> observable = apiService.getPopularMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    @Override
    public Observable<MovieResponse> getUpcomingMovies(){
        MoviesService apiService = mClient.getClient().create(MoviesService.class);
        Observable<MovieResponse> observable = apiService.getUpcomingMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    @Override
    public Observable<MovieResponse> getPlayingNowMovies() {
        MoviesService apiService = mClient.getClient().create(MoviesService.class);
        Observable<MovieResponse> observable = apiService.getNowPlayingMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    @Override
    public Observable<MovieResponse> getTopRatedMovies() {
        MoviesService apiService = mClient.getClient().create(MoviesService.class);
        Observable<MovieResponse> observable = apiService.getTopRatedMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }



    @Override
    public Observable<TrailerResponse> getMoviesTrailers(long movieId) {
        MoviesService apiService = mClient.getClient().create(MoviesService.class);
        Observable<TrailerResponse> observable = apiService.getMovieTrailer(movieId, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        return observable;
    }

    @Override
    public Observable<TrailerResponse> getTvTrailers(long tvId) {
        TvService apiService = mClient.getClient().create(TvService.class);
        Observable<TrailerResponse> observable = apiService.getTvTrailer(tvId, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        return observable;

    }

    @Override
    public Observable<ArtistResponse> getPopularArtists() {
        ArtistsService apiService = mClient.getClient().create(ArtistsService.class);
        Observable<ArtistResponse> observable = apiService.getPopularArtists(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    @Override
    public Observable<TvResponse> getPopularSeries() {
        TvService apiService = mClient.getClient().create(TvService.class);
        Observable<TvResponse> observable = apiService.getPopularSeries(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    @Override
    public Observable<TvResponse> getTopRatedSeries() {
        TvService apiService = mClient.getClient().create(TvService.class);
        Observable<TvResponse> observable = apiService.getTopRatedSeries(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    @Override
    public Observable<TvResponse> getOnTheAirSeries() {
        TvService apiService = mClient.getClient().create(TvService.class);
        Observable<TvResponse> observable = apiService.getOnTheAirSeries(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    @Override
    public Observable<TvResponse> getAiringTodaySeries() {
        TvService apiService = mClient.getClient().create(TvService.class);
        Observable<TvResponse> observable = apiService.getAiringTodaySeries(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }



}
