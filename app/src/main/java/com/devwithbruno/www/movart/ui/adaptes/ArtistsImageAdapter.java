package com.devwithbruno.www.movart.ui.adaptes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Image;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Bruno on 28/11/2017.
 */

public class ArtistsImageAdapter extends RecyclerView.Adapter<ArtistsImageAdapter.MyViewHolder> {

    private static final String TAG = "ArtistsImageAdapter";

    private Context mContext;
    private List<Image> imageList;

    public ArtistsImageAdapter(Context mContext, List<Image> imageList) {
        this.mContext = mContext;
        this.imageList = imageList;
    }

    @Override
    public ArtistsImageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_artists_image_card,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        String poster = "https://image.tmdb.org/t/p/w500" + imageList.get(position).getFile_path();

        Log.d(TAG, "onBindViewHolder: MINHA " + imageList.get(position).getFile_path());


        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(poster, holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder{


        public ImageView imgPoster;


        public MyViewHolder(View itemView) {
            super(itemView);
            imgPoster = (ImageView)itemView.findViewById(R.id.iv_artist_image);


        }
    }


}
