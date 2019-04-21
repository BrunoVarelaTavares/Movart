package com.devwithbruno.www.movart.data.model;

/**
 * Created by Bruno on 24/01/2018.
 */

public class MovieAndTrailer {

    MovieResponse movieResponse;
    TrailerResponse trailerResponse;

    public MovieAndTrailer(MovieResponse movieResponse, TrailerResponse trailerResponse) {
        this.movieResponse = movieResponse;
        this.trailerResponse = trailerResponse;
    }

    public MovieResponse getMovieResponse() {
        return movieResponse;
    }

    public void setMovieResponse(MovieResponse movieResponse) {
        this.movieResponse = movieResponse;
    }

    public TrailerResponse getTrailerResponse() {
        return trailerResponse;
    }

    public void setTrailerResponse(TrailerResponse trailerResponse) {
        this.trailerResponse = trailerResponse;
    }
}
