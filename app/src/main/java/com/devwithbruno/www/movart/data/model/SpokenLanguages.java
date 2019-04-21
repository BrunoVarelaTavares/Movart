package com.devwithbruno.www.movart.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Transient;

/**
 * Created by Bruno on 16/12/2017.
 */

@Entity
public class SpokenLanguages implements Parcelable {

    @Id
    private long id;
    @SerializedName("iso_639_1")
    @Expose
    @Transient
    private String iso_639_;
    @SerializedName("name")
    @Expose
    private String name;


    protected SpokenLanguages(Parcel in) {
        id = in.readLong();
        iso_639_ = in.readString();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(iso_639_);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SpokenLanguages> CREATOR = new Creator<SpokenLanguages>() {
        @Override
        public SpokenLanguages createFromParcel(Parcel in) {
            return new SpokenLanguages(in);
        }

        @Override
        public SpokenLanguages[] newArray(int size) {
            return new SpokenLanguages[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIso_639_() {
        return iso_639_;
    }

    public void setIso_639_(String iso_639_) {
        this.iso_639_ = iso_639_;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
