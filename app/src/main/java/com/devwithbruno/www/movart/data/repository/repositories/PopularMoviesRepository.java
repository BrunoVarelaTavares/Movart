package com.devwithbruno.www.movart.data.repository.repositories;

import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.di.Local;
import com.devwithbruno.www.movart.di.Remote;
import com.devwithbruno.www.movart.utils.Config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Bruno on 15/02/2018.
 */

public class PopularMoviesRepository implements PopularMoviesDataSource {

    private PopularMoviesDataSource remoteDataSource;
    private PopularMoviesDataSource localDataSource;

    List<Movie> caches;

    @Inject
    public PopularMoviesRepository(@Local PopularMoviesDataSource localDataSource,
                                   @Remote PopularMoviesDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;

        caches = new ArrayList<>();
    }

    @Override
    public Flowable<List<Movie>> loadMovies(boolean forceRemote) {
        if (forceRemote){
            return refreshData();
        }else {
            if (caches.size() > 0){
                return Flowable.just(caches);

            }else {
                return localDataSource.loadMovies(false)
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


    Flowable<List<Movie>> refreshData(){
        return remoteDataSource.loadMovies(true).doOnNext(list ->{
            caches.clear();
            localDataSource.clearData();
        }).flatMap(Flowable::fromIterable).doOnNext(movie -> {
            movie.setType(Config.POPULAR_MOVIES_TYPE);
            caches.add(movie);
            localDataSource.addMovie(movie);
        }).toList().toFlowable();

    }



    public Flowable<Movie> getMovie(int movieId){
        return Flowable.fromIterable(caches).filter(movie -> movie.getId() == movieId);
    }


    @Override
    public void addMovie(Movie movie) {
        throw  new UnsupportedOperationException("");
    }

    @Override
    public void clearData() {
        caches.clear();
        localDataSource.clearData();

    }
}
