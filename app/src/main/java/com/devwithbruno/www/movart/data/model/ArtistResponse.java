package com.devwithbruno.www.movart.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Bruno on 03/12/2017.
 */

public class ArtistResponse {

        @SerializedName("popularity")
        private double popularity;

        @SerializedName("id")
        private long id;

        @SerializedName("profile_path")
        private String profile_path;

        @SerializedName("name")
        private String name;

        @SerializedName("results")
        private List<Artist> results;

        @SerializedName("adult")
        private boolean adult;

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Artist> getResults() {
        return results;
    }

    public void setResults(List<Artist> results) {
        this.results = results;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }
}
