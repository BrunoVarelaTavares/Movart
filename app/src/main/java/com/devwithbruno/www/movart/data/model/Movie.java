package com.devwithbruno.www.movart.data.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Transient;

/**
 * Created by Bruno on 28/11/2017.
 */

@Entity
public class Movie implements Parcelable {


    @Id
    private long oBoxID;
    @SerializedName("adult")
    @Expose
    @Transient
    private boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    @Transient
    private String backdrop_path;

    @SerializedName("budget")
    @Expose
    private long budget;
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = new ArrayList<>();

    @SerializedName("homepage")
    @Expose
    @Transient
    private String homepage;

    @SerializedName("id")
    @Expose
   // @Id(assignable = true)
    private long id;
    @SerializedName("imdb_id")
    @Expose
    @Transient
    private String imdb_id;
    @SerializedName("original_language")
    @Expose
    private String original_language;
    @SerializedName("original_title")
    @Expose
    private String original_title;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("popularity")
    @Expose
    private double popularity;
    @SerializedName("poster_path")
    @Expose
    private String poster_path;
    @SerializedName("production_companies")
    @Expose
    @Transient
    private ArrayList<ProductionCompany> production_companies = new ArrayList<>();
    @SerializedName("production_countries")
    @Expose
    @Transient
    private ArrayList<ProductionCountry> production_countries = new ArrayList<>();
    @SerializedName("release_date")
    @Expose
    private String release_date;
    @SerializedName("revenue")
    @Expose
    @Transient
    private long revenue;
    @SerializedName("runtime")
    @Expose
    private int runtime;
    @SerializedName("spoken_languages")
    @Expose
    @Transient
    private ArrayList<SpokenLanguages> spoken_languages = new ArrayList<>();
    @SerializedName("status")
    @Expose
    @Transient
    private String status;
    @SerializedName("tagline")
    @Expose
    @Transient
    private String tagline;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("video")
    @Expose
    @Transient
    private boolean video;
    @SerializedName("vote_average")
    @Expose
    private double vote_average;
    @SerializedName("vote_count")
    @Expose
    @Transient
    private long vote_count;

    private int type;


    public Movie() {

    }


    protected Movie(Parcel in) {
        oBoxID = in.readLong();
        adult = in.readByte() != 0;
        backdrop_path = in.readString();
        budget = in.readLong();
        genres = in.createTypedArrayList(Genre.CREATOR);
        homepage = in.readString();
        id = in.readLong();
        imdb_id = in.readString();
        original_language = in.readString();
        original_title = in.readString();
        overview = in.readString();
        popularity = in.readDouble();
        poster_path = in.readString();
        production_countries = in.createTypedArrayList(ProductionCountry.CREATOR);
        release_date = in.readString();
        revenue = in.readLong();
        runtime = in.readInt();
        spoken_languages = in.createTypedArrayList(SpokenLanguages.CREATOR);
        status = in.readString();
        tagline = in.readString();
        title = in.readString();
        video = in.readByte() != 0;
        vote_average = in.readDouble();
        vote_count = in.readLong();
        type = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

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

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
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

    public ArrayList<ProductionCompany> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(ArrayList<ProductionCompany> production_companies) {
        this.production_companies = production_companies;
    }

    public ArrayList<ProductionCountry> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(ArrayList<ProductionCountry> production_countries) {
        this.production_countries = production_countries;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public ArrayList<SpokenLanguages> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(ArrayList<SpokenLanguages> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public long getOBoxID() {
        return oBoxID;
    }

    public void setOBoxID(long oBoxID) {
        this.oBoxID = oBoxID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(oBoxID);
        parcel.writeByte((byte) (adult ? 1 : 0));
        parcel.writeString(backdrop_path);
        parcel.writeLong(budget);
        parcel.writeTypedList(genres);
        parcel.writeString(homepage);
        parcel.writeLong(id);
        parcel.writeString(imdb_id);
        parcel.writeString(original_language);
        parcel.writeString(original_title);
        parcel.writeString(overview);
        parcel.writeDouble(popularity);
        parcel.writeString(poster_path);
        parcel.writeTypedList(production_countries);
        parcel.writeString(release_date);
        parcel.writeLong(revenue);
        parcel.writeInt(runtime);
        parcel.writeTypedList(spoken_languages);
        parcel.writeString(status);
        parcel.writeString(tagline);
        parcel.writeString(title);
        parcel.writeByte((byte) (video ? 1 : 0));
        parcel.writeDouble(vote_average);
        parcel.writeLong(vote_count);
        parcel.writeInt(type);
    }
}