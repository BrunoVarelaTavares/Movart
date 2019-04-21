package com.devwithbruno.www.movart.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 25/12/2017.
 */

public class TaggedImagesResponse implements Parcelable {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("page")
    @Expose
    private long page;
    @SerializedName("total_results")
    @Expose
    private long total_results;
    @SerializedName("results")
    @Expose
    private List<Image> results = new ArrayList<>();
    @SerializedName("total_pages")
    @Expose
    private long total_pages;

    public TaggedImagesResponse(){

    }

    public TaggedImagesResponse(long id, long page, long total_results, List<Image> results, long total_pages) {
        this.id = id;
        this.page = page;
        this.total_results = total_results;
        this.results = results;
        this.total_pages = total_pages;
    }

    protected TaggedImagesResponse(Parcel in) {
        id = in.readLong();
        page = in.readLong();
        total_results = in.readLong();
        results = in.createTypedArrayList(Image.CREATOR);
        total_pages = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(page);
        dest.writeLong(total_results);
        dest.writeTypedList(results);
        dest.writeLong(total_pages);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TaggedImagesResponse> CREATOR = new Creator<TaggedImagesResponse>() {
        @Override
        public TaggedImagesResponse createFromParcel(Parcel in) {
            return new TaggedImagesResponse(in);
        }

        @Override
        public TaggedImagesResponse[] newArray(int size) {
            return new TaggedImagesResponse[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getTotal_results() {
        return total_results;
    }

    public void setTotal_results(long total_results) {
        this.total_results = total_results;
    }

    public List<Image> getResults() {
        return results;
    }

    public void setResults(List<Image> results) {
        this.results = results;
    }

    public long getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(long total_pages) {
        this.total_pages = total_pages;
    }
}
