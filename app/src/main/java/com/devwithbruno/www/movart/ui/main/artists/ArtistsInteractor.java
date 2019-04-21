package com.devwithbruno.www.movart.ui.main.artists;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.network.ApiHelper;
import com.devwithbruno.www.movart.data.repository.repositories.PopularArtistsRepository;
import com.devwithbruno.www.movart.ui.base.BaseInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Bruno on 29/01/2018.
 */

public class ArtistsInteractor extends BaseInteractor implements ArtistsMvpInterator {


    private PopularArtistsRepository mPopularArtistsRepository;


    @Inject
    public ArtistsInteractor(ApiHelper mApiHelper, PopularArtistsRepository mPopularArtistsRepository) {
        super(mApiHelper);
        this.mPopularArtistsRepository = mPopularArtistsRepository;
    }

    @Override
    public Flowable<List<Artist>> getPopularArtist(boolean forceRemote) {
        return mPopularArtistsRepository.loadArtists(forceRemote);
    }
}
