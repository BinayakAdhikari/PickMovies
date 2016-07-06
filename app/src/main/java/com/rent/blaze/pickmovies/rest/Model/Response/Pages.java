package com.rent.blaze.pickmovies.rest.Model.Response;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pages {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    private List<Results> results = new ArrayList<Results>();

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
    public List<Results> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The Results
     */
    public void setResults(List<Results> results) {
        this.results = results;
    }

}
