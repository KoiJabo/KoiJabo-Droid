package com.example.zervis.koijabo.restcall;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Zarvis on 09/02/2016.
 */
public class RestClient {
    private static APIInterface apiInterface;
    private static String baseUrl = "http://koijaboapi.azurewebsites.net/";
//    private static String baseUrl = "http://180.149.28.188:25389/";

    public static APIInterface getClient(){
        if(apiInterface == null){
            OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();
            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            apiInterface = client.create(APIInterface.class);
        }
        return apiInterface;
    }
}
