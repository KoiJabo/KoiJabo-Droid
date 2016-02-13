package com.example.zervis.koijabo.restcall;

import com.example.zervis.koijabo.pojo.DetailsModel;
import com.example.zervis.koijabo.pojo.ReviewSubmit;
import com.example.zervis.koijabo.pojo.SearchResult;
import retrofit.Callback;

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
    Call<SearchResult> getSearchResult(@Query("value") String value);

    @GET("api/Restaurant/get")
    Call<DetailsModel> getDetails(@Query("id") String value);

    @POST("api/review/create")
    Call<ReviewSubmit> submitReview(@Body ReviewSubmit review);
}
