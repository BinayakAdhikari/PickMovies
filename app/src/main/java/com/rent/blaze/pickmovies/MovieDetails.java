package com.rent.blaze.pickmovies;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.rent.blaze.pickmovies.rest.Model.Response.Pages;
import com.rent.blaze.pickmovies.rest.Model.Response.Results;

import org.w3c.dom.Text;

public class MovieDetails extends AppCompatActivity {
    private TextView tvname,tvdescription;
    private ImageView specificMovieImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        Intent intent = getIntent();
        Results movieDetail = (Results) intent.getExtras().get("Movie_Detail");

    }
}
