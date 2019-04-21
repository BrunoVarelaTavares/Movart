package com.devwithbruno.www.movart.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 25/12/2017.
 */

public class Media implements Parcelable {

    @SerializedName("popularity")
    @Expose
    private double popularity;
    @SerializedName("vote_count")
    @Expose
    private long vote_count;
    @SerializedName("video")
    @Expose
    private boolean video;
    @SerializedName("poster_path")
    @Expose
    private String poster_path;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("adult")
    @Expose
    private boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    private String backdrop_path;
    @SerializedName("original_language")
    @Expose
    private String original_language;
    @SerializedName("original_title")
    @Expose
    private String original_title;
    @SerializedName("genre_ids")
    @Expose
    private List<Long> genre_ids = new ArrayList<>();
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("vote_average")
    @Expose
    private double vote_average;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("release_date")
    @Expose
    private String release_date;

    protected Media(Parcel in) {
        popularity = in.readDouble();
        vote_count = in.readLong();
        video = in.readByte() != 0;
        poster_path = in.readString();
        id = in.readLong();
        adult = in.readByte() != 0;
        backdrop_path = in.readString();
        original_language = in.readString();
        original_title = in.readString();
        title = in.readString();
        vote_average = in.readDouble();
        overview = in.readString();
        release_date = in.readString();
    }

    public static final Creator<Media> CREATOR = new Creator<Media>() {
        @Override
        public Media createFromParcel(Parcel in) {
            return new Media(in);
        }

        @Override
        public Media[] newArray(int size) {
            return new Media[size];
        }
    };

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public long getVote_count() {
        return vote_count;
    }

    public void setVote_count(long vote_count) {
        this.vote_count = vote_count;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(popularity);
        parcel.writeLong(vote_count);
        parcel.writeByte((byte) (video ? 1 : 0));
        parcel.writeString(poster_path);
        parcel.writeLong(id);
        parcel.writeByte((byte) (adult ? 1 : 0));
        parcel.writeString(backdrop_path);
        parcel.writeString(original_language);
        parcel.writeString(original_title);
        parcel.writeString(title);
        parcel.writeDouble(vote_average);
        parcel.writeString(overview);
        parcel.writeString(release_date);
    }


    @Override
    public String toString() {
        return "Media{" +
                "popularity=" + popularity +
                ", vote_count=" + vote_count +
                ", video=" + video +
                ", poster_path='" + poster_path + '\'' +
                ", id=" + id +
                ", adult=" + adult +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", genre_ids=" + genre_ids +
                ", title='" + title + '\'' +
                ", vote_average=" + vote_average +
                ", overview='" + overview + '\'' +
                ", release_date='" + release_date + '\'' +
                '}';
    }
}


