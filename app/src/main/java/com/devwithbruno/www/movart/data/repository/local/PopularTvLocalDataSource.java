package com.devwithbruno.www.movart.data.repository.local;


import android.util.Log;

import com.devwithbruno.www.movart.App;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.Tv_;
import com.devwithbruno.www.movart.data.repository.repositories.PopularTvDataSource;
import com.devwithbruno.www.movart.utils.Config;

import java.util.List;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.query.Query;
import io.reactivex.Flowable;

/**
 * Created by Bruno on 15/02/2018.
 */

public class PopularTvLocalDataSource implements PopularTvDataSource {

    Box<Tv> tvBox;


    @Inject
    public PopularTvLocalDataSource() {
        tvBox = App.geBoxStore().boxFor(Tv.class);
    }

    @Override
    public Flowable<List<Tv>> loadTv(boolean forceRemote) {
        List<Tv> tvList = tvBox.query().equal(Tv_.tvType, Config.POPULAR_TV_TYPE).build().find();
        Flowable<List<Tv>> listFlowable = Flowable.fromArray(tvList);
        return listFlowable;
    }

    @Override
    public void addTv(Tv tv) {
        tvBox.put(tv);
    }

    private static final String TAG = "PopularTvLocalDataSourc";


    @Override
    public void clearData() {
        Query<Tv> query = tvBox.query().equal(Tv_.tvType, Config.POPULAR_TV_TYPE).build();
        Log.d(TAG, "clearData: DADADAD " + query.count());
        query.remove();
      //  tvBox.removeAll();
    }
}
