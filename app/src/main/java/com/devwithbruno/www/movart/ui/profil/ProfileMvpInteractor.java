package com.devwithbruno.www.movart.ui.profil;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.RecentVisited;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.ui.base.MvpInteractor;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Bruno on 31/01/2018.
 */

public interface ProfileMvpInteractor extends MvpInteractor {

    Observable<Movie> getMovie(long movieId);

    Observable<Tv>  getTv (long tvId);

    Observable<Artist> getArtist(long tvId);

    void addRecentVisited(RecentVisited recentVisited);

    void clearVisitedHistory();

    List<RecentVisited> getAllRecentVisited();


}
