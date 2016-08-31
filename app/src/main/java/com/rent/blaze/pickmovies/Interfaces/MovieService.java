package com.rent.blaze.pickmovies.Interfaces;

import com.rent.blaze.pickmovies.rest.Model.Response.Pages;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by blaze on 6/20/16.
 */
public interface MovieService {

    @GET("3/movie/{movie_id}")
    Call<Pages> getMoviesInfo(@Path("movie_id") String movie_id, @Query("api_key") String apiKey);

}
