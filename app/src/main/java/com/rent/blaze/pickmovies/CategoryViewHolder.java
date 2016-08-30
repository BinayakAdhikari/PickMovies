package com.rent.blaze.pickmovies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by blaze on 6/28/16.
 */
public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView imgCategoryCover;
    private final Context context;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        imgCategoryCover = (ImageView) itemView.findViewById(R.id.categorycover);
        context = null;
    }

    @Override
    public void onClick(View v) {
        final Intent intent;
        if (getAdapterPosition() == 0) {
            intent = new Intent(v.getContext(), NowPlayingMovies.class);
        } else if (getAdapterPosition() == 1) {
            intent = new Intent(v.getContext(), TopRated.class);
        } else if (getAdapterPosition() == 2) {
            intent = new Intent(v.getContext(), PopularMovies.class);
        } else {
            intent = new Intent(v.getContext(), MainActivity.class);
        }
        v.getContext().startActivity(intent);

    }
}
