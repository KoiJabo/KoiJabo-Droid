package com.example.zervis.koijabo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.zervis.koijabo.adapters.MoreReviewAdapter;
import com.example.zervis.koijabo.pojo.Review;
import com.example.zervis.koijabo.restcall.APIInterface;
import com.example.zervis.koijabo.restcall.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MoreReviews extends Activity {
    RecyclerView mReviewsPageRecyclerView;
    RecyclerView.LayoutManager mReviewsPageRecyclerViewLayoutManager;
    RecyclerView.Adapter reviewsPageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_reviews);

        mReviewsPageRecyclerView = (RecyclerView) findViewById(R.id.more_reviews_list);
//        mReviewsPageRecyclerViewLayoutManager = new GridLayoutManager(this, 1);
        mReviewsPageRecyclerViewLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mReviewsPageRecyclerView.setLayoutManager(mReviewsPageRecyclerViewLayoutManager);

        Intent intent = getIntent();
        String id =  intent.getExtras().getString("id");

        APIInterface service = RestClient.getClient();
        Call<List<Review>> call = service.getReviews(id);
        call.enqueue(new Callback<List<Review>>() {
            @Override
            public void onResponse(Response<List<Review>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    ArrayList<Review> reviews = (ArrayList<Review>) response.body();
                    reviewsPageAdapter = new MoreReviewAdapter(MoreReviews.this, reviews);
                    mReviewsPageRecyclerView.setAdapter(reviewsPageAdapter);
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
}
