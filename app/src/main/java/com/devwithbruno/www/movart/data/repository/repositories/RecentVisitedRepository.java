package com.devwithbruno.www.movart.data.repository.repositories;

import com.devwithbruno.www.movart.data.model.RecentVisited;
import com.devwithbruno.www.movart.di.Local;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Bruno on 12/03/2018.
 */

public class RecentVisitedRepository implements RecentVisitedDataSource {

    private RecentVisitedDataSource mRecentVisitedLocalDataSource;

    @Inject
    public RecentVisitedRepository(@Local RecentVisitedDataSource mRecentVisitedLocalDataSource){
        this.mRecentVisitedLocalDataSource = mRecentVisitedLocalDataSource;
    }
    public void add(RecentVisited recentVisited) {mRecentVisitedLocalDataSource.add(recentVisited);}

    @Override
    public List<RecentVisited>getAll() {return mRecentVisitedLocalDataSource.getAll();}

    @Override
    public void removeOne(RecentVisited recentVisited) {mRecentVisitedLocalDataSource.removeOne(recentVisited);}

    @Override
    public void removeAll() {mRecentVisitedLocalDataSource.removeAll();}
}
