package com.devwithbruno.www.movart.data.model;

/**
 * Created by Bruno on 03/12/2017.
 */


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Transient;

@Entity
public class Tv implements Parcelable {


    @Id
    private long oBoxID;

    @SerializedName("backdrop_path")
    @Expose
    @Transient
    private String backdrop_path;
    @SerializedName("created_by")
    @Expose
    @Transient
    private List<CreatedBy> created_by = new ArrayList<>();
    @SerializedName("episode_run_time")
    @Expose
    @Transient
    private List<Long> episode_run_time = new ArrayList<>();
    @SerializedName("first_air_date")
    @Expose
    private String first_air_date;
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

    @SerializedName("in_production")
    @Expose
    @Transient
    private boolean in_production;
    @SerializedName("languages")
    @Expose
    @Transient
    private List<String> languages = new ArrayList<>();
    @SerializedName("last_air_date")
    @Expose
    @Transient
    private String last_air_date;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("networks")
    @Expose
    @Transient
    private List<Network> networks = new ArrayList<>();
    @SerializedName("number_of_episodes")
    @Expose
    @Transient
    private long number_of_episodes;
    @SerializedName("number_of_seasons")
    @Expose
    @Transient
    private long number_of_seasons;
    @SerializedName("origin_country")
    @Expose
    @Transient
    private List<String> origin_country = new ArrayList<>();
    @SerializedName("original_language")
    @Expose
    private String original_language;
    @SerializedName("original_name")
    @Expose
    private String original_name;
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
    private List<ProductionCompany> production_companies = new ArrayList<>();
    @SerializedName("seasons")
    @Expose
    @Transient
    private List<Season> seasons = new ArrayList<>();
    @SerializedName("status")
    @Expose
    @Transient
    private String status;
    @SerializedName("type")
    @Expose
    @Transient
    private String type;
    @SerializedName("vote_average")
    @Expose
    private double vote_average;
    @SerializedName("vote_count")
    @Expose
    private long vote_count;

    private int tvType;

    public Tv(){

    }


    protected Tv(Parcel in) {
        oBoxID = in.readLong();
        backdrop_path = in.readString();
        created_by = in.createTypedArrayList(CreatedBy.CREATOR);
        first_air_date = in.readString();
        genres = in.createTypedArrayList(Genre.CREATOR);
        homepage = in.readString();
        id = in.readLong();
        in_production = in.readByte() != 0;
        languages = in.createStringArrayList();
        last_air_date = in.readString();
        name = in.readString();
        networks = in.createTypedArrayList(Network.CREATOR);
        number_of_episodes = in.readLong();
        number_of_seasons = in.readLong();
        origin_country = in.createStringArrayList();
        original_language = in.readString();
        original_name = in.readString();
        overview = in.readString();
        popularity = in.readDouble();
        poster_path = in.readString();
        seasons = in.createTypedArrayList(Season.CREATOR);
        status = in.readString();
        type = in.readString();
        vote_average = in.readDouble();
        vote_count = in.readLong();
        tvType = in.readInt();
    }

    public static final Creator<Tv> CREATOR = new Creator<Tv>() {
        @Override
        public Tv createFromParcel(Parcel in) {
            return new Tv(in);
        }

        @Override
        public Tv[] newArray(int size) {
            return new Tv[size];
        }
    };

    public long getOBoxID() {
        return oBoxID;
    }

    public void setOBoxID(long oBoxID) {
        this.oBoxID = oBoxID;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }


    public String getBackdropPath() {
        return backdrop_path;
    }

