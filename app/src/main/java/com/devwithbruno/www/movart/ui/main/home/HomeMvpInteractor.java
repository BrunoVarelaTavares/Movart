package com.devwithbruno.www.movart.ui.main.home;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.RecentVisited;
import com.devwithbruno.www.movart.data.model.TrailerResponse;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.Watchlist;
import com.devwithbruno.www.movart.ui.base.MvpInteractor;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by Bruno on 18/01/2018.
 */

public interface HomeMvpInteractor extends MvpInteractor {


  // Observable<MovieResponse> getPopularMovies();

   Observable<Movie>  getMovie(long movieId);

   Observable<Tv>  getTv (long tvId);

   Observable<Artist> getArtist(long tvId);

  // Observable<MovieResponse> getUpcomingMovies();

   //Observable<TvResponse> getPopularSeries();

//   Observable<ArtistResponse> getPopularArtist();


//   Observable<ArtistResponse> getPopularArtist();

   Observable<TrailerResponse> getTrailers(long movieID);


   Flowable<List<Movie>> getPopularMovies(boolean forceRemote);

   Flowable<List<Movie>> getUpcomingMovies( boolean forceRemote);

   Flowable<List<Tv>> getPopularSeries(boolean forceRemote);

   Flowable<List<Artist>> getPopularArtist(boolean forceRemote);


   void addRecentVisited(RecentVisited recentVisited);

   void addToWatchlist(Watchlist watchlist);

   void removeFromWatchlist(Watchlist watchlist);

   boolean movieIsOnWatchlist(Movie movie);

   boolean tvisOnWatchlist(Tv tv);


}