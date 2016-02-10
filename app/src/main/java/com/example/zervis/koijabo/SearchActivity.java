package com.example.zervis.koijabo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void searchButtonOnclick(View view){

        TextView searchTeext = (TextView)findViewById(R.id.search_text);
        String Value = searchTeext.getText().toString();


        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("Value",Value);
        startActivity(intent);
    }
}
