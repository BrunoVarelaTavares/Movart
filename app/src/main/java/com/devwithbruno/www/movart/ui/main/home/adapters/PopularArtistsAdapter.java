package com.devwithbruno.www.movart.ui.main.home.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.ui.base.BaseViewHolder;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bruno on 24/01/2018.
 */

public class PopularArtistsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final String TAG = "MoviesPopularMoviesAdapter";
    private List<Artist> artistList;

    public interface  OnImageSelectedListener{
        void onArtistImageSelect(long artistId, Artist artist);
    }

    public OnImageSelectedListener mOnImageSelectedListener;



    public PopularArtistsAdapter(List<Artist> artistList) {
        this.artistList = artistList;
    }


    public void setOnImageSelectedListener(OnImageSelectedListener mOnImageSelectedListener){
        this.mOnImageSelectedListener = mOnImageSelectedListener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_artists_card,parent,false);
        return new PopularArtistsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);

    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }


    public void addArtist(List<Artist> artistList) {
        this.artistList.addAll(artistList);
        notifyDataSetChanged();
    }


    public void clearData(){
        this.artistList.clear();
        notifyDataSetChanged();

    }

    public class MyViewHolder extends BaseViewHolder{

        @BindView(R.id.tv_artist_name)
        public TextView artistName;

        @BindView(R.id.imageArtistPoster)
        public ImageView imgPoster;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }



        @Override
        public void onBind(int position) {
            super.onBind(position);

            final Artist artist = artistList.get(position);

            if (artist.getName() != null){
               String name = artist.getName();
               artistName.setText(name);
            }

            if (artist.getProfile_path() != null){
                String poster = "https://image.tmdb.org/t/p/w500" + artist.getProfile_path();
                ImageLoader imageLoader = ImageLoader.getInstance();
                imageLoader.displayImage(poster, imgPoster);
            }


            imgPoster.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (artist.getId() != -1 && mOnImageSelectedListener != null){
                        long artistId = artist.getId();
                        mOnImageSelectedListener.onArtistImageSelect(artistId, artist);


                    }

                }
            });

        }
    }

}
