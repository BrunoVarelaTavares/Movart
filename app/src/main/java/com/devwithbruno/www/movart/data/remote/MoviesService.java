package com.devwithbruno.www.movart.data.remote;

import com.devwithbruno.www.movart.data.model.CreditsResponse;
import com.devwithbruno.www.movart.data.model.ImagesResponse;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.MovieResponse;
import com.devwithbruno.www.movart.data.model.ReviewsResponse;
import com.devwithbruno.www.movart.data.model.TrailerResponse;

import javax.inject.Singleton;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Bruno on 28/11/2017.
 */

@Singleton
public interface MoviesService {


    @GET("movie/popular")
    Flowable<MovieResponse> getPopularMovies(@Query("api_key") String apikey);

    @GET("movie/upcoming")
    Flowable<MovieResponse> getUpcomingMovies(@Query("api_key") String apikey);

    @GET("movie/now_playing")
    Flowable<MovieResponse> getNowPlayingMovies(@Query("api_key") String apikey);

    @GET("movie/top_rated")
    Flowable<MovieResponse> getTopRatedMovies(@Query("api_key") String apikey);

    //movie/latest
    @GET("movie/latest")
    Flowable<MovieResponse> getLatestMovies(@Query("api_key") String apikey);


    @GET("movie/{movie_id}/videos")
    Flowable<TrailerResponse> getMovieTrailer(@Path("movie_id") int id, @Query("api_key") String apikey);

    @GET("movie/{movie_id}")
    Flowable<Movie> getMovie(@Path("movie_id") long id, @Query("api_key") String apikey);

    @GET("movie/{movie_id}/images")
    Flowable<ImagesResponse> getMovieImages(@Path("movie_id") int id, @Query("api_key") String apikey);

    //
    @GET("movie/{movie_id}/similar")
    Flowable<MovieResponse> getMovieSimilar(@Path("movie_id") int id, @Query("api_key") String apikey);


    @GET("movie/{movie_id}/credits")
    Flowable<CreditsResponse> getMovieCredits(@Path("movie_id") int id, @Query("api_key") String apikey);
    ///
    @GET("movie/{movie_id}/reviews")
    Flowable<ReviewsResponse> getMovieReviews(@Path("movie_id") int id, @Query("api_key") String apikey);

    //
    @GET("genre/{genre_id}/movies")
    Flowable<MovieResponse> getMovieByGenre(@Path("genre_id") long id, @Query("api_key") String apikey);

}
