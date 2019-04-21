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
import com.devwithbruno.www.movart.data.model.Artist;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Bruno on 28/11/2017.
 */

public class ArtistesAdapter extends RecyclerView.Adapter<ArtistesAdapter.MyViewHolder> {

    private static final String TAG = "ArtistesAdapter";

    private Context mContext;
    private List<Artist> artistList;
    private ApiCalls apiCalls;



    public ArtistesAdapter(Context mContext, List<Artist> artistList) {
        this.mContext = mContext;
        this.artistList = artistList;
        apiCalls = new ApiCalls();
    }

    @Override
    public ArtistesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_artists_card,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String name = artistList.get(position).getName();
        holder.artistName.setText(name);

        final long artistID = artistList.get(position).getId();
        apiCalls.getArtist(mContext,artistID,holder.imgPoster,artistList.get(position));

        String poster = "https://image.tmdb.org/t/p/w500" + artistList.get(position).getProfile_path();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(poster, holder.imgPoster);


    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView artistName;
        public ImageView imgPoster;


        public MyViewHolder(View itemView) {
            super(itemView);
            artistName = (TextView) itemView.findViewById(R.id.tv_artist_name);
            imgPoster = (ImageView)itemView.findViewById(R.id.imageArtistPoster);


        }
    }


}
