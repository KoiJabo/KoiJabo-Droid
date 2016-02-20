package com.example.zervis.koijabo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.zervis.koijabo.adapters.FirstPageRestaurantAdapter;
import com.example.zervis.koijabo.adapters.TagsFalseAdapter;
import com.example.zervis.koijabo.adapters.TagsTrueAdapater;
import com.example.zervis.koijabo.lib.Utility;
import com.example.zervis.koijabo.pojo.DetailsModel;
import com.example.zervis.koijabo.pojo.ResultModel;
import com.example.zervis.koijabo.pojo.Review;
import com.example.zervis.koijabo.restcall.APIInterface;
import com.example.zervis.koijabo.restcall.RestClient;

import org.w3c.dom.Text;

import java.util.ArrayList;
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

        Intent intent = getIntent();
        String id =  intent.getExtras().getString("id");
        APIInterface service = RestClient.getClient();

        Call<DetailsModel> call = service.getDetails(id);
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
                // show some sort of locationdialog or something
                Log.v("Failed detailsmodel", "Failed");
            }
        });

        APIInterface service1 = RestClient.getClient();
        Call<List<Review>> call1 = service1.getReviews(id);
        call1.enqueue(new Callback<List<Review>>() {
            @Override
            public void onResponse(Response<List<Review>> response, Retrofit retrofit) {
                List<Review> reviews = response.body();

                try {
                    TextView user1 = (TextView)findViewById(R.id.user1);
                    user1.setText(reviews.get(0).getUserId());

                    TextView review1 = (TextView)findViewById(R.id.review1);
                    review1.setText(reviews.get(0).getUserId());
                }

                catch (Exception e){

                }
                try {
                    TextView user2 = (TextView)findViewById(R.id.user1);
                    user2.setText(reviews.get(1).getUserId());

                    TextView review2 = (TextView)findViewById(R.id.review1);
                    review2.setText(reviews.get(1).getUserId());
                }

                catch (Exception e){

                }
                try{
                    TextView user3 = (TextView)findViewById(R.id.user1);
                    user3.setText(reviews.get(2).getUserId());

                    TextView review3 = (TextView)findViewById(R.id.review1);
                    review3.setText(reviews.get(2).getUserId());
                }
                catch (Exception e){

                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });


    }

    private void assignValues(DetailsModel detailsModel) {

        TextView title = (TextView)findViewById(R.id.details_page_heading_title);
        title.setText(detailsModel.getName());

        TextView address = (TextView)findViewById(R.id.details_page_heading_address);
        address.setText(detailsModel.getAddress());

        TextView generalRating = (TextView)findViewById(R.id.details_page_general_rating);
        generalRating.setText(detailsModel.getGeneralRatingRating().toString());


        TextView establishmentType = (TextView)findViewById(R.id.details_page_establishment_type);
        String establisment = Utility.listToStringbuilderWithNewLine((ArrayList<String>) detailsModel.getEstablishmentType());
        establishmentType.setText(establisment);

        TextView openOrClose = (TextView)findViewById(R.id.detail_page_open_close);
        String openorclose = detailsModel.getIsOpenNow()? "Open" : "Close";
        openOrClose.setText(openorclose);


        TextView ratingText = (TextView)findViewById(R.id.detail_page_rating_text);
        String ratingtext = Utility.ratingText(detailsModel.getGeneralRatingRating());
        ratingText.setText(ratingtext);


        TextView rating = (TextView)findViewById(R.id.detail_page_rating_number);
        rating.setText(detailsModel.getGeneralRatingRating().toString());





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

        String id = detailsModel.getId();
        intent.putExtra("id",id);
        startActivity(intent);
    }
}
