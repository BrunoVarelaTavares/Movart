package com.devwithbruno.www.movart.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bruno on 28/12/2017.
 */

public class Season implements Parcelable {

    @SerializedName("air_date")
    @Expose
    private String air_date;
    @SerializedName("episode_count")
    @Expose
    private long episode_count;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("poster_path")
    @Expose
    private String poster_path;
    @SerializedName("season_number")
    @Expose
    private long season_number;

    protected Season(Parcel in) {
        air_date = in.readString();
        episode_count = in.readLong();
        id = in.readLong();
        poster_path = in.readString();
        season_number = in.readLong();
    }

    public static final Creator<Season> CREATOR = new Creator<Season>() {
        @Override
        public Season createFromParcel(Parcel in) {
            return new Season(in);
        }

        @Override
        public Season[] newArray(int size) {
            return new Season[size];
        }
    };

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public long getEpisode_count() {
        return episode_count;
    }

    public void setEpisode_count(long episode_count) {
        this.episode_count = episode_count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public long getSeason_number() {
        return season_number;
    }

    public void setSeason_number(long season_number) {
        this.season_number = season_number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(air_date);
        parcel.writeLong(episode_count);
        parcel.writeLong(id);
        parcel.writeString(poster_path);
        parcel.writeLong(season_number);
    }


    @Override
    public String toString() {
        return "Season{" +
                "air_date='" + air_date + '\'' +
                ", episode_count=" + episode_count +
                ", id=" + id +
                ", poster_path='" + poster_path + '\'' +
                ", season_number=" + season_number +
                '}';
    }
}

