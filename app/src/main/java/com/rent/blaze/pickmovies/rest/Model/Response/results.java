package com.rent.blaze.pickmovies.rest.Model.Response;

import java.util.ArrayList;

/**
 * Created by blaze on 6/28/16.
 */
public class results {

    private int posterPath;
    private String adult;
    private String overview;
    private int releaseDate;
    private int id;
    private String originalTitle;
    private String originalLanguage;
    private String title;
    private int backdropPath;
    private int popularity;
    private int voteCount;
    private String video;
    private int voteAverage;


    public int getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(int posterPath) {
        this.posterPath = posterPath;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(int backdropPath) {
        this.backdropPath = backdropPath;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(int voteAverage) {
        this.voteAverage = voteAverage;
    }

    private ArrayList<genreId> genreIds = new ArrayList<genreId>();

    public ArrayList<genreId> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(ArrayList<genreId> genreIds) {
        this.genreIds = genreIds;
    }

    public ArrayList<dates> getDates() {
        return dates;
    }

    public void setDates(ArrayList<dates> dates) {
        this.dates = dates;
    }

    private ArrayList<dates> dates = new ArrayList<dates>();
}
