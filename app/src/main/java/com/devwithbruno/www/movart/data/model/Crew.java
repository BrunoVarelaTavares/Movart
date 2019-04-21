package com.devwithbruno.www.movart.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bruno on 08/12/2017.
 */

public class Crew implements Parcelable  {

    @SerializedName("credit_id")
    @Expose
    private String credit_id;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("gender")
    @Expose
    private long gender;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("job")
    @Expose
    private String job;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profile_path")
    @Expose
    private String profile_path;


    public Crew(){

    }

    protected Crew(Parcel in) {
        credit_id = in.readString();
        department = in.readString();
        gender = in.readLong();
        id = in.readLong();
        job = in.readString();
        name = in.readString();
        profile_path = in.readString();
    }

    public static final Creator<Crew> CREATOR = new Creator<Crew>() {
        @Override
        public Crew createFromParcel(Parcel in) {
            return new Crew(in);
        }

        @Override
        public Crew[] newArray(int size) {
            return new Crew[size];
        }
    };

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getGender() {
        return gender;
    }

    public void setGender(long gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(credit_id);
        parcel.writeString(department);
        parcel.writeLong(gender);
        parcel.writeLong(id);
        parcel.writeString(job);
        parcel.writeString(name);
        parcel.writeString(profile_path);
    }

    @Override
    public String toString() {
        return "Crew{" +
                "credit_id='" + credit_id + '\'' +
                ", department='" + department + '\'' +
                ", gender=" + gender +
                ", id=" + id +
                ", job='" + job + '\'' +
                ", name='" + name + '\'' +
                ", profile_path='" + profile_path + '\'' +
                '}';
    }
}
