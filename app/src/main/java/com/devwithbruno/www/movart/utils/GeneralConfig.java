package com.devwithbruno.www.movart.utils;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.RecentVisited;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.Watchlist;

/**
 * Created by Bruno on 13/03/2018.
 */

public class GeneralConfig {


    public static RecentVisited tvToRecentVisited(Tv tv){
        long id = tv.getId();
        String name = tv.getName();
        String posterPath = tv.getPoster_path();
        //String releaseDate = tv.getRelease_date();
        double voteAverage = tv.getVote_average();
        // int runtime = tv.getEpisode_run_time();
        RecentVisited recentVisited = new RecentVisited();
        recentVisited.setRecentVisiedID(id);
        recentVisited.setName(name);
        recentVisited.setPosterPath(posterPath);
        //  recentVisited.setReleaseDate(releaseDate);
        recentVisited.setVoteAverage(voteAverage);
        recentVisited.setType(Config.TV);
        //  recentVisited.setRuntime(runtime);
        return recentVisited;
    }


    public static RecentVisited artistToRecentVisited(Artist artist){
        long id = artist.getId();
        String name = artist.getName();
        String imagePath = artist.getProfile_path();
        RecentVisited recentVisited = new RecentVisited();
        recentVisited.setRecentVisiedID(id);
        recentVisited.setPosterPath(imagePath);
        recentVisited.setType(Config.ARTIST);
        recentVisited.setName(name);
        return recentVisited;
    }



    public static RecentVisited movieToRecentVisited(Movie movie){
        long id = movie.getId();
        String name = movie.getTitle();
        String posterPath = movie.getPoster_path();
        String releaseDate = movie.getRelease_date();
        double voteAverage = movie.getVote_average();
        int runtime = movie.getRuntime();
        RecentVisited recentVisited = new RecentVisited();
        recentVisited.setRecentVisiedID(id);
        recentVisited.setName(name);
        recentVisited.setPosterPath(posterPath);
        recentVisited.setReleaseDate(releaseDate);
        recentVisited.setVoteAverage(voteAverage);
        recentVisited.setRuntime(runtime);
        recentVisited.setType(Config.MOVIE);
        return recentVisited;
    }


    /**
     *     private long boxID;

     private  long id;

     private String title;

     private String releaseDate;

     private String posterPath;

     private double voteAverage;

     private int type;

     private boolean isAdded;
     *
     *
     * @param movie
     * @return
     */


    public static Watchlist movieToWatchlist(Movie movie){
        long id = movie.getId();
        String mTitle = movie.getTitle();
        String releaseDate = movie.getRelease_date();
        String posterPath = movie.getPoster_path();
        double voteAverage = movie.getVote_average();
        Watchlist watchlist = new Watchlist();
        watchlist.setId(id);
        watchlist.setTitle(mTitle);
        watchlist.setReleaseDate(releaseDate);
        watchlist.setPosterPath(posterPath);
        watchlist.setVoteAverage(voteAverage);
        watchlist.setType(Config.MOVIE);
        return watchlist;


    }


    public static Watchlist tvToWatchlist(Tv tv){
        long id = tv.getId();
        String mTitle = tv.getName();
        String releaseDate = tv.getFirst_air_date();
        String posterPath = tv.getPoster_path();
        double voteAverage = tv.getVote_average();
        Watchlist watchlist = new Watchlist();
        watchlist.setId(id);
        watchlist.setTitle(mTitle);
        watchlist.setReleaseDate(releaseDate);
        watchlist.setPosterPath(posterPath);
        watchlist.setVoteAverage(voteAverage);
        watchlist.setType(Config.TV);
        return watchlist;
    }




}

