package com.example.zervis.koijabo.restcall;

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

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = client.create(APIInterface.class);
        }
        return apiInterface;
    }
}
