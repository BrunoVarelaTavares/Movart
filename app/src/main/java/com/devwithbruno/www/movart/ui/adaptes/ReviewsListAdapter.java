package com.devwithbruno.www.movart.ui.adaptes;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Review;
import com.devwithbruno.www.movart.ui.details.DetailsActivity;
import com.devwithbruno.www.movart.ui.details.ReviewsComments;

import java.util.List;

/**
 * Created by Bruno on 28/11/2017.
 */

public class ReviewsListAdapter extends RecyclerView.Adapter<ReviewsListAdapter.MyViewHolder> {

    private static final String TAG = "ReviewsListAdapter";

    private Context mContext;
    private List<Review> reviewList;

    public ReviewsListAdapter(Context mContext, List<Review> reviewList) {
        this.mContext = mContext;
        this.reviewList = reviewList;


    }

    @Override
    public ReviewsListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_reviews_card, parent, false);
        Log.d(TAG, "onCreateViewHolder: viva ");
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final String author = reviewList.get(position).getAuthor();
        final String content = reviewList.get(position).getContent();


        holder.textViewAuthor.setText(author);
        holder.textViewContent.setText(content);


        holder.textViewContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ESSA ");
                ((DetailsActivity)mContext).hideLayout();
                Bundle args = new Bundle();
                args.putString("author_name", author);
                args.putString("reviews_content", content);
                ReviewsComments reviewsComments = new ReviewsComments();
                reviewsComments.setArguments(args);
                FragmentTransaction transaction = ((DetailsActivity) mContext).getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.slide_in_left,
                        R.anim.slide_out_left,
                        R.anim.slide_in_right,
                        R.anim.slide_out_right);
                transaction.replace(R.id.container, reviewsComments);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });


    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView textViewAuthor, textViewContent;


        public MyViewHolder(View itemView) {
            super(itemView);
            textViewAuthor = (TextView) itemView.findViewById(R.id.tv_author);
            textViewContent = (TextView) itemView.findViewById(R.id.tv_content_review);

        }
    }


}
