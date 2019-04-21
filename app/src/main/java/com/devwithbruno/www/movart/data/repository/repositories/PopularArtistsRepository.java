package com.devwithbruno.www.movart.data.repository.repositories;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.di.Local;
import com.devwithbruno.www.movart.di.Remote;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Bruno on 15/02/2018.
 */

public class PopularArtistsRepository implements  PopularArtistsDataSource {

    private PopularArtistsDataSource remoteDataSource;
    private PopularArtistsDataSource localDataSource;

    List<Artist> caches;

    @Inject
    public PopularArtistsRepository(@Local PopularArtistsDataSource localDataSource,
                                    @Remote PopularArtistsDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;

        caches = new ArrayList<>();
    }

    @Override
    public Flowable<List<Artist>> loadArtists(boolean forceRemote) {
        if (forceRemote){
            return refreshData();
        }else {
            if (caches.size() > 0){
                return Flowable.just(caches);

            }else {
                return localDataSource.loadArtists(false)
                        .take(1)
                        .flatMap(Flowable::fromIterable)
                        .doOnNext(movie -> caches.add(movie))
                        .toList()
                        .toFlowable()
                        .filter(list -> !list.isEmpty())
                        .switchIfEmpty(
                                refreshData());
            }
        }
    }


    Flowable<List<Artist>> refreshData(){
        return remoteDataSource.loadArtists(true).doOnNext(list ->{
            caches.clear();
            localDataSource.clearData();
        }).flatMap(Flowable::fromIterable).doOnNext(artist -> {
            caches.add(artist);
            localDataSource.addArtist(artist);
        }).toList().toFlowable();

    }


    public Flowable<Artist> getArtist(int movieId){
        return Flowable.fromIterable(caches).filter(artist -> artist.getId() == movieId);
    }


    @Override
    public void addArtist(Artist artist) {
        throw  new UnsupportedOperationException("");
    }

    @Override
    public void clearData() {
        caches.clear();
        localDataSource.clearData();

    }
}
