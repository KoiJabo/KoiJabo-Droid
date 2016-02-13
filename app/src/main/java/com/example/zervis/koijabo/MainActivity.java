package com.example.zervis.koijabo;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.provider.Settings;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zervis.koijabo.adapters.FirstPageCafeAdapter;
import com.example.zervis.koijabo.adapters.FirstPageRestaurantAdapter;
import com.example.zervis.koijabo.fragments.LocationDialogFragment;
import com.example.zervis.koijabo.lib.LocationDetector;
import com.example.zervis.koijabo.pojo.ResultModel;
import com.example.zervis.koijabo.pojo.SearchResult;
import com.example.zervis.koijabo.restcall.APIInterface;
import com.example.zervis.koijabo.restcall.RestClient;

import org.w3c.dom.Text;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LocationDetector locationDetector;
    Thread mThread;
    private android.os.Handler handler;
    public Location mCurrentLocation;
    private boolean first = true;
    public static double lat = 0;
    public static double lon = 0;

    DialogFragment locationdialog;
    boolean locationDetected;
    //LoginFragment loginFragment;

    Context mContext;
    RecyclerView mFirstPageRestaurantRecyclerView;
    RecyclerView.LayoutManager mFirstPageRestaurantRecyclerViewLayoutManager;
    RecyclerView.Adapter mfirstPageRestaurantAdapter;


    RecyclerView mFirstPageCafeRecyclerView;
    RecyclerView.LayoutManager mFirstPageCafeRecyclerViewLayoutManager;
    RecyclerView.Adapter mFirstPageCafeAdapter;
    boolean run = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationDetector = new LocationDetector(this);
        handler = new android.os.Handler();
        if (!isLocationSettingsOn()) {
            locationdialog = new LocationDialogFragment();
            locationdialog.show(getFragmentManager(), "Opening Location asking locationdialog");
        }
        else detectCurrentLocation();

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
    }

    private void detectCurrentLocation(){
        // Thread for current location updates
        mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (run) {

                    if (locationDetector.location != null) {
                        handler.post(new Runnable() {
                            public void run() {
                                // Updates the current location
                                mCurrentLocation = locationDetector.location;
                                if (first) {
                                    //getlocation
                                    lat = mCurrentLocation.getLatitude();
                                    lon = mCurrentLocation.getLongitude();
                                    first = false;
                                    Log.v("lat : ", String.valueOf(lat));
                                    Log.v("lon : ", String.valueOf(lon));
                                    createFirstPageRestaurantRecyclerView();
                                    createFirstPageCafeRecyclerView();
                                }
                            }
                        });
                    }
                    synchronized (this) {
                        try {
                            wait(1000);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        });

        mThread.start();
    }

    private boolean isLocationSettingsOn() {
        LinearLayout locationNotDetectedText = (LinearLayout) findViewById(R.id.location_not_detected_text);
        String gpsProvider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
        if (gpsProvider.equals("")) {
            locationNotDetectedText.setVisibility(View.VISIBLE);
            return false;
        } else {
            locationNotDetectedText.setVisibility(View.GONE);
            return true;
        }
    }

    public void openLocationSettings(View view) {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        locationdialog.dismiss();
        TextView textView = (TextView) findViewById(R.id.location_not_turn_on);
        textView.setText("If you have turned on the location already, kindly restart the app now :)");
        startActivity(intent);
        if (isLocationSettingsOn())
            detectCurrentLocation();
    }
    public void close_Location_dialog(View view){
        locationdialog.dismiss();
    }

    private void createFirstPageRestaurantRecyclerView(){

        mFirstPageRestaurantRecyclerView = (RecyclerView) findViewById(R.id.first_page_restaurant_result_list);
        mFirstPageRestaurantRecyclerViewLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mFirstPageRestaurantRecyclerView.setLayoutManager(mFirstPageRestaurantRecyclerViewLayoutManager);
        APIInterface service = RestClient.getClient();
        Call<SearchResult> call = service.getSearchResult("restaurant", lat, lon);
        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Response<SearchResult> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    List<ResultModel> models = response.body().getData();
                    mfirstPageRestaurantAdapter = new FirstPageRestaurantAdapter(MainActivity.this, models, lat, lon);
                    mFirstPageRestaurantRecyclerView.setAdapter(mfirstPageRestaurantAdapter);
                    Log.v("result cafe model", response.raw().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // show some sort of locationdialog or something
                createFirstPageRestaurantRecyclerView();
                Log.v("Failed restaurant_model", "Failed");
            }
        });

    }

    private void createFirstPageCafeRecyclerView(){

        mFirstPageCafeRecyclerView = (RecyclerView) findViewById(R.id.first_page_cafe_result_list);
        mFirstPageCafeRecyclerViewLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mFirstPageCafeRecyclerView .setLayoutManager(mFirstPageCafeRecyclerViewLayoutManager);


        APIInterface service = RestClient.getClient();
        Call<SearchResult> call = service.getSearchResult("cafe", lat, lon);
        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Response<SearchResult> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    List<ResultModel> models = response.body().getData();
                    mFirstPageCafeAdapter = new FirstPageCafeAdapter(MainActivity.this, models, lat, lon);
                    mFirstPageCafeRecyclerView.setAdapter(mFirstPageCafeAdapter);
                    Log.v("result cafe model", response.raw().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // show some sort of locationdialog or something
                createFirstPageCafeRecyclerView();
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
        intent.putExtra("lat", lat);
        intent.putExtra("lon", lon);

        startActivity(intent);
    }

}
