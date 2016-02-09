package com.example.zervis.koijabo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.zervis.koijabo.adapters.FirstPageCafeAdapter;
import com.example.zervis.koijabo.adapters.FirstPageRestaurantAdapter;
import com.example.zervis.koijabo.adapters.ResultPageAdapter;
import com.example.zervis.koijabo.pojo.ResultModel;
import com.example.zervis.koijabo.restcall.APIInterface;
import com.example.zervis.koijabo.restcall.RestClient;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    RecyclerView mFirstPageRestaurantRecyclerView;
    RecyclerView.LayoutManager mFirstPageRestaurantRecyclerViewLayoutManager;
    RecyclerView.Adapter mfirstPageRestaurantAdapter;


    RecyclerView mFirstPageCafeRecyclerView;
    RecyclerView.LayoutManager mFirstPageCafeRecyclerViewLayoutManager;
    RecyclerView.Adapter mFirstPageCafeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        createFirstPageRestaurantRecyclerView();
        createFirstPageCafeRecyclerView();

    }

    private void createFirstPageRestaurantRecyclerView(){

        mFirstPageRestaurantRecyclerView = (RecyclerView) findViewById(R.id.first_page_restaurant_result_list);
        mFirstPageRestaurantRecyclerViewLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mFirstPageRestaurantRecyclerView.setLayoutManager(mFirstPageRestaurantRecyclerViewLayoutManager);
        APIInterface service = RestClient.getClient();
        Call<List<ResultModel>> call = service.getSearchResult("");
        call.enqueue(new Callback<List<ResultModel>>() {
            @Override
            public void onResponse(Response<List<ResultModel>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    mfirstPageRestaurantAdapter = new FirstPageRestaurantAdapter(MainActivity.this, response.body());
                    mFirstPageRestaurantRecyclerView.setAdapter(mfirstPageRestaurantAdapter);
                    Log.w("result cafe model", response.raw().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // show some sort of dialog or something
                Log.v("Failed cafe_model", "Failed");
            }
        });

    }

    private void createFirstPageCafeRecyclerView(){

        mFirstPageCafeRecyclerView = (RecyclerView) findViewById(R.id.first_page_cafe_result_list);
        mFirstPageCafeRecyclerViewLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mFirstPageCafeRecyclerView .setLayoutManager(mFirstPageCafeRecyclerViewLayoutManager);


        APIInterface service = RestClient.getClient();
        Call<List<ResultModel>> call = service.getSearchResult("");
        call.enqueue(new Callback<List<ResultModel>>() {
            @Override
            public void onResponse(Response<List<ResultModel>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    mFirstPageCafeAdapter = new FirstPageCafeAdapter(MainActivity.this, response.body());
                    mFirstPageCafeRecyclerView.setAdapter(mFirstPageCafeAdapter);
                    Log.w("result cafe model", response.raw().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // show some sort of dialog or something
                Log.v("Failed cafe_model", "Failed");
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void goToSearchPage(View view){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void listItemOnClick(View view){
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }
}
