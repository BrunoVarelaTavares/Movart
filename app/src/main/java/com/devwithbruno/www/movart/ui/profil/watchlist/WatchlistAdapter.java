package com.devwithbruno.www.movart.ui.profil.watchlist;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Watchlist;
import com.devwithbruno.www.movart.ui.base.BaseViewHolder;
import com.devwithbruno.www.movart.utils.DateFormatter;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bruno on 24/01/2018.
 */

public class WatchlistAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final String TAG = "WatchlistAdapter";
    private List<Watchlist> watchlistsList;

    public interface  OnImageSelectedListener{
        void onMovieImageSelect(long movieID);
        void onTvImageSelected(long tvID);
    }

    public OnImageSelectedListener mOnImageSelectedListener;



    public WatchlistAdapter(List<Watchlist> watchlists) {
        this.watchlistsList = watchlists;
        Log.d(TAG, "WatchlistAdapter: +  WatchlistFragment ");
    }


    public void setOnImageSelectedListener(OnImageSelectedListener mOnImageSelectedListener){
        this.mOnImageSelectedListener = mOnImageSelectedListener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_watchlist_card,parent,false);
        return new WatchlistAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);

    }

    @Override
    public int getItemCount() {
        return watchlistsList.size();
    }


    public void add(List<Watchlist> watchlists) {
        Log.d(TAG, "add: " + watchlists.size());
        this.watchlistsList.addAll(watchlists);
        notifyDataSetChanged();
    }


    public void clearData(){
        this.watchlistsList.clear();
        notifyDataSetChanged();

    }

    public class MyViewHolder extends BaseViewHolder{

        @BindView(R.id.textViewTitle)
        public TextView textViewTitle;

        @BindView(R.id.textViewYear)
        public TextView textViewYear;

        @BindView(R.id.textViewRating)
        public TextView textViewRating;


        @BindView(R.id.imagePoster)
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

            final Watchlist watchlist = watchlistsList.get(position);

            if (watchlist.getTitle() != null){
               String title = watchlist.getTitle();
               textViewTitle.setText(title);
            }

            if (watchlist.getReleaseDate() != null){
                String year = DateFormatter.getDateYear(watchlist.getReleaseDate());
                textViewYear.setText(year);
            }
            if (watchlist.getVoteAverage() != -1){
                double voteAverage = watchlist.getVoteAverage();
                textViewRating.setText(""+voteAverage);
            }


            if (watchlist.getPosterPath()!= null){
                String poster = "https://image.tmdb.org/t/p/w500" + watchlist.getPosterPath();
                ImageLoader imageLoader = ImageLoader.getInstance();
                imageLoader.displayImage(poster, imgPoster);
            }


            imgPoster.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    if (artist.getId() != -1 && mOnImageSelectedListener != null){
//                        long artistId = artist.getId();
//                        mOnImageSelectedListener.onArtistImageSelect(artistId, artist);
//
//
//                    }

                }
            });

        }
    }

}
