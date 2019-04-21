package com.devwithbruno.www.movart.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 28/12/2017.
 */

public class TvResponse implements Parcelable {

    @SerializedName("page")
    @Expose
    private long page;
    @SerializedName("results")
    @Expose
    private List<Tv> results = new ArrayList<>();
    @SerializedName("total_pages")
    @Expose
    private long total_pages;
    @SerializedName("total_results")
    @Expose
    private long total_results;

    protected TvResponse(Parcel in) {
        page = in.readLong();
        results = in.createTypedArrayList(Tv.CREATOR);
        total_pages = in.readLong();
        total_results = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(page);
        dest.writeTypedList(results);
        dest.writeLong(total_pages);
        dest.writeLong(total_results);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TvResponse> CREATOR = new Creator<TvResponse>() {
        @Override
        public TvResponse createFromParcel(Parcel in) {
            return new TvResponse(in);
        }

        @Override
        public TvResponse[] newArray(int size) {
            return new TvResponse[size];
        }
    };

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public List<Tv> getResults() {
        return results;
    }

    public void setResults(List<Tv> results) {
        this.results = results;
    }

    public long getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(long total_pages) {
        this.total_pages = total_pages;
    }

    public long getTotal_results() {
        return total_results;
    }

    public void setTotal_results(long total_results) {
        this.total_results = total_results;
    }

    @Override
    public String toString() {
        return "TvResponse{" +
                "page=" + page +
                ", results=" + results +
                ", total_pages=" + total_pages +
                ", total_results=" + total_results +
                '}';
    }
}
