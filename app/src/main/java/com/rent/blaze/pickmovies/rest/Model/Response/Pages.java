package com.rent.blaze.pickmovies.rest.Model.Response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pages implements Parcelable{

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    private ArrayList<Results> results = new ArrayList<Results>();

    protected Pages(Parcel in) {
        results = in.createTypedArrayList(Results.CREATOR);
    }

    public static final Creator<Pages> CREATOR = new Creator<Pages>() {
        @Override
        public Pages createFromParcel(Parcel in) {
            return new Pages(in);
        }

        @Override
        public Pages[] newArray(int size) {
            return new Pages[size];
        }
    };

    /**
     *
     * @return
     * The page
     */
    public Integer getPage() {
        return page;
    }

    /**
     *
     * @param page
     * The page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     *
     * @return
     * The Results
     */
    public ArrayList<Results> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The Results
     */
    public void setResults(ArrayList<Results> results) {
        this.results = results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(results);
    }
}
