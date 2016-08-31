package com.rent.blaze.pickmovies.MoviesActivities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.rent.blaze.pickmovies.MovieDetails;
import com.rent.blaze.pickmovies.R;
import com.rent.blaze.pickmovies.Adapters.GridViewAdapter;
import com.rent.blaze.pickmovies.rest.Model.Response.Pages;
import com.rent.blaze.pickmovies.rest.Model.Response.Results;
import com.rent.blaze.pickmovies.rest.Service.RetrofitManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by blaze on 8/30/16.
 */
public class PopularMovies extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private GridViewAdapter gridViewAdapter;
    private ArrayList<Results> Popular = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        recyclerView = (RecyclerView)

                findViewById(R.id.moviescontainer);

        recyclerView.setHasFixedSize(true);

        linearLayoutManager = new

                LinearLayoutManager(this);

        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);


        gridLayoutManager = new

                GridLayoutManager(this, 3);

        recyclerView.setLayoutManager(gridLayoutManager);


        getMovieList();

        gridViewAdapter = new GridViewAdapter(PopularMovies.this, Popular);
        recyclerView.setAdapter(gridViewAdapter);

    }

    private void getMovieList() {
        RetrofitManager retrofitManager = null;
        retrofitManager = RetrofitManager.getInstance();
        retrofitManager.getMoviesInfo("popular", "9ee4b67c5f201aa49b4344bcd6d83ef3", new Callback<Pages>() {
            @Override
            public void onResponse(Call<Pages> call, Response<Pages> response) {
                if (response.code() == 200) {

                    Popular.addAll(response.body().getResults());
                    gridViewAdapter.notifyDataSetChanged();
                    gridViewAdapter.setClickListener(new GridViewAdapter.MovieItemClickListener() {
                        @Override
                        public void onClick(Results result) {
                            startActivity(MovieDetails.getLaunchIntent(PopularMovies.this, result));
                        }
                    });
                }

            }

            @Override
            public void onFailure(Call<Pages> call, Throwable t) {
                Log.i("Failure", "onFailure: " + t.getLocalizedMessage());

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.on_the_pick, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.categories) {
            // Handle the categories
        } else if (id == R.id.search) {

        } else if (id == R.id.settings) {

        } else if (id == R.id.mymovies) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.exit) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

