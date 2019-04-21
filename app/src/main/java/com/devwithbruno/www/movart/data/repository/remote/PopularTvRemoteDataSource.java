package com.devwithbruno.www.movart.data.repository.remote;


import com.devwithbruno.www.movart.BuildConfig;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.TvResponse;
import com.devwithbruno.www.movart.data.remote.TvService;
import com.devwithbruno.www.movart.data.repository.repositories.PopularTvDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Bruno on 15/02/2018.
 */

public class PopularTvRemoteDataSource implements PopularTvDataSource {

    private TvService tvService;

    @Inject
    public PopularTvRemoteDataSource(TvService tvService) {
        this.tvService = tvService;
    }

    @Override
    public Flowable<List<Tv>> loadTv(boolean forceRemote) {
        return tvService.getPopularSeries(BuildConfig.THE_MOVIE_DB_API_TOKEN).map(TvResponse::getResults);
    }

    @Override
    public void addTv(Tv tv) {

    }

    @Override
    public void clearData() {
        //Currently, we do not need this for remote source.
        throw new UnsupportedOperationException("Unsupported operation");

    }
}
