package com.rent.blaze.pickmovies;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rent.blaze.pickmovies.rest.Model.Response.Results;

/**
 * Created by blaze on 6/21/16.
 */
public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView imgMovieCover;
    public TextView txtMovieName,tvmovieReleaseDate;
    Results movieDetails;

    public MovieViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        imgMovieCover = (ImageView) itemView.findViewById(R.id.moviecover);
        txtMovieName = (TextView) itemView.findViewById(R.id.moviename);
        movieDetails = (Results) txtMovieName.getTag();

    }

    @Override
    public void onClick(View v) {

        Intent showDetails = new Intent(v.getContext(),MovieDetails.class);
        showDetails.putExtra("MOVIE_DETAILS",movieDetails);
        v.getContext().startActivity(showDetails);
    }
}
