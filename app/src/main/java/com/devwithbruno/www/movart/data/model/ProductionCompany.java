package com.devwithbruno.www.movart.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bruno on 16/12/2017.
 */

public class ProductionCompany {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
