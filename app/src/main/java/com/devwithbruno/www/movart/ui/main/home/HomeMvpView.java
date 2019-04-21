package com.devwithbruno.www.movart.ui.main.home;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.Trailer;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.ui.base.MvpView;

import java.util.List;

/**
 * Created by Bruno on 17/01/2018.
 */

public interface HomeMvpView extends MvpView {


   void updatePopularMovies(List<Movie> movieList);

   void updateUpcomingMovies(List<Movie> movieList);

   void updatePopularSeries(List<Tv> tvList);

   void updatePopularArtists(List<Artist> artistList);

   void openMovieDetailsOnDetailsActivity(Movie movie);

   void openTvDatailsOnDetailsActivity(Tv tv);

   void openArtistOnArtistActivity(Artist artist, Artist artistInfo);

   //List<Movie> movieList, Movie movie, int movieId, String positio
   void openVideoOnVideoActivity(List<Movie> movieList, Movie movie,String position, List<Trailer> trailerList);



   //
   void showPopularMovies(List<Movie> movies);

   void showUpcomingMovies(List<Movie> movies);

   void showPopularSeries(List<Tv> series);

   void showPopularArtists(List<Artist> artists);

   void clearPopularMovies();

   void clearUpcomingMovies();

   void clearPopularSeries();

   void clearPopularArtists();

   void showNoDataMessage();

   void showErrorMessage(String error);

   void showMovieDetail(Movie movie);

   void stopLoadingIndicator();


}
