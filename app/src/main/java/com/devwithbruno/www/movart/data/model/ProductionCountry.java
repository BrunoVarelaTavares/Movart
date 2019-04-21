package com.devwithbruno.www.movart.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bruno on 16/12/2017.
 */

public class ProductionCountry implements Parcelable {

    @SerializedName("iso_3166_1")
    @Expose
    private String iso_366_;
    @SerializedName("name")
    @Expose
    private String name;


    public ProductionCountry() {

    }




    public ProductionCountry(String iso_366_, String name) {
        this.iso_366_ = iso_366_;
        this.name = name;
    }

    protected ProductionCountry(Parcel in) {
        iso_366_ = in.readString();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(iso_366_);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProductionCountry> CREATOR = new Creator<ProductionCountry>() {
        @Override
        public ProductionCountry createFromParcel(Parcel in) {
            return new ProductionCountry(in);
        }

        @Override
        public ProductionCountry[] newArray(int size) {
            return new ProductionCountry[size];
        }
    };

    public String getIso_366_() {
        return iso_366_;
    }

    public void setIso_366_(String iso_366_) {
        this.iso_366_ = iso_366_;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "ProductionCountry{" +
                "iso_366_='" + iso_366_ + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
