package com.example.zervis.koijabo.restcall;

import com.example.zervis.koijabo.pojo.DetailsModel;
import com.example.zervis.koijabo.pojo.Review;
import com.example.zervis.koijabo.pojo.SearchResult;
import com.example.zervis.koijabo.pojo.SearchSuggestion;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by Zarvis on 09/02/2016.
 */
public interface APIInterface {

    @GET("api/Restaurant/search")
    Call<SearchResult> getSearchResult(@Query("value") String value, @Query("lat") double lat, @Query("lon") double lon);

    @GET("api/Restaurant/get")
    Call<DetailsModel> getDetails(@Query("id") String value);

    @GET("api/Restaurant/getoptionsfordashboard")
    Call<SearchSuggestion> getSearchSuggestions();


    @POST("api/review/create")
    Call<Review> submitReview(@Body Review review);

    @GET("/api/review/GetReviews")
    Call<List<Review>> getReviews(@Query("restaurantId") String restaurantId);
}
