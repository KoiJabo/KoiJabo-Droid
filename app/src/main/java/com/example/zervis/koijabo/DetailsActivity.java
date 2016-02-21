package com.example.zervis.koijabo;

import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.zervis.koijabo.fragments.LogInDialog;
import com.example.zervis.koijabo.lib.Utility;
import com.example.zervis.koijabo.pojo.DetailsModel;
import com.example.zervis.koijabo.pojo.Review;
import com.example.zervis.koijabo.restcall.APIInterface;
import com.example.zervis.koijabo.restcall.RestClient;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

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

    DialogFragment loginDialog;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private ProfileTracker mProfileTracker;
    Context context;

    int[] tagsTrueTextsId = {R.id.trueTag0,R.id.trueTag1,R.id.trueTag2,R.id.trueTag3,R.id.trueTag4,R.id.trueTag5,R.id.trueTag6,R.id.trueTag7,R.id.trueTag8,R.id.trueTag9};
    int[] tagsFalseTextsId = {R.id.falsTag0,R.id.falsTag1,R.id.falsTag2,R.id.falsTag3,R.id.falsTag4,R.id.falsTag5,R.id.falsTag6,R.id.falsTag7,R.id.falsTag8,R.id.falsTag9};
    int[] tagsTrueImagesId = {R.id.trueImage0,R.id.trueImage1,R.id.trueImage2,R.id.trueImage3,R.id.trueImage4,R.id.trueImage5,R.id.trueImage6,R.id.trueImage7,R.id.trueImage8,R.id.trueImage9};
    int[] tagsFalseImagesId = {R.id.falseImage0,R.id.falseImage1,R.id.falseImage2,R.id.falseImage3,R.id.falseImage4,R.id.falseImage5,R.id.falseImage6,R.id.falseImage7,R.id.falseImage8,R.id.falseImage9};

    DetailsModel detailsModel = new DetailsModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        context = this;
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
                    user1.setText(reviews.get(0).getFbUserName());

                    TextView review1 = (TextView)findViewById(R.id.review1);
                    review1.setText(reviews.get(0).getTextReview());
                }

                catch (Exception e){

                }
                try {
                    TextView user2 = (TextView)findViewById(R.id.user2);
                    user2.setText(reviews.get(1).getFbUserName());

                    TextView review2 = (TextView)findViewById(R.id.review2);
                    review2.setText(reviews.get(1).getTextReview());
                }

                catch (Exception e){

                }
                try{
                    TextView user3 = (TextView)findViewById(R.id.user3);
                    user3.setText(reviews.get(2).getFbUserName());

                    TextView review3 = (TextView)findViewById(R.id.review3);
                    review3.setText(reviews.get(2).getTextReview());
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

        //find out a way to load layout background from url
        final RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.details_page_background);


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


        for (int i=0;i<detailsModel.getTagsTrue().size(); i ++){
            TextView textView = (TextView)findViewById(tagsTrueTextsId[i]);
            textView.setText(detailsModel.getTagsTrue().get(i));
            ImageView imageView = (ImageView)findViewById(tagsTrueImagesId[i]);
            imageView.setImageResource(R.mipmap.ic_true);
        }

        for (int i=0;i<detailsModel.getTagsFalse().size(); i ++){
            TextView textView = (TextView)findViewById(tagsFalseTextsId[i]);
            textView.setText(detailsModel.getTagsFalse().get(i));
            ImageView imageView = (ImageView)findViewById(tagsFalseImagesId[i]);
            imageView.setImageResource(R.mipmap.ic_false);
        }



    }

    public void goToAddReviewPage(View view){

        if (KoiJaboApplication.profile!=null){
            Intent intent = new Intent(this, AddReviewActivity.class);
            String id = detailsModel.getId();
            intent.putExtra("id",id);
            startActivity(intent);
        } else{
            loginDialog = new LogInDialog();
            loginDialog.show(getFragmentManager(), "before review log in user");
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    public void facebookLogin(View view){
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton)view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends","public_profile", "email");

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                loginDialog.dismiss();


                if(Profile.getCurrentProfile() == null) {
                    mProfileTracker = new ProfileTracker() {
                        @Override
                        protected void onCurrentProfileChanged(Profile profile1, Profile profile2) {
                            // profile2 is the new profile
                            Log.v("facebook - profile", profile2.getFirstName());
                            mProfileTracker.stopTracking();
                            KoiJaboApplication.profile = profile2;

                        }
                    };
                    mProfileTracker.startTracking();
                }
                else {
                    KoiJaboApplication.profile = Profile.getCurrentProfile();
                    
                    Log.v("facebook - profile", KoiJaboApplication.profile.getFirstName());
                }

                Toast.makeText(getApplicationContext(), "You have been logged in through facebook", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
    }
}
