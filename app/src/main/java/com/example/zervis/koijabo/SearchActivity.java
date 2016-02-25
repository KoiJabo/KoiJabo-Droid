package com.example.zervis.koijabo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.zervis.koijabo.adapters.FirstPageRestaurantAdapter;
import com.example.zervis.koijabo.pojo.ResultModel;
import com.example.zervis.koijabo.pojo.SearchResult;
import com.example.zervis.koijabo.pojo.SearchSuggestion;
import com.example.zervis.koijabo.restcall.APIInterface;
import com.example.zervis.koijabo.restcall.RestClient;
import com.facebook.login.LoginManager;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class SearchActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    SearchSuggestion searchSuggestion;

    Context searchContext = this;

    String spinnerGoodFor = "";
    String spinnerArea = "";
    String spinnerEstablishmentType = "";
    String spinnerCards = "";

    String open_at = "";
    String parking = "";
    String takeout = "";
    String luxury_dining = "";
    String reservation = "";
    String outdoor = "";
    String kids_zone = "";
    String washroom = "";
    String toilet = "";

    String Value = "";



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
                    searchSuggestion = response.body();

                    ArrayList<String> keywords = new ArrayList<String>();
                    keywords.addAll(searchSuggestion.getArea());
                    keywords.addAll(searchSuggestion.getAttires());
                    keywords.addAll(searchSuggestion.getCreditCards());
                    keywords.addAll(searchSuggestion.getCuisines());
                    keywords.addAll(searchSuggestion.getEstablishmentType());
                    keywords.addAll(searchSuggestion.getGoodFors());

                    int length = keywords.size();
                    String keys[] = new String[length];
                    for (int i=0; i < length; i++){
                        keys[i] = keywords.get(i);
                    }

                    int areaLength = searchSuggestion.getArea().size();
                    String areas[] = new String[areaLength];
                    for (int i=0; i < areaLength; i++){
                        areas[i] = searchSuggestion.getArea().get(i);
                    }

                    ArrayAdapter<String> adapterText = new ArrayAdapter<String>(searchContext,
                            android.R.layout.simple_dropdown_item_1line, keys);

                    ArrayAdapter<String> adapterArea = new ArrayAdapter<String>(searchContext,
                            android.R.layout.simple_dropdown_item_1line, areas);

                    AutoCompleteTextView textSuggestion = (AutoCompleteTextView)
                            findViewById(R.id.search_text);

//                    AutoCompleteTextView areaSuggestion = (AutoCompleteTextView)
//                            findViewById(R.id.search_location);

                    textSuggestion.setAdapter(adapterText);
//                    areaSuggestion.setAdapter(adapterArea);

                    populateSpinner(R.id.goodFor_spinner, searchSuggestion.getGoodFors());
                    populateSpinner(R.id.establishment_type_spinner, searchSuggestion.getEstablishmentType());
                    populateSpinner(R.id.search_location_spinner, searchSuggestion.getArea());
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
    private void populateSpinner(int spinnerId, List<String> spinnerItems)
    {
        Spinner spinner = (Spinner) findViewById(spinnerId);
        String[] spinnerItemArray = spinnerItems.
                toArray(new String[searchSuggestion.getGoodFors().size()]);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_item, spinnerItemArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
    public void searchButtonOnclick(View view){

        TextView searchTeext = (TextView)findViewById(R.id.search_text);
        Value = searchTeext.getText().toString();
        Value += " " + spinnerEstablishmentType;
        Value += " " + spinnerGoodFor;
        Value += " " + spinnerCards;


        Value += " " + parking;
        Value += " " + takeout;
        Value += " " + luxury_dining;
        Value += " " + reservation;
        Value += " " + outdoor;
        Value += " " + kids_zone;
        Value += " " + washroom;
        Value += " " + toilet;


        Intent intent = new Intent(this, ResultActivity.class);
        if (spinnerArea == searchSuggestion.getArea().get(0)){
            intent.putExtra("lat", lat);
            intent.putExtra("lon", lon);
        } else {
            Value += " "+ spinnerArea;
        }
        intent.putExtra("Value",Value);

        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) findViewById(R.id.goodFor_spinner);
        int i = parent.getId();
        if (i==R.id.goodFor_spinner)
            spinnerGoodFor = searchSuggestion.getGoodFors().get(position);
        else if (i==R.id.establishment_type_spinner)
            spinnerEstablishmentType = searchSuggestion.getEstablishmentType().get(position);
        else if (i==R.id.search_location_spinner)
            spinnerArea = searchSuggestion.getArea().get(position);
        else if (i==R.id.cards_spinner)
            spinnerCards = searchSuggestion.getCreditCards().get(position);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
//            case R.id.search_tag_open_at:
//                if(checked)
//
//                else
//                //
//                break;
            case R.id.search_tag_parking:
                if(checked)
                    parking = "Parking";
                else
                    parking = "";
                break;
            case R.id.search_tag_takeout:
                if(checked)
                    takeout = "TakeOut";
                else
                    takeout = "";
                break;
            case R.id.search_tag_luxury_dining:
                if(checked)
                    luxury_dining = "LuxuryDining";
                else
                    luxury_dining = "";
                break;
            case R.id.search_tag_reservation:
                if(checked)
                    reservation = "Reservation";
                else
                    reservation = "";
                break;
            case R.id.search_tag_outdoor:
                if(checked)
                    outdoor = "outdoor";
                else
                    outdoor = "";
                break;
            case R.id.search_tag_kids_zone:
                if(checked)
                    kids_zone = "kids zone";
                else
                    kids_zone = "";
                break;
            case R.id.search_tag_washroom:
                if(checked)
                    washroom = "washroom";
                else
                    washroom = "";
                break;
            case R.id.search_tag_toilet:
                if(checked)
                    toilet = "toilet";
                else
                    toilet = "";
                break;
            default:
                break;
        }
    }
}
