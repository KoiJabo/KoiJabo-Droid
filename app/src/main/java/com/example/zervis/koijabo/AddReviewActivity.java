package com.example.zervis.koijabo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.zervis.koijabo.lib.SeekbarUtility;

public class AddReviewActivity extends Activity {

    SeekBar foodSeekbar = null;
    SeekBar serviceSeekbar = null;
    SeekBar ambienceSeekbar = null;
    SeekBar cleanlinessSeekbar = null;

    TextView foodSeekbarValue = null;
    TextView serviceSeekbarValue = null;
    TextView ambienceSeekbarValue = null;
    TextView cleanlinessSeekbarValue = null;

    int foodRating = 0;
    int serviceRating = 0;
    int ambienceRating = 0;
    int cleanlinessRating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);
        initiateVariables();

        foodSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                foodRating = progress;
                String foodRatingValue = SeekbarUtility.foodSeekbarValue(foodRating);
                foodSeekbarValue.setText(foodRatingValue);
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
    }

    private void initiateVariables(){

        foodSeekbar = (SeekBar) findViewById(R.id.food_seekBar);
        serviceSeekbar = (SeekBar) findViewById(R.id.service_seekBar);
        ambienceSeekbar = (SeekBar) findViewById(R.id.ambience_seekBar);
        cleanlinessSeekbar = (SeekBar) findViewById(R.id.cleanliness_seekBar);

        foodSeekbarValue = (TextView) findViewById(R.id.food_seekBar_value);
        serviceSeekbarValue = (TextView) findViewById(R.id.service_seekBar_value);
        ambienceSeekbarValue = (TextView) findViewById(R.id.ambience_seekBar_value);
        cleanlinessSeekbarValue = (TextView) findViewById(R.id.cleanliness_seekBar_value);
    }


}
