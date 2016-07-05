package com.rent.blaze.pickmovies;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rent.blaze.pickmovies.rest.Model.Response.page;
import com.rent.blaze.pickmovies.rest.Model.Response.results;
import com.rent.blaze.pickmovies.rest.RetrofitManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RetrofitManager retrofitManager = null;

        retrofitManager = RetrofitManager.getInstance();
        retrofitManager.getMoviesInfo("upcoming", "9ee4b67c5f201aa49b4344bcd6d83ef3", new Callback<page>() {
            @Override
            public void onResponse(Call<page> call, Response<page> response) {
                if (response.code() == 200) {

                    page pages = response.body();

                    Log.i("size of arraylist", "onResponse: " + pages.getMovieResults().size());


                    for (results results : pages.getMovieResults()) {
                        Log.i("Sucess", "onResponse: " + results.getOriginalTitle());
                    }

                } else {
                    Log.i("tag", "onResponse: " + response.message());
                }

            }

            @Override
            public void onFailure(Call<page> call, Throwable t) {
                Log.i("Failure", "onFailure: " + t.getLocalizedMessage());

            }
        });

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

        List<MovieObjects> staggeredListContent = getMovieItem();

        GridViewAdapter gridViewAdapter = new GridViewAdapter(MainActivity.this, staggeredListContent);
        recyclerView.setAdapter(gridViewAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener()

                                            {
                                                @Override
                                                public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                                                    return false;
                                                }

                                                @Override
                                                public void onTouchEvent(RecyclerView rv, MotionEvent e) {

                                                }

                                                @Override
                                                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

                                                }
                                            }

        );

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

    private List<MovieObjects> getMovieItem() {
        List<MovieObjects> list = new ArrayList<>();
        list.add(new MovieObjects("one", R.drawable.one));
        list.add(new MovieObjects("one", R.drawable.two));
        list.add(new MovieObjects("one", R.drawable.three));
        list.add(new MovieObjects("one", R.drawable.four));
        list.add(new MovieObjects("one", R.drawable.one));
        list.add(new MovieObjects("one", R.drawable.five));
        list.add(new MovieObjects("one", R.drawable.six));
        list.add(new MovieObjects("one", R.drawable.seven));
        list.add(new MovieObjects("one", R.drawable.eight));
        list.add(new MovieObjects("one", R.drawable.nine));
        list.add(new MovieObjects("one", R.drawable.ten));
        list.add(new MovieObjects("one", R.drawable.eleven));
        list.add(new MovieObjects("one", R.drawable.twelve));
        list.add(new MovieObjects("one", R.drawable.thirdteen));
        list.add(new MovieObjects("one", R.drawable.fourteen));
        list.add(new MovieObjects("one", R.drawable.fivteen));
        list.add(new MovieObjects("one", R.drawable.sixtteen));
        list.add(new MovieObjects("one", R.drawable.seventeen));
        list.add(new MovieObjects("one", R.drawable.eighteen));
        list.add(new MovieObjects("one", R.drawable.ninteen));
        list.add(new MovieObjects("one", R.drawable.twenty));
        return (list);

    }

}
