package com.devwithbruno.www.movart.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bruno on 08/12/2017.
 */


public class Cast  implements Parcelable{

    @SerializedName("cast_id")
    @Expose
    private long cast_id;
    @SerializedName("character")
    @Expose
    private String character;
    @SerializedName("credit_id")
    @Expose
    private String credit_id;
    @SerializedName("gender")
    @Expose
    private long gender;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("order")
    @Expose
    private long order;
    @SerializedName("profile_path")
    @Expose
    private String profile_path;


    public Cast(){

    }





    protected Cast(Parcel in) {
        cast_id = in.readLong();
        character = in.readString();
        credit_id = in.readString();
        gender = in.readLong();
        id = in.readLong();
        name = in.readString();
        order = in.readLong();
        profile_path = in.readString();
    }

    public static final Creator<Cast> CREATOR = new Creator<Cast>() {
        @Override
        public Cast createFromParcel(Parcel in) {
            return new Cast(in);
        }

        @Override
        public Cast[] newArray(int size) {
            return new Cast[size];
        }
    };

    public long getCast_id() {
        return cast_id;
    }

    public void setCast_id(long cast_id) {
        this.cast_id = cast_id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public long getGender() {
        return gender;
    }

    public void setGender(long gender) {
        this.gender = gender;
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

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "cast_id=" + cast_id +
                ", character='" + character + '\'' +
                ", credit_id='" + credit_id + '\'' +
                ", gender=" + gender +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", profile_path='" + profile_path + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(cast_id);
        parcel.writeString(character);
        parcel.writeString(credit_id);
        parcel.writeLong(gender);
        parcel.writeLong(id);
        parcel.writeString(name);
        parcel.writeLong(order);
        parcel.writeString(profile_path);
    }
}
