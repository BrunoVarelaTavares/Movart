package com.devwithbruno.www.movart.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 14/12/2017.
 */

public class ReviewsResponse {
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("page")
    @Expose
    private long page;
    @SerializedName("results")
    @Expose
    private List<Review> results = new ArrayList<>();
    @SerializedName("total_pages")
    @Expose
    private long total_pages;
    @SerializedName("total_results")
    @Expose
    private long total_results;

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

    public List<Review> getResults() {
        return results;
    }

    public void setResults(List<Review> results) {
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
        return "ReviewsResponse{" +
                "id=" + id +
                ", page=" + page +
                ", results=" + results +
                ", total_pages=" + total_pages +
                ", total_results=" + total_results +
                '}';
    }
}
