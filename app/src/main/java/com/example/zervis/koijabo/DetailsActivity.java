package com.example.zervis.koijabo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.zervis.koijabo.adapters.FirstPageRestaurantAdapter;
import com.example.zervis.koijabo.adapters.TagsFalseAdapter;
import com.example.zervis.koijabo.adapters.TagsTrueAdapater;

public class DetailsActivity extends Activity {

    RecyclerView mTagsTrueRecyclerView;
    RecyclerView.LayoutManager mTagsTrueRecyclerLayoutManager;
    RecyclerView.Adapter mTagsTrueRecyclerViewAdapter;

    RecyclerView mTagsFalseRecyclerView;
    RecyclerView.LayoutManager mTagsFalseRecyclerLayoutManager;
    RecyclerView.Adapter mTagsFalseRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        mTagsTrueRecyclerView = (RecyclerView) findViewById(R.id.details_tags_true);
        mTagsTrueRecyclerLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mTagsTrueRecyclerView.setLayoutManager(mTagsTrueRecyclerLayoutManager);
        mTagsTrueRecyclerViewAdapter = new TagsTrueAdapater();
        mTagsTrueRecyclerView.setAdapter(mTagsTrueRecyclerViewAdapter);

        mTagsFalseRecyclerView = (RecyclerView) findViewById(R.id.details_tags_false);
        mTagsFalseRecyclerLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mTagsFalseRecyclerView.setLayoutManager(mTagsFalseRecyclerLayoutManager);
        mTagsFalseRecyclerViewAdapter = new TagsFalseAdapter();
        mTagsFalseRecyclerView.setAdapter(mTagsFalseRecyclerViewAdapter);
    }

    public void goToAddReviewPage(View view){
        Intent intent = new Intent(this, AddReviewActivity.class);
        startActivity(intent);
    }
}
