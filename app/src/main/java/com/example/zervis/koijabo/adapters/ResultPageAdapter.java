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
public class ResultPageAdapter extends RecyclerView.Adapter<ResultPageAdapter.ViewHolder>{

    List<String> items = new ArrayList<>();

    public ResultPageAdapter(){
        items.add("asd");
        items.add("asd");
        items.add("asd");
        items.add("asd");
        items.add("asd");
        items.add("asd");
        items.add("asd");
        items.add("asd");
        items.add("asd");
        items.add("asd");
        items.add("asd");
        items.add("asd");
        items.add("asd");
        items.add("asd");
        items.add("asd");
        items.add("asd");
    }

    @Override
    public ResultPageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_result_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ResultPageAdapter.ViewHolder holder, int position) {
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
            list_item_title = (TextView)itemView.findViewById(R.id.result_list_item_title);
        }
    }
}
