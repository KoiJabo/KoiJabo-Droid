package com.example.zervis.koijabo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zervis.koijabo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zervis on 30/01/2016.
 */
public class FirstPageCafeAdapter extends RecyclerView.Adapter<FirstPageCafeAdapter.ViewHolder> {

    List<String> items = new ArrayList<>();

    public  FirstPageCafeAdapter(){
        items.add("asd");
        items.add("asd");
        items.add("asd");
        items.add("asd");
        items.add("asd");
    }
    @Override
    public FirstPageCafeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_first_page_cafe_result_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FirstPageCafeAdapter.ViewHolder holder, int position) {
        holder.list_item_title.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView list_item_title;

        public ViewHolder(View itemView) {
            super(itemView);
            list_item_title = (TextView)itemView.findViewById(R.id.first_page_restaurant_result_list_item_title);
        }
    }
}
