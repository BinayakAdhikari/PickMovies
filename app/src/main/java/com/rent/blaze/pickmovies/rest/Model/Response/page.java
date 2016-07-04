package com.rent.blaze.pickmovies.rest.Model.Response;

import java.util.ArrayList;

/**
 * Created by blaze on 7/4/16.
 */
public class page {
    private int page;
    private ArrayList<results> movieResults = new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<results> getMovieResults() {
        return movieResults;
    }

    public void setMovieResults(ArrayList<results> movieResults) {
        this.movieResults = movieResults;
    }
}
