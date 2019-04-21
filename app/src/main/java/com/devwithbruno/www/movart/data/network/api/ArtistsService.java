package com.devwithbruno.www.movart.data.network.api;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.ArtistCastResponse;
import com.devwithbruno.www.movart.data.model.ArtistResponse;
import com.devwithbruno.www.movart.data.model.ArtistsImageResponse;
import com.devwithbruno.www.movart.data.model.TaggedImagesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Bruno on 03/12/2017.
 */

public interface ArtistsService {

    @GET("person/popular")
    Observable<ArtistResponse> getPopularArtists(@Query("api_key")String apikey);

    @GET("person/{person_id}")
    Observable<Artist> getArtist(@Path("person_id") long id, @Query("api_key")String apikey);


    @GET("person/{person_id}/images")
    Observable<ArtistsImageResponse> getArtistsImages(@Path("person_id") long id, @Query("api_key")String apikey);


    @GET("person/{person_id}/tagged_images")
    Observable<TaggedImagesResponse> getArtistsTaggedImages(@Path("person_id") long id, @Query("api_key")String apikey);

    @GET("person/{person_id}/combined_credits")
    Observable<ArtistCastResponse> getArtistsCredits(@Path("person_id") long id, @Query("api_key")String apikey);


    @GET("person/{person_id}/movie_credits")
    Observable<ArtistCastResponse> getArtistMoviesCredits(@Path("person_id") long id, @Query("api_key")String apikey);


    @GET("person/{person_id}/tv_credits")
    Observable<ArtistCastResponse> getArtistTVCredits(@Path("person_id") long id, @Query("api_key")String apikey);

}
