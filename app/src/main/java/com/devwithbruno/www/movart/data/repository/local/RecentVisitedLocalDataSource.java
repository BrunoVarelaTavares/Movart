package com.devwithbruno.www.movart.data.repository.local;

import com.devwithbruno.www.movart.App;
import com.devwithbruno.www.movart.data.model.RecentVisited;
import com.devwithbruno.www.movart.data.model.RecentVisited_;
import com.devwithbruno.www.movart.data.repository.repositories.RecentVisitedDataSource;

import java.util.List;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.query.Query;
import io.objectbox.query.QueryBuilder;

/**
 * Created by Bruno on 12/03/2018.
 */

public class RecentVisitedLocalDataSource implements RecentVisitedDataSource {


    public Box<RecentVisited> visitedBox;

    @Inject
    public RecentVisitedLocalDataSource() {
        this.visitedBox = App.geBoxStore().boxFor(RecentVisited.class);
    }

    private static final String TAG = "RecentVisitedLocalDataS";
    @Override
    public void add(RecentVisited recentVisited){
        QueryBuilder<RecentVisited> builder = visitedBox.query();
        builder.equal(RecentVisited_.recentVisiedID , recentVisited.getRecentVisiedID())
                .equal(RecentVisited_.type, recentVisited.getType());

       Query<RecentVisited> query = builder.build();
        if (query.count() > 0){
           query.remove();
       }
        visitedBox.put(recentVisited);
    }

    @Override
    public List<RecentVisited> getAll(){
        List<RecentVisited> recentVisiteds = visitedBox.getAll();
        return recentVisiteds;
    }

    @Override
    public void removeOne(RecentVisited recentVisited){
        long id = recentVisited.getId();
        visitedBox.remove(id);
    }

    @Override
    public void removeAll(){
        visitedBox.removeAll();
    }


}
