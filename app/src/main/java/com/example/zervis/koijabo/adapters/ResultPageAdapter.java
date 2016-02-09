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
import com.example.zervis.koijabo.restcall.APIInterface;
import com.example.zervis.koijabo.restcall.RestClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;

/**
 * Created by Zervis on 30/01/2016.
 */
public class ResultPageAdapter extends RecyclerView.Adapter<ResultPageAdapter.ViewHolder>{

    List<ResultModel> items = new ArrayList<ResultModel>();

    Context mContext;
    public ResultPageAdapter(Context context, List<ResultModel> resultModelList){
        this.items = resultModelList;
        this.mContext = context;
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

        holder.list_item_title.setText(items.get(position).getName());
        try {
            Picasso.with(mContext)
                    .load(items.get(position).getTitleImageUrl().toString())
                    .into(holder.result_list_item_image);
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
        public ImageView result_list_item_image;

        public ViewHolder(View itemView) {
            super(itemView);
            list_item_title = (TextView)itemView.findViewById(R.id.result_list_item_title);
            result_list_item_image = (ImageView)itemView.findViewById(R.id.result_list_item_image);
        }
    }
}
