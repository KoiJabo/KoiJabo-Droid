package com.example.zervis.koijabo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.zervis.koijabo.adapters.ResultPageAdapter;
import com.example.zervis.koijabo.lib.LocationDetector;
import com.example.zervis.koijabo.pojo.ResultModel;
import com.example.zervis.koijabo.pojo.SearchResult;
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
    double lat=0;
    double lon=0;
    String Value = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mResultPageRecyclerView = (RecyclerView) findViewById(R.id.result_list);
//        mReviewsPageRecyclerViewLayoutManager = new GridLayoutManager(this, 1);
        mResultPageRecyclerViewLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mResultPageRecyclerView.setLayoutManager(mResultPageRecyclerViewLayoutManager);

        Intent intent = getIntent();
        Value =  intent.getExtras().getString("Value");
        lat = intent.getExtras().getDouble("lat");
        lon = intent.getExtras().getDouble("lon");

        TextView searchQuer = (TextView)findViewById(R.id.search_query_text);
        searchQuer.setText(Value);


        APIInterface service = RestClient.getClient();
        Call<SearchResult> call = service.getSearchResult(Value, lat, lon);
        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Response<SearchResult> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    resultPageAdapter = new ResultPageAdapter(ResultActivity.this ,response.body().getData());
                    mResultPageRecyclerView.setAdapter(resultPageAdapter);
                    Log.v("result model", response.raw().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // show some sort of locationdialog or something
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
