package com.rent.blaze.pickmovies;

/**
 * Created by blaze on 6/21/16.
 */
public class MovieObjects {

    private String name;
    private int photo;

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
