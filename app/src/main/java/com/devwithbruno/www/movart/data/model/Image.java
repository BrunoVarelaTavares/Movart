package com.devwithbruno.www.movart.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bruno on 10/12/2017.
 */

public class Image implements Parcelable{


    @SerializedName("iso_639_1")
    @Expose
    private String iso_639_;
    @SerializedName("vote_count")
    @Expose
    private long vote_count;
    @SerializedName("media_type")
    @Expose
    private String media_type;
    @SerializedName("file_path")
    @Expose
    private String file_path;
    @SerializedName("aspect_ratio")
    @Expose
    private double aspect_ratio;
    @SerializedName("media")
    @Expose
    private Media media;
    @SerializedName("height")
    @Expose
    private long height;
    @SerializedName("vote_average")
    @Expose
    private double vote_average;
    @SerializedName("width")
    @Expose
    private long width;



    public Image(){

    }


    public Image(String iso_639_, long vote_count, String media_type, String file_path, double aspect_ratio, Media media, long height, double vote_average, long width) {
        this.iso_639_ = iso_639_;
        this.vote_count = vote_count;
        this.media_type = media_type;
        this.file_path = file_path;
        this.aspect_ratio = aspect_ratio;
        this.media = media;
        this.height = height;
        this.vote_average = vote_average;
        this.width = width;
    }

    protected Image(Parcel in) {
        iso_639_ = in.readString();
        vote_count = in.readLong();
        media_type = in.readString();
        file_path = in.readString();
        aspect_ratio = in.readDouble();
        media = in.readParcelable(Media.class.getClassLoader());
        height = in.readLong();
        vote_average = in.readDouble();
        width = in.readLong();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public String getIso_639_() {
        return iso_639_;
    }

    public void setIso_639_(String iso_639_) {
        this.iso_639_ = iso_639_;
    }

    public long getVote_count() {
        return vote_count;
    }

    public void setVote_count(long vote_count) {
        this.vote_count = vote_count;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public double getAspect_ratio() {
        return aspect_ratio;
    }

    public void setAspect_ratio(double aspect_ratio) {
        this.aspect_ratio = aspect_ratio;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(iso_639_);
        parcel.writeLong(vote_count);
        parcel.writeString(media_type);
        parcel.writeString(file_path);
        parcel.writeDouble(aspect_ratio);
        parcel.writeParcelable(media, i);
        parcel.writeLong(height);
        parcel.writeDouble(vote_average);
        parcel.writeLong(width);
    }
}
