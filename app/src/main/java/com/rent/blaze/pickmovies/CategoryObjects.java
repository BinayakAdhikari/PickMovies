package com.rent.blaze.pickmovies;

/**
 * Created by blaze on 6/28/16.
 */
public class CategoryObjects {
    private String categoryName;
    private int photo;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public CategoryObjects(String categoryName, int photo) {

        this.categoryName = categoryName;
        this.photo = photo;
    }
}
