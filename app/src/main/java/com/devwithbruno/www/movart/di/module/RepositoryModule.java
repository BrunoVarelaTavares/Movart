package com.devwithbruno.www.movart.di.module;

import com.devwithbruno.www.movart.data.repository.local.PopularArtistLocalDataSource;
import com.devwithbruno.www.movart.data.repository.local.PopularMoviesLocalDataSource;
import com.devwithbruno.www.movart.data.repository.local.PopularTvLocalDataSource;
import com.devwithbruno.www.movart.data.repository.local.RecentVisitedLocalDataSource;
import com.devwithbruno.www.movart.data.repository.local.UpcomingMoviesLocalDataSource;
import com.devwithbruno.www.movart.data.repository.local.WatchlistLocalDataSource;
import com.devwithbruno.www.movart.data.repository.remote.PopularArtistsRemoteDataSource;
import com.devwithbruno.www.movart.data.repository.remote.PopularMoviesRemoteDataSource;
import com.devwithbruno.www.movart.data.repository.remote.PopularTvRemoteDataSource;
import com.devwithbruno.www.movart.data.repository.remote.UpcomingMoviesRemoteDataSource;
import com.devwithbruno.www.movart.data.repository.repositories.PopularArtistsDataSource;
import com.devwithbruno.www.movart.data.repository.repositories.PopularMoviesDataSource;
import com.devwithbruno.www.movart.data.repository.repositories.PopularTvDataSource;
import com.devwithbruno.www.movart.data.repository.repositories.RecentVisitedDataSource;
import com.devwithbruno.www.movart.data.repository.repositories.UpcomingMoviesDataSource;
import com.devwithbruno.www.movart.data.repository.repositories.WatchlistDataSource;
import com.devwithbruno.www.movart.di.Local;
import com.devwithbruno.www.movart.di.Remote;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bruno on 22/02/2018.
 */

@Module
public class RepositoryModule {

    @Provides @Local //@Singleton
    public PopularMoviesDataSource providePopularMoviesLocalDataSource(
            PopularMoviesLocalDataSource popularMoviesLocalDataSource){
        return popularMoviesLocalDataSource;
    }


    @Provides @Remote //@Singleton
    public PopularMoviesDataSource providePopularMoviesRemoteDataSource(
            PopularMoviesRemoteDataSource popularMoviesRemoteDataSource){
        return popularMoviesRemoteDataSource;
    }

    @Provides
    @Local
    public UpcomingMoviesDataSource provideUpcomingMoviesLocalDataSource(
            UpcomingMoviesLocalDataSource upcomingMoviesLocalDataSource){
        return upcomingMoviesLocalDataSource;
    }


    @Provides
    @Remote
    public UpcomingMoviesDataSource provideUpcomingMoviesRemoteDataSource(
            UpcomingMoviesRemoteDataSource upcomingMoviesRemoteDataSource){
        return upcomingMoviesRemoteDataSource;
    }


    @Provides
    @Local
    public PopularTvDataSource providePopularTvsLocalDataSource(
            PopularTvLocalDataSource popularTvLocalDataSource){
        return popularTvLocalDataSource;
    }


    @Provides
    @Remote
    public  PopularTvDataSource  providePopularTvRemoteDataSource(
            PopularTvRemoteDataSource upcomingMoviesRemoteDataSource){
        return upcomingMoviesRemoteDataSource;
    }


    @Provides
    @Local
    public PopularArtistsDataSource providePopularArtistsLocalDataSource(
            PopularArtistLocalDataSource popularArtistLocalDataSource){
        return popularArtistLocalDataSource;
    }


    @Provides
    @Remote
    public  PopularArtistsDataSource  providePopularArtistsRemoteDataSource(
            PopularArtistsRemoteDataSource popularArtistsRemoteDataSource){
        return popularArtistsRemoteDataSource;
    }


    @Provides
    @Local
    public RecentVisitedDataSource provideRecentVisitedDataSource(
            RecentVisitedLocalDataSource  recentVisitedLocalDataSource){
        return recentVisitedLocalDataSource;
    }

    @Provides
    @Local
    public WatchlistDataSource provideWatchlistLocalDataSource(
            WatchlistLocalDataSource watchlistLocalDataSource){
                return watchlistLocalDataSource;
    }



}
