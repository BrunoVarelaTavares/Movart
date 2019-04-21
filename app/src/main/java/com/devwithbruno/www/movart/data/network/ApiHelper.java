package com.devwithbruno.www.movart.data.network;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.ArtistResponse;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.MovieResponse;
import com.devwithbruno.www.movart.data.model.TrailerResponse;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.TvResponse;
import com.devwithbruno.www.movart.data.network.api.Client;

import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Bruno on 18/01/2018.
 */

@Singleton
public interface ApiHelper {

    Client getClient();

    Observable<Movie> getMovie(long movieId);

    Observable<Tv>  getTv(long tvId);

    Observable<Artist> getArtist(long tvId);

    Observable<MovieResponse> getPopularMovies();

    Observable<MovieResponse> getUpcomingMovies();

    Observable<MovieResponse> getPlayingNowMovies();

    Observable<MovieResponse> getTopRatedMovies();

    Observable<TrailerResponse> getMoviesTrailers(long movieId);

    Observable<TrailerResponse> getTvTrailers(long tvId);

    Observable<ArtistResponse>  getPopularArtists();

    Observable<TvResponse> getPopularSeries();

    Observable<TvResponse> getTopRatedSeries();

    Observable<TvResponse> getOnTheAirSeries();

    Observable<TvResponse> getAiringTodaySeries();



}
