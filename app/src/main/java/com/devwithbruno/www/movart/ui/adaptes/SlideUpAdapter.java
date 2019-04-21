package com.devwithbruno.www.movart.ui.adaptes;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.network.api.ApiCalls;
import com.devwithbruno.www.movart.data.model.Movie;

import java.util.List;

/**
 * Created by Bruno on 28/11/2017.
 */

public class SlideUpAdapter extends RecyclerView.Adapter<SlideUpAdapter.MyYoutubeHolder> {

    private static final String TAG = "YoutubeImagesAdapter";

    private Context mContext;
    private List<Movie> movieList;
    private ApiCalls apiCalls;



    public SlideUpAdapter(Context mContext, List<Movie> movieList) {
        this.mContext = mContext;
        this.movieList = movieList;
        apiCalls = new ApiCalls();

    }

    @Override
    public MyYoutubeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_slide_card, parent, false);

        return new MyYoutubeHolder(view);
    }


    @Override
    public void onBindViewHolder(final MyYoutubeHolder holder, final int position) {
        String title = movieList.get(position).getTitle();
        String releaseDate = "Release Date " + movieList.get(position).getRelease_date();
        String textDescription = movieList.get(position).getOverview();

        apiCalls.getTrailers(mContext,movieList,position,holder.imgPosterYoutubeVideo, holder.imageViewPlay);
        holder.movieDesc.setText(textDescription);
        holder.relaseDate.setText(releaseDate);
        holder.movieTitle.setText(title);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public class MyYoutubeHolder extends RecyclerView.ViewHolder {

        public TextView movieTitle, relaseDate, movieDesc;
        public ImageView  imgPosterYoutubeVideo, imageViewPlay;




        public MyYoutubeHolder(View itemView) {
            super(itemView);
            movieTitle = (TextView) itemView.findViewById(R.id.tv_title);
            relaseDate = (TextView) itemView.findViewById(R.id.tv_time);
            movieDesc = (TextView)itemView.findViewById(R.id.tv_desc);
            imgPosterYoutubeVideo = (ImageView) itemView.findViewById(R.id.iw_poster);
            imageViewPlay = (ImageView) itemView.findViewById(R.id.iw_play);



        }
    }


}
