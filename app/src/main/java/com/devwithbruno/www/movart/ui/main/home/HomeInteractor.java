package com.devwithbruno.www.movart.ui.main.home;

import android.util.Log;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.RecentVisited;
import com.devwithbruno.www.movart.data.model.TrailerResponse;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.Watchlist;
import com.devwithbruno.www.movart.data.network.ApiHelper;
import com.devwithbruno.www.movart.data.repository.repositories.PopularArtistsRepository;
import com.devwithbruno.www.movart.data.repository.repositories.PopularMoviesRepository;
import com.devwithbruno.www.movart.data.repository.repositories.PopularTvRepository;
import com.devwithbruno.www.movart.data.repository.repositories.RecentVisitedRepository;
import com.devwithbruno.www.movart.data.repository.repositories.UpcomingMoviesRepository;
import com.devwithbruno.www.movart.data.repository.repositories.WatchlistRepository;
import com.devwithbruno.www.movart.ui.base.BaseInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by Bruno on 18/01/2018.
 */

public class HomeInteractor extends BaseInteractor implements HomeMvpInteractor {

    private static final String TAG = "HomeInteractor";

    private PopularMoviesRepository mPopularMoviesRepository;
    private UpcomingMoviesRepository mUpcomingMoviesRepository;
    private PopularTvRepository mPopularTvRepository;
    private PopularArtistsRepository mPopularArtistsRepository;
    private RecentVisitedRepository mRecentVisitedRepository;
    private WatchlistRepository mWatchlistRepository;

    @Inject
    public HomeInteractor(ApiHelper mApiHelper, PopularMoviesRepository popularMoviesRepository,
                          UpcomingMoviesRepository upcomingMoviesRepository, PopularTvRepository mPopularTvRepository,
                          PopularArtistsRepository mPopularArtistsRepository,
                          RecentVisitedRepository mRecentVisitedRepository,
                          WatchlistRepository mWatchlistRepository) {
        super(mApiHelper);
        this.mPopularMoviesRepository = popularMoviesRepository;
        this.mUpcomingMoviesRepository = upcomingMoviesRepository;
        this.mPopularTvRepository = mPopularTvRepository;
        this.mPopularArtistsRepository = mPopularArtistsRepository;
        this.mRecentVisitedRepository = mRecentVisitedRepository;
        this.mWatchlistRepository = mWatchlistRepository;

        Log.d(TAG, "HomeInteractor: ");
    }

//    @Override
//    public Observable<MovieResponse> getPopularMovies() {
//       return getApiHelper().getPopularMovies();
//    }

    @Override
    public Observable<Movie> getMovie(long movieId) {
        return getApiHelper().getMovie(movieId);
    }

    @Override
    public Observable<Tv> getTv(long tvId) {
        return getApiHelper().getTv(tvId);
    }

    @Override
    public Observable<Artist> getArtist(long tvId) {
        return getApiHelper().getArtist(tvId);
    }

//    @Override
//    public Observable<MovieResponse> getUpcomingMovies() {
//        return getApiHelper().getUpcomingMovies();
//    }

//    @Override
//    public Observable<TvResponse> getPopularSeries() {
//        return getApiHelper().getPopularSeries();
//    }

//    @Override
//    public Observable<ArtistResponse> getPopularArtist() {
//        return getApiHelper().getPopularArtists();
//    }

    @Override
    public Observable<TrailerResponse> getTrailers(long movieId) {
        return getApiHelper().getMoviesTrailers(movieId);
    }

    @Override
    public Flowable<List<Movie>> getPopularMovies(boolean forceRemote) {
        return mPopularMoviesRepository.loadMovies(forceRemote);
    }

    @Override
    public Flowable<List<Movie>> getUpcomingMovies(boolean forceRemote) {
        return mUpcomingMoviesRepository.loadUpcomingMovies(forceRemote);
    }

    @Override
    public Flowable<List<Tv>> getPopularSeries(boolean forceRemote) {
        return mPopularTvRepository.loadTv(forceRemote);
    }

    @Override
    public Flowable<List<Artist>> getPopularArtist(boolean forceRemote) {
        return mPopularArtistsRepository.loadArtists(forceRemote);
    }

    @Override
    public void addRecentVisited(RecentVisited recentVisited) {
        mRecentVisitedRepository.add(recentVisited);

    }

    @Override
    public void addToWatchlist(Watchlist watchlist) {
        mWatchlistRepository.add(watchlist);
    }

    @Override
    public void removeFromWatchlist(Watchlist watchlist) {
        mWatchlistRepository.removeOne(watchlist);

    }

    @Override
    public boolean movieIsOnWatchlist(Movie movie) {
        return mWatchlistRepository.movieIsOnWatchlist(movie);
    }

    @Override
    public boolean tvisOnWatchlist(Tv tv) {
        return mWatchlistRepository.tvIsOnWatchlist(tv);
    }


}
