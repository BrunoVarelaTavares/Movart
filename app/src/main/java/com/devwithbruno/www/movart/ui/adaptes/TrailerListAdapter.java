package com.devwithbruno.www.movart.ui.adaptes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.utils.PlayVideoActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Bruno on 28/11/2017.
 */

public class TrailerListAdapter extends RecyclerView.Adapter<TrailerListAdapter.MyViewHolder> {

    private static final String TAG = "TrailerListAdapter";

    private Context mContext;
    private List<String> trailerList, videosIDs;
    private String mTitle, mOverview;


    public TrailerListAdapter(Context mContext, List<String> trailerList, final String title, String overview,List<String> videosIDs) {
        this.mContext = mContext;
        this.trailerList = trailerList;
        this.mTitle = title;
        this.mOverview = overview;
        this.videosIDs  = videosIDs;
        Log.d(TAG, "TrailerListAdapter: viva ");

    }

    @Override
    public TrailerListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_youtube_image_card,parent,false);
        Log.d(TAG, "onCreateViewHolder: viva ");
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: viva " + trailerList.size());
//        StringBuilder urlsVideo = new StringBuilder();
//
//        urlsVideo.append("https://img.youtube.com/vi/");
//        final String videoID = trailerList.get(position).getKey();
//        urlsVideo.append(videoID);
//        urlsVideo.append("/0.jpg");
//
//
//        String urls = urlsVideo.toString();


        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(trailerList.get(position), holder.imgPoster);



        holder.imgPoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, PlayVideoActivity.class);
                intent.putExtra(String.valueOf(R.string.movie_youtube_id), videosIDs.get(position));
                intent.putExtra("title", mTitle);
                intent.putExtra("overview", mOverview);
                mContext.startActivity(intent);





            }
        });




    }

    @Override
    public int getItemCount() {
        return trailerList.size();
    }





    public class MyViewHolder extends RecyclerView.ViewHolder{


        public ImageView imgPoster;


        public MyViewHolder(View itemView) {
            super(itemView);
            imgPoster = (ImageView)itemView.findViewById(R.id.iv_youtube_poster);
            Log.d(TAG, "MyViewHolder:  viva ");
        }
    }


}
