package com.devwithbruno.www.movart.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 08/12/2017.
 */

public class CreditsResponse implements Parcelable {
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("cast")
    @Expose
    private List<Cast> cast = new ArrayList<>();
    @SerializedName("crew")
    @Expose
    private List<Crew> crew = new ArrayList<>();

    protected CreditsResponse(Parcel in) {
        id = in.readLong();
        cast = in.createTypedArrayList(Cast.CREATOR);
    }

    public static final Creator<CreditsResponse> CREATOR = new Creator<CreditsResponse>() {
        @Override
        public CreditsResponse createFromParcel(Parcel in) {
            return new CreditsResponse(in);
        }

        @Override
        public CreditsResponse[] newArray(int size) {
            return new CreditsResponse[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public List<Crew> getCrew() {
        return crew;
    }

    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }


    @Override
    public String toString() {
        return "CreditsResponse{" +
                "id=" + id +
                ", cast=" + cast +
                ", crew=" + crew +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeTypedList(cast);
    }
}
