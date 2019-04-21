package com.devwithbruno.www.movart.data.repository.local;

import com.devwithbruno.www.movart.App;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.Watchlist;
import com.devwithbruno.www.movart.data.model.Watchlist_;
import com.devwithbruno.www.movart.data.repository.repositories.WatchlistDataSource;
import com.devwithbruno.www.movart.utils.Config;

import java.util.List;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.query.Query;
import io.objectbox.query.QueryBuilder;
import io.reactivex.Flowable;

/**
 * Created by Bruno on 12/03/2018.
 */

public class WatchlistLocalDataSource implements WatchlistDataSource {


    public Box<Watchlist> watchlistBox;

    @Inject
    public WatchlistLocalDataSource() {
        this.watchlistBox = App.geBoxStore().boxFor(Watchlist.class);
    }


    @Override
    public void add(Watchlist watchlist){
//        QueryBuilder<Watchlist> builder = watchlistBox.query();
//        builder.equal(Watchlist_.id , watchlist.getId())
//                .equal(Watchlist_.type, watchlist.getType());
//
//        Query<Watchlist> query = builder.build();
//        if (query.count() > 0){
//            query.remove();
//        }
         watchlistBox.put(watchlist);
    }

    @Override
    public Flowable<List<Watchlist>>getAll(){
        List<Watchlist> recentVisiteds = watchlistBox.getAll();
        Flowable<List<Watchlist>> listFlowable = Flowable.fromArray(recentVisiteds);
        return listFlowable;
    }


    /*

    @Override
    public Flowable<List<Movie>> loadUpcomingMovies(boolean forceRemote) {
        List<Movie> movieList = upcomingMovieBox.query().equal(Movie_.type, Config.UPCOMING_MOVIES_TYPE).build().find();
        Flowable<List<Movie>> listFlowable = Flowable.fromArray(movieList);
        return listFlowable;
    }


     */




    @Override
    public void removeOne(Watchlist watchlist){
        QueryBuilder<Watchlist> builder = watchlistBox.query();
        builder.equal(Watchlist_.id , watchlist.getId())
                .equal(Watchlist_.type, watchlist.getType());

        Query<Watchlist> query = builder.build();
        if (query.count() > 0){
            query.remove();
        }

    }

    @Override
    public void removeAll(){
        watchlistBox.removeAll();
    }

    @Override
    public boolean movieIsOnWatchlist(Movie movie) {
        QueryBuilder<Watchlist> builder = watchlistBox.query();
        builder.equal(Watchlist_.id , movie.getId())
                .equal(Watchlist_.type, Config.MOVIE);
        Query<Watchlist> query = builder.build();

        if (query.count() > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean tvIsOnWatchlist(Tv tv) {
        QueryBuilder<Watchlist> builder = watchlistBox.query();
        builder.equal(Watchlist_.id ,tv.getId())
                .equal(Watchlist_.type, Config.TV);
        Query<Watchlist> query = builder.build();

        if (query.count() > 0){
            return true;
        }else {
            return false;
        }
    }


}
