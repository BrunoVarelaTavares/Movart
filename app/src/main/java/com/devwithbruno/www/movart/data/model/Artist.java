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
 * Created by Bruno on 03/12/2017.
 */

@Entity
public class Artist implements Parcelable {


    @Id
    private long oBoxID;

    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("deathday")
    @Expose
    private String deathday;
    @SerializedName("id")
    @Expose
    //@Id(assignable = true)
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    //    @SerializedName("also_known_as")
//    @Expose
//    private List<Movie> also_known_as = new ArrayList<>();
    @SerializedName("known_for")
    @Expose
    private List<KnowFor> known_for = new ArrayList<>();
    @SerializedName("gender")
    @Expose
    private long gender;
    @SerializedName("biography")
    @Expose
    private String biography;
    @SerializedName("popularity")
    @Expose
    private double popularity;
    @SerializedName("place_of_birth")
    @Expose
    private String place_of_birth;
    @SerializedName("profile_path")
    @Expose
    private String profile_path;
    @SerializedName("adult")
    @Expose
    @Transient
    private boolean adult;
    @SerializedName("imdb_id")
    @Expose
    @Transient
    private String imdb_id;
//    @SerializedName("homepage")
//    @Expose
//    private Object homepage;


    public Artist(){

    }


    protected Artist(Parcel in) {
        oBoxID = in.readLong();
        birthday = in.readString();
        deathday = in.readString();
        id = in.readLong();
        name = in.readString();
        known_for = in.createTypedArrayList(KnowFor.CREATOR);
        gender = in.readLong();
        biography = in.readString();
        popularity = in.readDouble();
        place_of_birth = in.readString();
        profile_path = in.readString();
        adult = in.readByte() != 0;
        imdb_id = in.readString();
    }

    public static final Creator<Artist> CREATOR = new Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDeathday() {
        return deathday;
    }

    public void setDeathday(String deathday) {
        this.deathday = deathday;
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

    public List<KnowFor> getKnown_for() {
        return known_for;
    }

    public void setKnown_for(List<KnowFor> known_for) {
        this.known_for = known_for;
    }

    public long getGender() {
        return gender;
    }

    public void setGender(long gender) {
        this.gender = gender;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
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
        parcel.writeString(birthday);
        parcel.writeString(deathday);
        parcel.writeLong(id);
        parcel.writeString(name);
        parcel.writeTypedList(known_for);
        parcel.writeLong(gender);
        parcel.writeString(biography);
        parcel.writeDouble(popularity);
        parcel.writeString(place_of_birth);
        parcel.writeString(profile_path);
        parcel.writeByte((byte) (adult ? 1 : 0));
        parcel.writeString(imdb_id);
    }
}

