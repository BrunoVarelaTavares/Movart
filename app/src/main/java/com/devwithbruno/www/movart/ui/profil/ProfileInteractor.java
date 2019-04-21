package com.devwithbruno.www.movart.ui.profil;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.RecentVisited;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.network.ApiHelper;
import com.devwithbruno.www.movart.data.repository.repositories.RecentVisitedRepository;
import com.devwithbruno.www.movart.ui.base.BaseInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Bruno on 31/01/2018.
 */

public class ProfileInteractor extends BaseInteractor implements ProfileMvpInteractor {


    RecentVisitedRepository mRecentVisitedRepository;

    @Inject
    public ProfileInteractor(ApiHelper mApiHelper, RecentVisitedRepository mRecentVisitedRepository) {
        super(mApiHelper);
        this.mRecentVisitedRepository = mRecentVisitedRepository;

    }

    @Override
    public Observable<Movie> getMovie(long movieId) {
        return getApiHelper().getMovie(movieId);
    }

    @Override
    public Observable<Tv> getTv(long tvId) {
        return getApiHelper().getTv(tvId);
    }

    @Override
    public Observable<Artist> getArtist(long tvId) {
        return getApiHelper().getArtist(tvId);
    }

    @Override
    public void addRecentVisited(RecentVisited recentVisited) {
        mRecentVisitedRepository.add(recentVisited);
    }

    @Override
    public void clearVisitedHistory() {
        mRecentVisitedRepository.removeAll();
    }

    @Override
    public List<RecentVisited> getAllRecentVisited() {
        return mRecentVisitedRepository.getAll();
    }
}
