package com.devwithbruno.www.movart.data.repository.repositories;

import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.di.Local;
import com.devwithbruno.www.movart.di.Remote;
import com.devwithbruno.www.movart.utils.Config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Bruno on 26/02/2018.
 */

public class PopularTvRepository implements PopularTvDataSource {

    private PopularTvDataSource remoteDataSource;
    private PopularTvDataSource localDataSource;

    List<Tv> caches;

    @Inject
    public PopularTvRepository(@Local PopularTvDataSource localDataSource,
                                   @Remote PopularTvDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;

        caches = new ArrayList<>();
    }

    @Override
    public Flowable<List<Tv>> loadTv(boolean forceRemote) {
        if (forceRemote){
            return refreshData();
        }else {
            if (caches.size() > 0){
                return Flowable.just(caches);

            }else {
                return localDataSource.loadTv(false)
                        .take(1)
                        .flatMap(Flowable::fromIterable)
                        .doOnNext(tv -> caches.add(tv))
                        .toList()
                        .toFlowable()
                        .filter(list -> !list.isEmpty())
                        .switchIfEmpty(
                                refreshData());
            }
        }
    }


    Flowable<List<Tv>> refreshData(){
        return remoteDataSource.loadTv(true).doOnNext(list ->{
            caches.clear();
            localDataSource.clearData();
        }).flatMap(Flowable::fromIterable).doOnNext(tv -> {
            tv.setTvType(Config.POPULAR_TV_TYPE);
            caches.add(tv);
            localDataSource.addTv(tv);
        }).toList().toFlowable();
    }



    public Flowable<Tv> getMovie(int tvId){
        return Flowable.fromIterable(caches).filter(tv -> tv.getId() == tvId);
    }


    @Override
    public void addTv(Tv tv) {
        throw  new UnsupportedOperationException("");
    }

    @Override
    public void clearData() {
        caches.clear();
        localDataSource.clearData();

    }
}
