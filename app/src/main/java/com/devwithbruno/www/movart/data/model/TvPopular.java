package com.devwithbruno.www.movart.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 28/12/2017.
 */

public class TvPopular {


    @SerializedName("original_name")
    @Expose
    private String original_name;
    @SerializedName("genre_ids")
    @Expose
    private List<Long> genre_ids = new ArrayList<>();
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("popularity")
    @Expose
    private double popularity;
    @SerializedName("origin_country")
    @Expose
    private List<String> origin_country = new ArrayList<>();
    @SerializedName("vote_count")
    @Expose
    private long vote_count;
    @SerializedName("first_air_date")
    @Expose
    private String first_air_date;
    @SerializedName("backdrop_path")
    @Expose
    private String backdrop_path;
    @SerializedName("original_language")
    @Expose
    private String original_language;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("vote_average")
    @Expose
    private double vote_average;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("poster_path")
    @Expose
    private String poster_path;

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public List<Long> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Long> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public List<String> getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(List<String> origin_country) {
        this.origin_country = origin_country;
    }

    public long getVote_count() {
        return vote_count;
    }

    public void setVote_count(long vote_count) {
        this.vote_count = vote_count;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
