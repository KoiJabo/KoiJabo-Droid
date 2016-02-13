package com.example.zervis.koijabo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.zervis.koijabo.lib.SeekbarUtility;
import com.example.zervis.koijabo.pojo.ReviewSubmit;
import com.example.zervis.koijabo.pojo.SearchResult;
import com.example.zervis.koijabo.restcall.APIInterface;
import com.example.zervis.koijabo.restcall.RestClient;
import com.google.gson.Gson;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class AddReviewActivity extends Activity {

    SeekBar foodSeekbar = null;
    SeekBar serviceSeekbar = null;
    SeekBar ambienceSeekbar = null;
    SeekBar cleanlinessSeekbar = null;
    SeekBar generalSeekbar = null;

    TextView foodSeekbarValue = null;
    TextView serviceSeekbarValue = null;
    TextView ambienceSeekbarValue = null;
    TextView cleanlinessSeekbarValue = null;
    TextView generalSeekbarValue = null;
    TextView textReview = null;

    int foodRating = 0;
    int serviceRating = 0;
    int ambienceRating = 0;
    int cleanlinessRating = 0;
    int generalRating = 0;

    ReviewSubmit reviewSubmit;

    public void initializeVariables(){
        foodSeekbar = (SeekBar) findViewById(R.id.food_seekBar);
        serviceSeekbar = (SeekBar) findViewById(R.id.service_seekBar);
        ambienceSeekbar = (SeekBar) findViewById(R.id.ambience_seekBar);
        cleanlinessSeekbar = (SeekBar) findViewById(R.id.cleanliness_seekBar);
        generalSeekbar = (SeekBar) findViewById(R.id.generalRating_seekBar);

        foodSeekbarValue = (TextView) findViewById(R.id.food_seekBar_value);
        serviceSeekbarValue = (TextView) findViewById(R.id.service_seekBar_value);
        ambienceSeekbarValue = (TextView) findViewById(R.id.ambience_seekBar_value);
        cleanlinessSeekbarValue = (TextView) findViewById(R.id.cleanliness_seekBar_value);
        generalSeekbarValue = (TextView) findViewById(R.id.generalRating_seekBar_value);
        textReview = (TextView) findViewById(R.id.text_review);

        reviewSubmit = new ReviewSubmit();

        reviewSubmit.setFoodRating(0);
        reviewSubmit.setAmbienceRating(0);
        reviewSubmit.setServiceRating(0);
        reviewSubmit.setCleanlinesRating(0);
        reviewSubmit.setOverAllRating(0);
        reviewSubmit.setTextReview("");
        reviewSubmit.setTips("");
        reviewSubmit.setVerified(false);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);
        initializeVariables();
        Intent intent = getIntent();
        String restaurantId =  intent.getExtras().getString("id");
        reviewSubmit.setRestaurantId(restaurantId);
        reviewSubmit.setUserId("Tareq");

        foodSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                foodRating = progress;
                String foodRatingValue = SeekbarUtility.foodSeekbarValue(foodRating);
                foodSeekbarValue.setText(foodRatingValue);
                reviewSubmit.setFoodRating(foodRating);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        foodSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                foodRating = progress;
                String foodRatingValue = SeekbarUtility.foodSeekbarValue(foodRating);
                foodSeekbarValue.setText(foodRatingValue);
                reviewSubmit.setFoodRating(foodRating);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        serviceSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                serviceRating = progress;
                String serviceRatingValue = SeekbarUtility.serviceSeekbarValue(serviceRating);
                serviceSeekbarValue.setText(serviceRatingValue);
                reviewSubmit.setServiceRating(serviceRating);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ambienceSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ambienceRating = progress;
                String ambienceRatingValue = SeekbarUtility.ambienceSeekbarValue(ambienceRating);
                ambienceSeekbarValue.setText(ambienceRatingValue);
                reviewSubmit.setAmbienceRating(ambienceRating);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        cleanlinessSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cleanlinessRating = progress;
                String cleanlinessRatingValue = SeekbarUtility.cleanlinessSeekbarValue(cleanlinessRating);
                cleanlinessSeekbarValue.setText(cleanlinessRatingValue);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generalSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                generalRating = progress;
                String generalRatingValue = SeekbarUtility.generalSeekbarValue(generalRating);
                generalSeekbarValue.setText(generalRatingValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.review_submit_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                reviewSubmit.setTextReview(textReview.getText().toString());

                APIInterface service = RestClient.getClient();
                String json = new Gson().toJson(reviewSubmit);
                Call<ReviewSubmit> call = service.submitReview(reviewSubmit);
                call.enqueue(new Callback<ReviewSubmit>() {
                    @Override
                    public void onResponse(Response<ReviewSubmit> response, Retrofit retrofit) {
                        Snackbar.make(view, "Review Submit successfull", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Snackbar.make(view, "Review Submit not successfull", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
            }
        });
    }


    public void submitReview(final View view){
        reviewSubmit.setTextReview(textReview.getText().toString());

        APIInterface service = RestClient.getClient();
        String json = new Gson().toJson(reviewSubmit);
        Call<ReviewSubmit> call = service.submitReview(reviewSubmit);
        call.enqueue(new Callback<ReviewSubmit>() {
            @Override
            public void onResponse(Response<ReviewSubmit> response, Retrofit retrofit) {
                Snackbar.make(view, "Review Submit successfull", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

            @Override
            public void onFailure(Throwable t) {
                Snackbar.make(view, "Review Submit not successfull", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
