package com.devwithbruno.www.movart.data.network.api;

import com.devwithbruno.www.movart.data.model.CreditsResponse;
import com.devwithbruno.www.movart.data.model.ImagesResponse;
import com.devwithbruno.www.movart.data.model.TrailerResponse;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.TvResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Bruno on 03/12/2017.
 */

public interface TvService {

    @GET("tv/popular")
    Observable<TvResponse> getPopularSeries(@Query("api_key")String apikey);

    @GET("tv/top_rated")
    Observable<TvResponse> getTopRatedSeries(@Query("api_key")String apikey);

    @GET("tv/on_the_air")
    Observable<TvResponse> getOnTheAirSeries(@Query("api_key")String apikey);

    @GET("tv/airing_today")
    Observable<TvResponse> getAiringTodaySeries(@Query("api_key")String apikey);

    @GET("tv/{tv_id}/videos")
    Observable<TrailerResponse> getTvTrailer(@Path("tv_id") long id, @Query("api_key")String apikey);

    //tv/{tv_id}
    @GET("tv/{tv_id}")
    Observable<Tv> getTv(@Path("tv_id") long id, @Query("api_key")String apikey);


    @GET("tv/{tv_id}/credits")
    Observable<CreditsResponse> getTvCredits(@Path("tv_id") long id, @Query("api_key")String apikey);


    @GET("tv/{tv_id}/images")
    Observable<ImagesResponse> getTvImages(@Path("tv_id") long id, @Query("api_key")String apikey);

    ///tv/{tv_id}/similar
    @GET("tv/{tv_id}/similar")
    Observable<TvResponse> getTvSimilar(@Path("tv_id") long id, @Query("api_key")String apikey);
}
