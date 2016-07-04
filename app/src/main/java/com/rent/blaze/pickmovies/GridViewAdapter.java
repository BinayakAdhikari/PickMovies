package com.rent.blaze.pickmovies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by blaze on 6/21/16.
 */
public class GridViewAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private List<MovieObjects> movieList;
    private Context context;

    public GridViewAdapter(Context context,List<MovieObjects> movieList) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_card,null);
        MovieViewHolder movieViewHolder = new MovieViewHolder(layoutView);
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.txtMovieName.setText(movieList.get(position).getName());
        holder.imgMovieCover.setImageResource(movieList.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
