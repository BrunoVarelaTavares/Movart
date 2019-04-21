package com.devwithbruno.www.movart.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bruno on 10/12/2017.
 */

public class Poster {

    @SerializedName("aspect_ratio")
    @Expose
    private double aspect_ratio;
    @SerializedName("file_path")
    @Expose
    private String file_path;
    @SerializedName("height")
    @Expose
    private long height;
    @SerializedName("width")
    @Expose
    private long width;

    public double getAspect_ratio() {
        return aspect_ratio;
    }

    public void setAspect_ratio(double aspect_ratio) {
        this.aspect_ratio = aspect_ratio;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }


    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }


}
