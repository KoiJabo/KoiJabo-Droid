package com.example.zervis.koijabo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

    public  FirstPageCafeAdapter(Context context, List<ResultModel> resultModelList){
        this.items = resultModelList;
        this.mContext = context;
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

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView list_item_title;
        public ImageView first_page_cafe_result_list_item_img;
        public TextView cafe_id;

        public ViewHolder(View itemView) {
            super(itemView);
            list_item_title = (TextView)itemView.findViewById(R.id.first_page_restaurant_result_list_item_title);
            first_page_cafe_result_list_item_img = (ImageView)itemView.findViewById(R.id.first_page_cafe_result_list_item_img);
            cafe_id = (TextView)itemView.findViewById(R.id.cafe_id);
        }
    }
}
