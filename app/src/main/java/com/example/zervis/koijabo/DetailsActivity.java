package com.example.zervis.koijabo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.zervis.koijabo.adapters.FirstPageRestaurantAdapter;
import com.example.zervis.koijabo.adapters.TagsFalseAdapter;
import com.example.zervis.koijabo.adapters.TagsTrueAdapater;
import com.example.zervis.koijabo.pojo.DetailsModel;
import com.example.zervis.koijabo.pojo.ResultModel;
import com.example.zervis.koijabo.restcall.APIInterface;
import com.example.zervis.koijabo.restcall.RestClient;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class DetailsActivity extends Activity {

    RecyclerView mTagsTrueRecyclerView;
    RecyclerView.LayoutManager mTagsTrueRecyclerLayoutManager;
    RecyclerView.Adapter mTagsTrueRecyclerViewAdapter;

    RecyclerView mTagsFalseRecyclerView;
    RecyclerView.LayoutManager mTagsFalseRecyclerLayoutManager;
    RecyclerView.Adapter mTagsFalseRecyclerViewAdapter;

    DetailsModel detailsModel = new DetailsModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        APIInterface service = RestClient.getClient();
        Call<DetailsModel> call = service.getDetails("56b634d21803722ba844cc92");
        call.enqueue(new Callback<DetailsModel>() {
            @Override
            public void onResponse(Response<DetailsModel> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    detailsModel = response.body();
                    assignValues(detailsModel);
                    Log.w("detailsmodel", response.raw().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // show some sort of dialog or something
                Log.v("Failed detailsmodel", "Failed");
            }
        });




    }

    private void assignValues(DetailsModel detailsModel) {

        mTagsTrueRecyclerView = (RecyclerView) findViewById(R.id.details_tags_true);
        mTagsTrueRecyclerLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mTagsTrueRecyclerView.setLayoutManager(mTagsTrueRecyclerLayoutManager);
        mTagsTrueRecyclerViewAdapter = new TagsTrueAdapater(detailsModel.getTagsTrue());
        mTagsTrueRecyclerView.setAdapter(mTagsTrueRecyclerViewAdapter);

        mTagsFalseRecyclerView = (RecyclerView) findViewById(R.id.details_tags_false);
        mTagsFalseRecyclerLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mTagsFalseRecyclerView.setLayoutManager(mTagsFalseRecyclerLayoutManager);
        mTagsFalseRecyclerViewAdapter = new TagsFalseAdapter(detailsModel.getTagsFalse());
        mTagsFalseRecyclerView.setAdapter(mTagsFalseRecyclerViewAdapter);
    }

    public void goToAddReviewPage(View view){
        Intent intent = new Intent(this, AddReviewActivity.class);
        startActivity(intent);
    }
}
