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

public class ArtistCast implements Parcelable {


    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("character")
    @Expose
    private String character;
    @SerializedName("original_title")
    @Expose
    private String original_title;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("vote_count")
    @Expose
    private long vote_count;
    @SerializedName("video")
    @Expose
    private boolean video;
    @SerializedName("media_type")
    @Expose
    private String media_type;
    @SerializedName("release_date")
    @Expose
    private String release_date;
    @SerializedName("vote_average")
    @Expose
    private double vote_average;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("popularity")
    @Expose
    private double popularity;
    @SerializedName("original_language")
    @Expose
    private String original_language;
    @SerializedName("genre_ids")
    @Expose
    private List<Long> genre_ids = new ArrayList<>();
    @SerializedName("backdrop_path")
    @Expose
    private String backdrop_path;
    @SerializedName("adult")
    @Expose
    private boolean adult;
    @SerializedName("poster_path")
    @Expose
    private String poster_path;
    @SerializedName("credit_id")
    @Expose
    private String credit_id;
    @SerializedName("episode_count")
    @Expose
    private long episode_count;
    @SerializedName("origin_country")
    @Expose
    private List<String> origin_country = new ArrayList<>();
    @SerializedName("original_name")
    @Expose
    private String original_name;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("first_air_date")
    @Expose
    private String first_air_date;

    protected ArtistCast(Parcel in) {
        id = in.readLong();
        character = in.readString();
        original_title = in.readString();
        overview = in.readString();
        vote_count = in.readLong();
        video = in.readByte() != 0;
        media_type = in.readString();
        release_date = in.readString();
        vote_average = in.readDouble();
        title = in.readString();
        popularity = in.readDouble();
        original_language = in.readString();
        backdrop_path = in.readString();
        adult = in.readByte() != 0;
        poster_path = in.readString();
        credit_id = in.readString();
        episode_count = in.readLong();
        origin_country = in.createStringArrayList();
        original_name = in.readString();
        name = in.readString();
        first_air_date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(character);
        dest.writeString(original_title);
        dest.writeString(overview);
        dest.writeLong(vote_count);
        dest.writeByte((byte) (video ? 1 : 0));
        dest.writeString(media_type);
        dest.writeString(release_date);
        dest.writeDouble(vote_average);
        dest.writeString(title);
        dest.writeDouble(popularity);
        dest.writeString(original_language);
        dest.writeString(backdrop_path);
        dest.writeByte((byte) (adult ? 1 : 0));
        dest.writeString(poster_path);
        dest.writeString(credit_id);
        dest.writeLong(episode_count);
        dest.writeStringList(origin_country);
        dest.writeString(original_name);
        dest.writeString(name);
        dest.writeString(first_air_date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ArtistCast> CREATOR = new Creator<ArtistCast>() {
        @Override
        public ArtistCast createFromParcel(Parcel in) {
            return new ArtistCast(in);
        }

        @Override
        public ArtistCast[] newArray(int size) {
            return new ArtistCast[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
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

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
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

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
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

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public long getEpisode_count() {
        return episode_count;
    }

    public void setEpisode_count(long episode_count) {
        this.episode_count = episode_count;
    }

    public List<String> getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(List<String> origin_country) {
        this.origin_country = origin_country;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    @Override
    public String toString() {
        return "ArtistCast{" +
                "id=" + id +
                ", character='" + character + '\'' +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", vote_count=" + vote_count +
                ", video=" + video +
                ", media_type='" + media_type + '\'' +
                ", release_date='" + release_date + '\'' +
                ", vote_average=" + vote_average +
                ", title='" + title + '\'' +
                ", popularity=" + popularity +
                ", original_language='" + original_language + '\'' +
                ", genre_ids=" + genre_ids +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", adult=" + adult +
                ", poster_path='" + poster_path + '\'' +
                ", credit_id='" + credit_id + '\'' +
                ", episode_count=" + episode_count +
                ", origin_country=" + origin_country +
                ", original_name='" + original_name + '\'' +
                ", name='" + name + '\'' +
                ", first_air_date='" + first_air_date + '\'' +
                '}';
    }
}
