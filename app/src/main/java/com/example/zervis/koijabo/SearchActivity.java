package com.example.zervis.koijabo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void searchButtonOnclick(View view){
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }
}
