package com.example.zervis.koijabo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.zervis.koijabo.adapters.FirstPageAdapter;
import com.example.zervis.koijabo.adapters.ResultPageAdapter;

public class ResultActivity extends Activity {

    RecyclerView mResultPageRecyclerView;
    RecyclerView.LayoutManager mResultPageRecyclerViewLayoutManager;
    RecyclerView.Adapter resultPageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        mResultPageRecyclerView = (RecyclerView) findViewById(R.id.result_list);
        mResultPageRecyclerViewLayoutManager = new LinearLayoutManager(this);
        mResultPageRecyclerView.setLayoutManager(mResultPageRecyclerViewLayoutManager);
        resultPageAdapter = new ResultPageAdapter();
        mResultPageRecyclerView.setAdapter(resultPageAdapter);
    }

    public void goToDetailsPage(View view){
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }
}
