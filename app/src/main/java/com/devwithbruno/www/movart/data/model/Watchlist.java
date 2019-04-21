package com.devwithbruno.www.movart.data.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Bruno on 13/03/2018.
 */

@Entity
public class Watchlist {

    @Id
    private long boxID;

    private  long id;

    private String title;

    private String releaseDate;

    private String posterPath;

    private double voteAverage;

    private int type;

    private boolean isAdded;


    public Watchlist(){

    }


    public long getBoxID() {
        return boxID;
    }

    public void setBoxID(long boxID) {
        this.boxID = boxID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }
}
