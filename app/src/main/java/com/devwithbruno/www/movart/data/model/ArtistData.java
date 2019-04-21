package com.devwithbruno.www.movart.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 03/12/2017.
 */

public class ArtistData {

    @SerializedName("vote_average")
    private double vote_average;
    @SerializedName("vote_count")
    private long vote_count;
    @SerializedName("id")
    private long id;
    @SerializedName("video")
    private boolean video;
    @SerializedName("media_type")

    private String media_type;
    @SerializedName("title")

    private String title;
    @SerializedName("popularity")

    private double popularity;
    @SerializedName("poster_path")

    private String poster_path;
    @SerializedName("original_language")

    private String original_language;
    @SerializedName("original_title")

    private String original_title;
    @SerializedName("genre_ids")

    private List<Long> genre_ids = new ArrayList<>();
    @SerializedName("backdrop_path")

    private String backdrop_path;
    @SerializedName("adult")

    private boolean adult;
    @SerializedName("overview")

    private String overview;
    @SerializedName("release_date")

    private String release_date;

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public long getVote_count() {
        return vote_count;
    }

    public void setVote_count(long vote_count) {
        this.vote_count = vote_count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public List<Long> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Long> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @Override
    public String toString() {
        return "ArtistData{" +
                "vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                ", id=" + id +
                ", video=" + video +
                ", media_type='" + media_type + '\'' +
                ", title='" + title + '\'' +
                ", popularity=" + popularity +
                ", poster_path='" + poster_path + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", genre_ids=" + genre_ids +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", adult=" + adult +
                ", overview='" + overview + '\'' +
                ", release_date='" + release_date + '\'' +
                '}';
    }
}
