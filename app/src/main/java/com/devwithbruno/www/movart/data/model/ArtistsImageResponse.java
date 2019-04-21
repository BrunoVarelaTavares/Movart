package com.devwithbruno.www.movart.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 18/12/2017.
 */

public class ArtistsImageResponse  implements Parcelable{

        @SerializedName("profiles")
        @Expose
        private List<Image> profiles = new ArrayList<>();
        @SerializedName("id")
        @Expose
        private long id;




    protected ArtistsImageResponse(Parcel in) {
        profiles = in.createTypedArrayList(Image.CREATOR);
        id = in.readLong();
    }

    public static final Creator<ArtistsImageResponse> CREATOR = new Creator<ArtistsImageResponse>() {
        @Override
        public ArtistsImageResponse createFromParcel(Parcel in) {
            return new ArtistsImageResponse(in);
        }

        @Override
        public ArtistsImageResponse[] newArray(int size) {
            return new ArtistsImageResponse[size];
        }
    };

    public List<Image> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Image> profiles) {
        this.profiles = profiles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(profiles);
        parcel.writeLong(id);
    }
}
