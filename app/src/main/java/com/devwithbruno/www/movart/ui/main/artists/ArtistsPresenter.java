package com.devwithbruno.www.movart.ui.main.artists;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.ui.base.BasePresenter;
import com.devwithbruno.www.movart.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Bruno on 29/01/2018.
 */

public class ArtistsPresenter<V extends ArtistsMvpView, I extends ArtistsMvpInterator> extends BasePresenter<V, I>
        implements ArtistsMvpPresenter<V, I> {

    @Inject
    public ArtistsPresenter(I mMvpInteractor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(mMvpInteractor, compositeDisposable, schedulerProvider);
    }


    @Override
    public void onViewPrepared() {
        setUpPopularArtists();
    }




    private void setUpPopularArtists() {
            callPopularArtists(false);
    }


    private void callPopularArtists(boolean isNetworkConnected){
        getCompositeDisposable().add(getInteractor()
                .getPopularArtist(isNetworkConnected)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui()
                ).subscribe(this::getPopularArtistReturnedData, this::handleError,
                        () -> getMvpView().stopLoadingIndicator()));
    }

    private void handleError(Throwable error) {
        getMvpView().stopLoadingIndicator();
        //getMvpView().showErrorMessage(error.getLocalizedMessage());
    }



    private void getPopularArtistReturnedData(List<Artist> artistList) {
        if (artistList != null && !artistList.isEmpty()) {
            getMvpView().showArtists(artistList);

        } else {
       //     getMvpView().showNoDataMessage();
        }


    }



}
