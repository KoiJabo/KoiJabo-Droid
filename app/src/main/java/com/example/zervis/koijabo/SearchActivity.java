package com.example.zervis.koijabo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.example.zervis.koijabo.adapters.FirstPageRestaurantAdapter;
import com.example.zervis.koijabo.pojo.ResultModel;
import com.example.zervis.koijabo.pojo.SearchResult;
import com.example.zervis.koijabo.pojo.SearchSuggestion;
import com.example.zervis.koijabo.restcall.APIInterface;
import com.example.zervis.koijabo.restcall.RestClient;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class SearchActivity extends AppCompatActivity {


    SearchSuggestion searchSuggestion;

    Context searchContext = this;


    double lat=0;
    double lon=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        downloadSuggestions();

        Intent intent = getIntent();
        lat = intent.getExtras().getDouble("lat");
        lon = intent.getExtras().getDouble("lon");

    }

    private void downloadSuggestions(){
        APIInterface service = RestClient.getClient();
        Call<SearchSuggestion> call = service.getSearchSuggestions();
        call.enqueue(new Callback<SearchSuggestion>() {
            @Override
            public void onResponse(Response<SearchSuggestion> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    SearchSuggestion suggestions = response.body();

                    ArrayList<String> keywords = new ArrayList<String>();
                    keywords.addAll(suggestions.getArea());
                    keywords.addAll(suggestions.getAttires());
                    keywords.addAll(suggestions.getCreditCards());
                    keywords.addAll(suggestions.getCuisines());
                    keywords.addAll(suggestions.getEstablishmentType());
                    keywords.addAll(suggestions.getGoodFors());

                    int length = keywords.size();
                    String keys[] = new String[length];
                    for (int i=0; i < length; i++){
                        keys[i] = keywords.get(i);
                    }

                    int areaLength = suggestions.getArea().size();
                    String areas[] = new String[areaLength];
                    for (int i=0; i < areaLength; i++){
                        areas[i] = suggestions.getArea().get(i);
                    }

                    ArrayAdapter<String> adapterText = new ArrayAdapter<String>(searchContext,
                            android.R.layout.simple_dropdown_item_1line, keys);

                    ArrayAdapter<String> adapterArea = new ArrayAdapter<String>(searchContext,
                            android.R.layout.simple_dropdown_item_1line, areas);

                    AutoCompleteTextView textSuggestion = (AutoCompleteTextView)
                            findViewById(R.id.search_text);

                    AutoCompleteTextView areaSuggestion = (AutoCompleteTextView)
                            findViewById(R.id.search_location);

                    textSuggestion.setAdapter(adapterText);
                    areaSuggestion.setAdapter(adapterArea);

                    Log.v("searchSuggestions : ", response.raw().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // show some sort of dialog or something
                downloadSuggestions();
                Log.v("searchSuggestions", "Failed");
            }
        });
    }
    public void searchButtonOnclick(View view){

        TextView searchTeext = (TextView)findViewById(R.id.search_text);
        String Value = searchTeext.getText().toString();


        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("Value",Value);
        intent.putExtra("lat", lat);
        intent.putExtra("lon", lon);

        startActivity(intent);
    }
}
