package com.devwithbruno.www.movart.data.repository.remote;


import com.devwithbruno.www.movart.BuildConfig;
import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.ArtistResponse;
import com.devwithbruno.www.movart.data.remote.ArtistsService;
import com.devwithbruno.www.movart.data.repository.repositories.PopularArtistsDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Bruno on 15/02/2018.
 */

public class PopularArtistsRemoteDataSource implements PopularArtistsDataSource {

    private ArtistsService artistsService;

    @Inject
    public PopularArtistsRemoteDataSource(ArtistsService artistsService) {
        this.artistsService = artistsService;
    }

    @Override
    public Flowable<List<Artist>> loadArtists(boolean forceRemote) {
        return artistsService.getPopularArtists(BuildConfig.THE_MOVIE_DB_API_TOKEN).map(ArtistResponse::getResults);
    }

    @Override
    public void addArtist(Artist artist) {
        //Currently, we do not need this for remote source.
        throw new UnsupportedOperationException("Unsupported operation");

    }

    @Override
    public void clearData() {
        //Currently, we do not need this for remote source.
        throw new UnsupportedOperationException("Unsupported operation");

    }
}
