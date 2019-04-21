package com.devwithbruno.www.movart.utils;

/**
 * Created by Bruno on 19/02/2018.
 */

public class Config {
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    public static final String MOVIES_TABLE_NAME = "movies";
    public static final String TV_TABLE_NAME = "tv";


    //  public static final String UPCOMING_MOVIES_TABLE_NAME = "upcomingmovies";
    public static final String UPCOMING_MOVIES__NAME = "upcomingmovies";


    public static final String DATABASE_POPULAR_MOVIES_NAME = "PopularMovies.db";
    public static final String DATABASE_UPCOMING_MOVIES_NAME = "PopularMovies.db";


    //Movies types
    public static final int POPULAR_MOVIES_TYPE = 0;
    public static final int UPCOMING_MOVIES_TYPE = 1;
    public static final int IN_CINEMAS_MOVIES_TYPE = 2;
    public static final int TOP_RATED_MOVIES_TYPE = 3;


    //Tv types
    public static final int POPULAR_TV_TYPE = 0;
    public static final int TOP_RATED_TV_TYPE = 1;
    public static final int ON_THE_AIR_TV_TYPE = 2;
    public static final int AIRING_TODAY_TV_TYPE = 3;


    //  RecentVisited TYpe
    public static final int MOVIE = 0;
    public static final int TV = 1;
    public static final int ARTIST = 2;

}
