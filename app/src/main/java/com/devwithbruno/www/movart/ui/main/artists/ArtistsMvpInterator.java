package com.devwithbruno.www.movart.ui.main.artists;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.ui.base.MvpInteractor;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Bruno on 29/01/2018.
 */

public interface ArtistsMvpInterator extends MvpInteractor {


    Flowable<List<Artist>> getPopularArtist(boolean forceRemote);


}
