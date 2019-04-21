package com.devwithbruno.www.movart.data.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Bruno on 12/03/2018.
 */

@Entity
public class RecentVisited {

    @Id
    private  long id;

    private long recentVisiedID;

    private String name;

    private String releaseDate;

    private String posterPath;

    private double voteAverage;

    private int runtime;

    private double date;

    private int type;


    public RecentVisited(){

    }


    public long getRecentVisiedID() {
        return recentVisiedID;
    }

    public void setRecentVisiedID(long recentVisiedID) {
        this.recentVisiedID = recentVisiedID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "RecentVisited{" +
                "id=" + id +
                ", recentVisiedID=" + recentVisiedID +
                ", name='" + name + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", voteAverage=" + voteAverage +
                ", runtime=" + runtime +
                ", date=" + date +
                ", type=" + type +
                '}';
    }
}
