package com.rent.blaze.pickmovies.rest;

import com.rent.blaze.pickmovies.BuildConfig;
import com.rent.blaze.pickmovies.MovieService;
import com.rent.blaze.pickmovies.rest.Model.Response.Pages;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by blaze on 6/20/16.
 */
public class RetrofitManager {
    public static Retrofit retrofit = null;
    public static MovieService movieService = null;
    public static RetrofitManager retrofitManager = null;

    private RetrofitManager() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.MOVIE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        movieService = retrofit.create(MovieService.class);


    }

    public static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            retrofitManager = new RetrofitManager();
        }

        return retrofitManager;

    }

    public void getMoviesInfo(String movie_id, String apikey, Callback<Pages> callback) {
        Call<Pages> pageCall = movieService.getMoviesInfo(movie_id, apikey);
        pageCall.enqueue(callback);
    }
}
