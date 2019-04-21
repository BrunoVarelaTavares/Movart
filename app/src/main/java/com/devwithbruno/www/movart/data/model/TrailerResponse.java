package com.devwithbruno.www.movart.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Bruno on 06/07/2017.
 */

public class TrailerResponse implements Parcelable {

    @SerializedName("id")
    private int id_trailer;

    @SerializedName("results")
    private List<Trailer> result;


    protected TrailerResponse(Parcel in) {
        id_trailer = in.readInt();
        result = in.createTypedArrayList(Trailer.CREATOR);
    }

    public static final Creator<TrailerResponse> CREATOR = new Creator<TrailerResponse>() {
        @Override
        public TrailerResponse createFromParcel(Parcel in) {
            return new TrailerResponse(in);
        }

        @Override
        public TrailerResponse[] newArray(int size) {
            return new TrailerResponse[size];
        }
    };

    public int getIdTrailer() {
        return id_trailer;
    }

    public void setIdTrailer(int id_trailer) {
        this.id_trailer = id_trailer;
    }


    public List<Trailer> getResult() {
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id_trailer);
        parcel.writeTypedList(result);
    }
}
