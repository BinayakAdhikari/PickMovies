package com.rent.blaze.pickmovies.Objects;

import com.rent.blaze.pickmovies.rest.Model.Response.Results;

/**
 * Created by blaze on 6/21/16.
 */
public class MovieObjects {

    private String name;
    private int photo;
    private Results results;

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public MovieObjects(String name, int photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
