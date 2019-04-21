package com.devwithbruno.www.movart.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 25/12/2017.
 */

public class ArtistCastResponse {

    @SerializedName("cast")
    @Expose
    private List<ArtistCast> cast = new ArrayList<>();
    @SerializedName("crew")
    @Expose
    private List<Crew> crew = new ArrayList<>();
    @SerializedName("id")
    @Expose
    private long id;


    public List<ArtistCast> getCast() {
        return cast;
    }

    public void setCast(List<ArtistCast> cast) {
        this.cast = cast;
    }

    public List<Crew> getCrew() {
        return crew;
    }

    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ArtistCastResponse{" +
                "cast=" + cast +
                ", crew=" + crew +
                ", id=" + id +
                '}';
    }
}
