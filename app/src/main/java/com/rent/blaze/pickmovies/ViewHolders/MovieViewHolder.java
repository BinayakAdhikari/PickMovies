package com.rent.blaze.pickmovies.ViewHolders;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rent.blaze.pickmovies.R;
import com.rent.blaze.pickmovies.rest.Model.Response.Results;

/**
 * Created by blaze on 6/21/16.
 */
public class MovieViewHolder extends RecyclerView.ViewHolder {
    public ImageView imgMovieCover;
    public TextView txtMovieName,tvmovieReleaseDate;
    public RelativeLayout rlMovieContainer;



    public MovieViewHolder(View itemView) {
        super(itemView);
        imgMovieCover = (ImageView) itemView.findViewById(R.id.moviecover);
        txtMovieName = (TextView) itemView.findViewById(R.id.moviename);
        rlMovieContainer = (RelativeLayout) itemView.findViewById(R.id.rlmoviescontainer);

    }

}
