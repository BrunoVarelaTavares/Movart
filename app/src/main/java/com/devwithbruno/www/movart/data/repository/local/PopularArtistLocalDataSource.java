package com.devwithbruno.www.movart.data.repository.local;


import com.devwithbruno.www.movart.App;
import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.repository.repositories.PopularArtistsDataSource;

import java.util.List;

import javax.inject.Inject;

import io.objectbox.Box;
import io.reactivex.Flowable;

/**
 * Created by Bruno on 15/02/2018.
 */

public class PopularArtistLocalDataSource implements PopularArtistsDataSource {


    public Box<Artist> artistBox;

   @Inject
    public PopularArtistLocalDataSource() {
        artistBox = App.geBoxStore().boxFor(Artist.class);
    }

    @Override
    public Flowable<List<Artist>> loadArtists(boolean forceRemote) {
        List<Artist> artistList = artistBox.getAll();
        Flowable<List<Artist>> listFlowable = Flowable.fromArray(artistList);
        return listFlowable;
    }


    @Override
    public void addArtist(Artist artist) {artistBox.put(artist);}

    @Override
    public void clearData() {artistBox.removeAll();}
}
