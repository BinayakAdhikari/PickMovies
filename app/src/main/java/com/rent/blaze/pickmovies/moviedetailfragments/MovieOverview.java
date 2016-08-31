package com.rent.blaze.pickmovies.moviedetailfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rent.blaze.pickmovies.R;

/**
 * Created by blaze on 6/27/16.
 */
public class MovieOverview extends Fragment {
    private int page;
    private String title;


    public static MovieOverview newInstance(int page, String title) {
        MovieOverview movieOverview = new MovieOverview();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        movieOverview.setArguments(args);
        return movieOverview;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.txtoverview);
        tvLabel.setText("OVERVIEW");
        return view;
    }
}
