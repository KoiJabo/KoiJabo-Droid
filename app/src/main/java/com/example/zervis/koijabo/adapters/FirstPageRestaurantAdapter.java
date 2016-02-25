package com.example.zervis.koijabo.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zervis.koijabo.DetailsActivity;
import com.example.zervis.koijabo.R;
import com.example.zervis.koijabo.lib.Utility;
import com.example.zervis.koijabo.pojo.ResultModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zervis on 30/01/2016.
 */

public class FirstPageRestaurantAdapter extends RecyclerView.Adapter<FirstPageRestaurantAdapter.ViewHolder>{

    List<ResultModel> items = new ArrayList<ResultModel>();
    Context mContext;
    double lat=0;
    double lon=0;

    public FirstPageRestaurantAdapter(Context context, List<ResultModel> resultModelList, double lat, double lon){
        this.items = resultModelList;
        this.mContext = context;
        this.lat = lat;
        this.lon = lon;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_first_page_restaurant_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.restaurant_id.setText(items.get(position).getId());
        holder.first_page_restaurant_result_list_item_title.setText(items.get(position).getName());
        try {
            Picasso.with(mContext)
                    .load(items.get(position).getTitleImageUrl().toString())
                    .into(holder.first_page_restaurant_result_list_item_img);
        }
        catch (Exception e){

        }

        holder.restaurant_address.setText(items.get(position).getArea());
        holder.restaurant_cuisine.setText(Utility.listToStringBuilder(items.get(position).getCuisines(), ", "));
        holder.restaurant_rating.setText(items.get(position).getGeneralRatingRating().toString());

        if (items.get(position).getIsOpenNow()){
            holder.restaurant_open_or_close.setText("Open");
            holder.restaurant_open_or_close.setTextColor(Color.parseColor("#4CAF50"));
        } else {
            holder.restaurant_open_or_close.setText("Close");
            holder.restaurant_open_or_close.setTextColor(Color.parseColor("#F44336"));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        public TextView first_page_restaurant_result_list_item_title;
        public ImageView first_page_restaurant_result_list_item_img;
        public TextView restaurant_id;

        public TextView restaurant_cuisine;
        public TextView restaurant_address;
        public TextView restaurant_rating;
        public TextView restaurant_open_or_close;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            first_page_restaurant_result_list_item_title = (TextView)itemView.findViewById(R.id.restaurant_title);
            first_page_restaurant_result_list_item_img = (ImageView)itemView.findViewById(R.id.restaurant_img);
            restaurant_id = (TextView)itemView.findViewById(R.id.restaurant_id);

            restaurant_cuisine = (TextView)itemView.findViewById(R.id.restaurant_cuisine) ;
            restaurant_address = (TextView)itemView.findViewById(R.id.restaurant_address) ;
            restaurant_rating = (TextView)itemView.findViewById(R.id.restaurant_rating) ;
            restaurant_open_or_close = (TextView)itemView.findViewById(R.id.restaurant_open_or_close);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            String id = items.get(position).getId();

            Intent intent = new Intent(mContext, DetailsActivity.class);
            intent.putExtra("id",id);
            intent.putExtra("lat", lat);
            intent.putExtra("lon", lon);

            mContext.startActivity(intent);
        }
    }
}
