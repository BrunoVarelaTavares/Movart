package com.devwithbruno.www.movart.ui.adaptes;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.network.api.ApiCalls;
import com.devwithbruno.www.movart.data.model.Image;
import com.devwithbruno.www.movart.ui.details.DetailsActivity;
import com.devwithbruno.www.movart.utils.GridImagesFragment;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 28/11/2017.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

    private static final String TAG = "ImageAdapter";

    private Context mContext;
    private List<Image> imageList;
    private ApiCalls apiCalls;

    public ImageAdapter(Context mContext, List<Image> imageList) {
        this.mContext = mContext;
        this.imageList = imageList;
        Log.d(TAG, "ImageAdapter: Minha  Constructer ");
    }

    @Override
    public ImageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_images_card,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        String poster = "https://image.tmdb.org/t/p/w500" + imageList.get(position).getFile_path();

        Log.d(TAG, "onBindViewHolder: MINHA " + imageList.get(position).getFile_path());

        final int imagePosition = position;


        holder.imgPoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((DetailsActivity)mContext).hideLayout();
                        Bundle args = new Bundle();
                        GridImagesFragment gridImagesFragment = new GridImagesFragment();
                        args.putParcelableArrayList("artists_images", (ArrayList<? extends Parcelable>) imageList);
                        args.putInt("image_position", imagePosition);
                        gridImagesFragment.setArguments(args);
                        FragmentTransaction transaction = ((DetailsActivity) mContext).getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.container, gridImagesFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
            }
        });


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
            imgPoster = (ImageView)itemView.findViewById(R.id.imagePoster);


        }
    }


}