    public void setBackdropPath(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public List<CreatedBy> getCreatedBy() {
        return created_by;
    }

    public void setCreatedBy(List<CreatedBy> created_by) {
        this.created_by = created_by;
    }

    public List<Long> getEpisodeRunTime() {
        return episode_run_time;
    }

    public void setEpisodeRunTime(List<Long> episode_run_time) {
        this.episode_run_time = episode_run_time;
    }

    public String getFirstAirDate() {
        return first_air_date;
    }

    public void setFirstAirDate(String first_air_date) {
        this.first_air_date = first_air_date;
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

    public boolean isInProduction() {
        return in_production;
    }

    public void setInProduction(boolean in_production) {
        this.in_production = in_production;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getLastAirDate() {
        return last_air_date;
    }

    public void setLastAirDate(String last_air_date) {
        this.last_air_date = last_air_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    public long getNumberOfEpisodes() {
        return number_of_episodes;
    }

    public void setNumberOfEpisodes(long number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

    public long getNumberOfSeasons() {
        return number_of_seasons;
    }

    public void setNumberOfSeasons(long number_of_seasons) {
        this.number_of_seasons = number_of_seasons;
    }

    public List<String> getOriginCountry() {
        return origin_country;
    }

    public void setOriginCountry(List<String> origin_country) {
        this.origin_country = origin_country;
    }

    public String getOriginalLanguage() {
        return original_language;
    }

    public void setOriginalLanguage(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginalName() {
        return original_name;
    }

    public void setOriginalName(String original_name) {
        this.original_name = original_name;
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

    public String getPosterPath() {
        return poster_path;
    }

    public void setPosterPath(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return production_companies;
    }

    public void setProductionCompanies(List<ProductionCompany> production_companies) {
        this.production_companies = production_companies;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getVoteAverage() {
        return vote_average;
    }

    public void setVoteAverage(double vote_average) {
        this.vote_average = vote_average;
    }

    public long getVoteCount() {
        return vote_count;
    }

    public void setVoteCount(long vote_count) {
        this.vote_count = vote_count;
    }

    public int getTvType() {
        return tvType;
    }

    public void setTvType(int tvType) {
        this.tvType = tvType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeLong(oBoxID);
        parcel.writeString(backdrop_path);
        parcel.writeTypedList(created_by);
        parcel.writeString(first_air_date);
        parcel.writeTypedList(genres);
        parcel.writeString(homepage);
        parcel.writeLong(id);
        parcel.writeByte((byte) (in_production ? 1 : 0));
        parcel.writeStringList(languages);
        parcel.writeString(last_air_date);
        parcel.writeString(name);
        parcel.writeTypedList(networks);
        parcel.writeLong(number_of_episodes);
        parcel.writeLong(number_of_seasons);
        parcel.writeStringList(origin_country);
        parcel.writeString(original_language);
        parcel.writeString(original_name);
        parcel.writeString(overview);
        parcel.writeDouble(popularity);
        parcel.writeString(poster_path);
        parcel.writeTypedList(seasons);
        parcel.writeString(status);
        parcel.writeString(type);
        parcel.writeDouble(vote_average);
        parcel.writeLong(vote_count);
        parcel.writeInt(tvType);
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public List<CreatedBy> getCreated_by() {
        return created_by;
    }

    public void setCreated_by(List<CreatedBy> created_by) {
        this.created_by = created_by;
    }

    public List<Long> getEpisode_run_time() {
        return episode_run_time;
    }

    public void setEpisode_run_time(List<Long> episode_run_time) {
        this.episode_run_time = episode_run_time;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public boolean isIn_production() {
        return in_production;
    }

    public void setIn_production(boolean in_production) {
        this.in_production = in_production;
    }

    public String getLast_air_date() {
        return last_air_date;
    }

    public void setLast_air_date(String last_air_date) {
        this.last_air_date = last_air_date;
    }

    public long getNumber_of_episodes() {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(long number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

    public long getNumber_of_seasons() {
        return number_of_seasons;
    }

    public void setNumber_of_seasons(long number_of_seasons) {
        this.number_of_seasons = number_of_seasons;
    }

    public List<String> getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(List<String> origin_country) {
        this.origin_country = origin_country;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public List<ProductionCompany> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<ProductionCompany> production_companies) {
        this.production_companies = production_companies;
    }

    public long getVote_count() {
        return vote_count;
    }

    public void setVote_count(long vote_count) {
        this.vote_count = vote_count;
    }


    @Override
    public String toString() {
        return "Tv{" +
                "oBoxID=" + oBoxID +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", created_by=" + created_by +
                ", episode_run_time=" + episode_run_time +
                ", first_air_date='" + first_air_date + '\'' +
                ", genres=" + genres +
                ", homepage='" + homepage + '\'' +
                ", id=" + id +
                ", in_production=" + in_production +
                ", languages=" + languages +
                ", last_air_date='" + last_air_date + '\'' +
                ", name='" + name + '\'' +
                ", networks=" + networks +
                ", number_of_episodes=" + number_of_episodes +
                ", number_of_seasons=" + number_of_seasons +
                ", origin_country=" + origin_country +
                ", original_language='" + original_language + '\'' +
                ", original_name='" + original_name + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", poster_path='" + poster_path + '\'' +
                ", production_companies=" + production_companies +
                ", seasons=" + seasons +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                ", tvType=" + tvType +
                '}';
    }
}
