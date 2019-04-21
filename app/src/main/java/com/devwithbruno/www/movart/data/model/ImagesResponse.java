package com.devwithbruno.www.movart.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Bruno on 10/12/2017.
 */

public class ImagesResponse implements Parcelable {
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("posters")
    @Expose
    private List<Image> posters;

    protected ImagesResponse(Parcel in) {
        id = in.readLong();
        posters = in.createTypedArrayList(Image.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeTypedList(posters);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ImagesResponse> CREATOR = new Creator<ImagesResponse>() {
        @Override
        public ImagesResponse createFromParcel(Parcel in) {
            return new ImagesResponse(in);
        }

        @Override
        public ImagesResponse[] newArray(int size) {
            return new ImagesResponse[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Image> getPosters() {
        return posters;
    }

    public void setPosters(List<Image> posters) {
        this.posters = posters;
    }
}
