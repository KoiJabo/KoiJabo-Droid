package com.example.zervis.koijabo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zervis.koijabo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zarvis on 08/02/2016.
 */
public class TagsTrueAdapater extends RecyclerView.Adapter<TagsTrueAdapater.ViewHolder> {


    List<String> items = new ArrayList<>();
    public TagsTrueAdapater(List<String> items){
        this.items = items;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_details_page_tags_true_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.list_item_title.setText(items.get(position));
        holder.icon_imageView.setImageResource(R.mipmap.ic_true);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView list_item_title;
        public ImageView icon_imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            list_item_title = (TextView)itemView.findViewById(R.id.details_tags_text);
            icon_imageView = (ImageView) itemView.findViewById(R.id.details_tags_image);
        }
    }
}
