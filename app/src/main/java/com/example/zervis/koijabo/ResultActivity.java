package com.example.zervis.koijabo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.zervis.koijabo.adapters.ResultPageAdapter;
import com.example.zervis.koijabo.pojo.ResultModel;
import com.example.zervis.koijabo.restcall.APIInterface;
import com.example.zervis.koijabo.restcall.RestClient;

import java.util.List;
import java.util.logging.Logger;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class ResultActivity extends Activity {

    RecyclerView mResultPageRecyclerView;
    RecyclerView.LayoutManager mResultPageRecyclerViewLayoutManager;
    RecyclerView.Adapter resultPageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mResultPageRecyclerView = (RecyclerView) findViewById(R.id.result_list);
//        mResultPageRecyclerViewLayoutManager = new GridLayoutManager(this, 1);
        mResultPageRecyclerViewLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mResultPageRecyclerView.setLayoutManager(mResultPageRecyclerViewLayoutManager);

        Intent intent = getIntent();
        String Value =  intent.getExtras().getString("Value");

        APIInterface service = RestClient.getClient();
        Call<List<ResultModel>> call = service.getSearchResult(Value);
        call.enqueue(new Callback<List<ResultModel>>() {
            @Override
            public void onResponse(Response<List<ResultModel>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    resultPageAdapter = new ResultPageAdapter(ResultActivity.this ,response.body());
                    mResultPageRecyclerView.setAdapter(resultPageAdapter);
                    Log.w("result model", response.raw().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // show some sort of dialog or something
                Log.v("Failed result model", "Failed");
            }
        });

    }

    public void goToDetailsPage(View view){
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }

    public void listItemOnClick(View view){
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }
}
