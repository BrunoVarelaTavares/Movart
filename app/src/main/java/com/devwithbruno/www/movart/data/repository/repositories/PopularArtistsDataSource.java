package com.devwithbruno.www.movart.data.repository.repositories;


import com.devwithbruno.www.movart.data.model.Artist;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Bruno on 15/02/2018.
 */

public interface PopularArtistsDataSource {
    Flowable<List<Artist>> loadArtists(boolean forceRemote);

    void addArtist(Artist artist);

    void clearData();
}
