package com.rent.blaze.pickmovies.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.rent.blaze.pickmovies.ViewHolders.MovieViewHolder;
import com.rent.blaze.pickmovies.R;
import com.rent.blaze.pickmovies.rest.Model.Response.Results;

import java.util.ArrayList;

/**
 * Created by blaze on 6/21/16.
 */
public class GridViewAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private ArrayList<Results> movieList;
    private Context context;
    private MovieItemClickListener movieItemClickListener;


    public GridViewAdapter(Context context, ArrayList<Results> movieList) {
        this.movieList = movieList;
        this.context = context;
    }

    public void setClickListener(MovieItemClickListener movieItemClickListener) {
        this.movieItemClickListener = movieItemClickListener;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_card, null);
        MovieViewHolder movieViewHolder = new MovieViewHolder(layoutView);
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.txtMovieName.setText(movieList.get(position).getOriginalTitle());
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w185//" + movieList.get(position).getPosterPath())
                .placeholder(R.drawable.loadingspinner)
                .error(R.drawable.two)
                .into(holder.imgMovieCover);
        holder.rlMovieContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (movieItemClickListener != null) {
                    movieItemClickListener.onClick(movieList.get(position));
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public interface MovieItemClickListener {
        void onClick(Results result);
    }

}
