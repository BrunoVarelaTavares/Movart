package com.devwithbruno.www.movart.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bruno on 06/07/2017.
 */

public class Trailer implements Parcelable {

    @SerializedName("key")
    private String key;
    @SerializedName("name")
    private String name;


    public Trailer(String key, String name) {
        this.key = key;
        this.name = name;
    }

    protected Trailer(Parcel in) {
        key = in.readString();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(key);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Trailer> CREATOR = new Creator<Trailer>() {
        @Override
        public Trailer createFromParcel(Parcel in) {
            return new Trailer(in);
        }

        @Override
        public Trailer[] newArray(int size) {
            return new Trailer[size];
        }
    };

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Trailer{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
