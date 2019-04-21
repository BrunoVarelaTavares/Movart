package com.devwithbruno.www.movart.data.repository.repositories;


import com.devwithbruno.www.movart.data.model.Tv;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Bruno on 15/02/2018.
 */

public interface PopularTvDataSource {
    Flowable<List<Tv>> loadTv(boolean forceRemote);

    void addTv(Tv tv);

    void clearData();
}
