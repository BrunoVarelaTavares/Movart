package com.devwithbruno.www.movart.ui.profil;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.RecentVisited;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.ui.base.BasePresenter;
import com.devwithbruno.www.movart.utils.GeneralConfig;
import com.devwithbruno.www.movart.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Bruno on 31/01/2018.
 */

public class ProfilePresenter<V extends ProfileMvpView, I extends ProfileMvpInteractor>
        extends BasePresenter<V, I> implements ProfileMvpPresenter<V,I> {

    @Inject
    public ProfilePresenter(I mMvpInteractor, CompositeDisposable compositeDisposable,
                            SchedulerProvider schedulerProvider) {
        super(mMvpInteractor, compositeDisposable, schedulerProvider);
    }

    @Override
    public void openFavoritesFragment() {
        getMvpView().showFavoriteFragment();
    }

    @Override
    public void openListsFragment() {
        getMvpView().showListsFragment();
    }

    @Override
    public void openRatingsFragment() {
        getMvpView().showRatingFragment();
    }

    @Override
    public void openWatchlistFragment() {
        getMvpView().showWatchlistFragment();
    }

    @Override
    public void clearVisitedHistory() {
        getInteractor().clearVisitedHistory();
    }

    @Override
    public void onMovieImageSelect(long movieID) {
        getInteractor().getMovie(movieID).subscribe(new Observer<Movie>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Movie movie) {
                if (movie != null) {
                    Movie myMovie = movie;
                    getInteractor().addRecentVisited(GeneralConfig.movieToRecentVisited(movie));
                    getMvpView().openMovieDetailsOnDetailsActivity(myMovie);
                }

            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onTvImageSelect(long tvId) {
        getInteractor().getTv(tvId).subscribe(new Observer<Tv>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Tv tv) {
                if (tv != null) {
                    Tv myTv = tv;
                    getInteractor().addRecentVisited(GeneralConfig.tvToRecentVisited(tv));
                    getMvpView().openTvDetailsOnDetailsActivity(myTv);
                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void onArtistImageSelect(long artistId) {
        getInteractor().getArtist(artistId).subscribe(new Observer<Artist>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Artist artist) {
                if (artist != null) {
                    Artist myArtist = artist;
                    getInteractor().addRecentVisited(GeneralConfig.artistToRecentVisited(artist));
                    getMvpView().openArtistDetails(myArtist);

                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public List<RecentVisited> getAllRecentVisited() {
        return getInteractor().getAllRecentVisited();
    }
}
