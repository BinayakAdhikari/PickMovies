package com.rent.blaze.pickmovies;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by blaze on 6/21/16.
 */
public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView imgMovieCover;
    public TextView txtMovieName;

    public MovieViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        imgMovieCover = (ImageView) itemView.findViewById(R.id.moviecover);
        txtMovieName = (TextView) itemView.findViewById(R.id.moviename);
        txtMovieName.getText().toString();
    }

    @Override
    public void onClick(View v) {

        Intent showDetails = new Intent(v.getContext(),MovieDetails.class);
        v.getContext().startActivity(showDetails);
    }
}
