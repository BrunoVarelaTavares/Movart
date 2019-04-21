package com.devwithbruno.www.movart.data.repository.repositories;

import com.devwithbruno.www.movart.data.model.RecentVisited;

import java.util.List;

/**
 * Created by Bruno on 12/03/2018.
 */

public interface RecentVisitedDataSource {

    void add(RecentVisited recentVisited);

    List<RecentVisited>  getAll();

    void removeOne(RecentVisited recentVisited);

    void removeAll();




}
