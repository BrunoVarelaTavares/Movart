package com.devwithbruno.www.movart.data.network.api;

import com.devwithbruno.www.movart.data.model.CreditsResponse;
import com.devwithbruno.www.movart.data.model.ImagesResponse;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.MovieResponse;
import com.devwithbruno.www.movart.data.model.ReviewsResponse;
import com.devwithbruno.www.movart.data.model.TrailerResponse;

import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Bruno on 28/11/2017.
 */

@Singleton
public interface MoviesService {


    @GET("movie/popular")
    Observable<MovieResponse> getPopularMovies(@Query("api_key")String apikey);

    @GET("movie/upcoming")
    Observable<MovieResponse> getUpcomingMovies(@Query("api_key")String apikey);

    @GET("movie/now_playing")
    Observable<MovieResponse> getNowPlayingMovies(@Query("api_key")String apikey);

    @GET("movie/top_rated")
    Observable<MovieResponse> getTopRatedMovies(@Query("api_key")String apikey);

    //movie/latest
    @GET("movie/latest")
    Observable<MovieResponse> getLatestMovies(@Query("api_key")String apikey);


    @GET("movie/{movie_id}/videos")
    Observable<TrailerResponse> getMovieTrailer(@Path("movie_id") long id, @Query("api_key")String apikey);

    @GET("movie/{movie_id}")
    Observable<Movie> getMovie(@Path("movie_id") long id, @Query("api_key")String apikey);

    @GET("movie/{movie_id}/images")
    Observable<ImagesResponse> getMovieImages(@Path("movie_id") long id, @Query("api_key")String apikey);

    //
    @GET("movie/{movie_id}/similar")
    Observable<MovieResponse> getMovieSimilar(@Path("movie_id") long id, @Query("api_key")String apikey);


    @GET("movie/{movie_id}/credits")
    Observable<CreditsResponse> getMovieCredits(@Path("movie_id") long id, @Query("api_key")String apikey);
    ///
    @GET("movie/{movie_id}/reviews")
    Observable<ReviewsResponse> getMovieReviews(@Path("movie_id") long id, @Query("api_key")String apikey);

    //
    @GET("genre/{genre_id}/movies")
    Observable<MovieResponse> getMovieByGenre(@Path("genre_id") long id, @Query("api_key")String apikey);

}
