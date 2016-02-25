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
import com.example.zervis.koijabo.pojo.Review;
import com.facebook.login.widget.ProfilePictureView;

import java.util.List;

/**
 * Created by Zarvis on 25/02/2016.
 */
public class MoreReviewAdapter extends RecyclerView.Adapter<MoreReviewAdapter.ViewHolder>{

    Context context;
    List<Review> reviews;
    public MoreReviewAdapter(Context context, List<Review> reviews){
        this.context = context;
        this.reviews = reviews;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_reviews_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.item_reviewer_image.setProfileId(reviews.get(position).getFbUserId());

        holder.item_reviewing_date.setText("2 days ago");;

        holder.item_reviewer_name.setText((reviews.get(position).getFbUserName()));;
        holder.item_review_overall_rating.setText((reviews.get(position).getOverAllRating().toString()));;
        holder.item_review_ambience_rating.setText((reviews.get(position).getAmbienceRating().toString()));;
        holder.item_review_service_rating.setText((reviews.get(position).getServiceRating().toString()));;
        holder.item_review_food_rating.setText((reviews.get(position).getFoodRating().toString()));;
        holder.item_review_text.setText((reviews.get(position).getTextReview()));;
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        public ProfilePictureView item_reviewer_image;
        public TextView item_reviewer_name;
        public TextView item_reviewing_date;
        public TextView item_review_overall_rating;
        public TextView item_review_ambience_rating;
        public TextView item_review_service_rating;
        public TextView item_review_food_rating;
        public TextView item_review_text;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            item_reviewer_image = (ProfilePictureView)itemView.findViewById(R.id.item_reviewer_image);
            item_reviewer_name = (TextView)itemView.findViewById(R.id.item_reviewer_name);
            item_reviewing_date = (TextView)itemView.findViewById(R.id.item_reviewing_date);
            item_review_overall_rating = (TextView)itemView.findViewById(R.id.item_review_overall_rating);
            item_review_ambience_rating = (TextView)itemView.findViewById(R.id.item_review_ambience_rating);
            item_review_service_rating = (TextView)itemView.findViewById(R.id.item_review_service_rating);
            item_review_food_rating = (TextView)itemView.findViewById(R.id.item_review_food_rating);
            item_review_text = (TextView)itemView.findViewById(R.id.item_review_text);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
