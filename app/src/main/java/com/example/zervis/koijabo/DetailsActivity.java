package com.example.zervis.koijabo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }

    public void goToAddReviewPage(View view){
        Intent intent = new Intent(this, AddReviewActivity.class);
        startActivity(intent);
    }
}
