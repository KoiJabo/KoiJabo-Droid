package com.example.zervis.koijabo.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zervis.koijabo.DetailsActivity;
import com.example.zervis.koijabo.R;
import com.example.zervis.koijabo.pojo.ResultModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zervis on 30/01/2016.
 */

public class FirstPageCafeAdapter extends RecyclerView.Adapter<FirstPageCafeAdapter.ViewHolder> {

    List<ResultModel> items = new ArrayList<ResultModel>();
    Context mContext;
    double lat=0;
    double lon=0;


    public  FirstPageCafeAdapter(Context context, List<ResultModel> resultModelList, double lat, double lon){
        this.items = resultModelList;
        this.mContext = context;
        this.lat = lat;
        this.lon = lon;
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
        holder.cafe_id.setText(items.get(position).getId());
        holder.list_item_title.setText(items.get(position).getName());
        try {
            Picasso.with(mContext)
                    .load(items.get(position).getTitleImageUrl().toString())
                    .into(holder.first_page_cafe_result_list_item_img);
        }
        catch (Exception e){

        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView list_item_title;
        public ImageView first_page_cafe_result_list_item_img;
        public TextView cafe_id;



        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            list_item_title = (TextView)itemView.findViewById(R.id.cafe_title);
            first_page_cafe_result_list_item_img = (ImageView)itemView.findViewById(R.id.cafe_img);
            cafe_id = (TextView)itemView.findViewById(R.id.cafe_id);
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
