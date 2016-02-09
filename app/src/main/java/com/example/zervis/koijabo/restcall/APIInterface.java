package com.example.zervis.koijabo.restcall;

import com.example.zervis.koijabo.pojo.DetailsModel;
import com.example.zervis.koijabo.pojo.ResultModel;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Zarvis on 09/02/2016.
 */
public interface APIInterface {

    @GET("api/Restaurant/search")
    Call<List<ResultModel>> getSearchResult(@Query("value") String value);

    @GET("api/Restaurant/get")
    Call<DetailsModel> getDetails(@Query("id") String value);
}
