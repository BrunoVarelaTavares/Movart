package com.devwithbruno.www.movart.data.remote;

import com.devwithbruno.www.movart.data.model.CreditsResponse;
import com.devwithbruno.www.movart.data.model.ImagesResponse;
import com.devwithbruno.www.movart.data.model.TrailerResponse;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.TvResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Bruno on 03/12/2017.
 */

public interface TvService {

    @GET("tv/popular")
    Flowable<TvResponse> getPopularSeries(@Query("api_key") String apikey);

    @GET("tv/top_rated")
    Flowable<TvResponse> getTopRatedSeries(@Query("api_key") String apikey);

    @GET("tv/on_the_air")
    Flowable<TvResponse> getOnTheAirSeries(@Query("api_key") String apikey);

    @GET("tv/airing_today")
    Flowable<TvResponse> getAiringTodaySeries(@Query("api_key") String apikey);

    @GET("tv/{tv_id}/videos")
    Flowable<TrailerResponse> getTvTrailer(@Path("tv_id") long id, @Query("api_key") String apikey);

    //tv/{tv_id}
    @GET("tv/{tv_id}")
    Flowable<Tv> getTv(@Path("tv_id") long id, @Query("api_key") String apikey);


    @GET("tv/{tv_id}/credits")
    Flowable<CreditsResponse> getTvCredits(@Path("tv_id") long id, @Query("api_key") String apikey);


    @GET("tv/{tv_id}/images")
    Flowable<ImagesResponse> getTvImages(@Path("tv_id") long id, @Query("api_key") String apikey);

    ///tv/{tv_id}/similar
    @GET("tv/{tv_id}/similar")
    Flowable<TvResponse> getTvSimilar(@Path("tv_id") long id, @Query("api_key") String apikey);
}
