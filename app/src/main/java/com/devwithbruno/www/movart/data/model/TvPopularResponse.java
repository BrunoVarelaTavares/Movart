package com.devwithbruno.www.movart.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Bruno on 03/12/2017.
 */

public class TvPopularResponse implements Parcelable {
    @SerializedName("page")
    private long page;

    @SerializedName("total_results")
    private long totalResults;

    @SerializedName("total_pages")
    private long totalPages;

    @SerializedName("results")
    private List<TvPopular> results;

    protected TvPopularResponse(Parcel in) {
        page = in.readLong();
        totalResults = in.readLong();
        totalPages = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(page);
        dest.writeLong(totalResults);
        dest.writeLong(totalPages);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TvPopularResponse> CREATOR = new Creator<TvPopularResponse>() {
        @Override
        public TvPopularResponse createFromParcel(Parcel in) {
            return new TvPopularResponse(in);
        }

        @Override
        public TvPopularResponse[] newArray(int size) {
            return new TvPopularResponse[size];
        }
    };

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public List<TvPopular> getResults() {
        return results;
    }

    public void setResults(List<TvPopular> results) {
        this.results = results;
    }
}
