package com.rent.blaze.pickmovies;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Parcel;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rent.blaze.pickmovies.moviedetailfragments.MovieCastAndCrew;
import com.rent.blaze.pickmovies.moviedetailfragments.MovieMisc;
import com.rent.blaze.pickmovies.moviedetailfragments.MovieOverview;
import com.rent.blaze.pickmovies.rest.Model.Response.Pages;
import com.rent.blaze.pickmovies.rest.Model.Response.Results;

import org.w3c.dom.Text;

public class MovieDetails extends AppCompatActivity {
    FragmentPagerAdapter adapterViewPager;
    private TextView tvname, tvdescription;
    private ImageView specificMovieImage;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        specificMovieImage = (ImageView) findViewById(R.id.specificimage);
        tvname = (TextView) findViewById(R.id.movie_name);

        ViewPager vpPager = (ViewPager) findViewById(R.id.DetailViewer);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        Intent intent = getIntent();
        Results movieDetail = (Results) intent.getExtras().get("Movie_Detail");

        Glide.with(MovieDetails.this)
                .load("http://image.tmdb.org/t/p/w185//" + movieDetail.getPosterPath())
                .placeholder(R.drawable.loadingspinner)
                .into(specificMovieImage);
        tvname.setText(movieDetail.getOriginalTitle());


    }

    public static Intent getLaunchIntent(Context context, Results result) {
        Intent movieDetailActivityIntent = new Intent(context, MovieDetails.class);
        movieDetailActivityIntent.putExtra("Movie_Detail", result);
        return movieDetailActivityIntent;
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return MovieOverview.newInstance(0, "OVERVIEW");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return MovieOverview.newInstance(1, "INFO");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return MovieMisc.newInstance(2, "MISC");
                case 3:
                    return MovieCastAndCrew.newInstance(3, "CAST AND CREW");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0)
                return "OVERVIEW";
            else if (position == 1)
                return "INFO";
            else if (position == 2)
                return "MISC";
            else {
                return "";
            }
        }

    }

}

