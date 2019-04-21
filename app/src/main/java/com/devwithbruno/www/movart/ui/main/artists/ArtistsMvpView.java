package com.devwithbruno.www.movart.ui.main.artists;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.ui.base.MvpView;

import java.util.List;

/**
 * Created by Bruno on 29/01/2018.
 */

public interface ArtistsMvpView extends MvpView {

   void  stopLoadingIndicator();

   void showArtists(List<Artist>  artists);
}
