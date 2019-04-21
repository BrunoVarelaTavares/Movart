package com.devwithbruno.www.movart.ui.profil;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.RecentVisited;
import com.devwithbruno.www.movart.ui.base.BaseViewHolder;
import com.devwithbruno.www.movart.utils.Config;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bruno on 24/01/2018.
 */

public class RecentVisitedAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final String TAG = "RecentVisitedAdapter";
    private List<RecentVisited> recentVisiteds;

    public interface OnImageSelectedListener {
        void onArtistImageSelect(long artistID);

        void onMovieImageSelected(long movieID);

        void onTvImageSelected(long tvID);
    }

    public OnImageSelectedListener mOnImageSelectedListener;


    public RecentVisitedAdapter(List<RecentVisited> recentVisited) {
        this.recentVisiteds = recentVisited;
    }


    public void setOnImageSelectedListener(OnImageSelectedListener mOnImageSelectedListener) {
        this.mOnImageSelectedListener = mOnImageSelectedListener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recent_seen_card, parent, false);
        return new RecentVisitedAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);

    }

    @Override
    public int getItemCount() {
        return recentVisiteds.size();
    }


    public void addRecentVisited(List<RecentVisited> recentVisiteds) {
        Collections.reverse(recentVisiteds);
        this.recentVisiteds.addAll(recentVisiteds);
        notifyDataSetChanged();
    }


    public void clearData() {
        this.recentVisiteds.clear();
        notifyDataSetChanged();

    }

    public class MyViewHolder extends BaseViewHolder {

        @BindView(R.id.textViewName)
        public TextView artistName;

        @BindView(R.id.imagePoster)
        public ImageView imgPoster;

        @BindView(R.id.relLayout1)
        public RelativeLayout mRelativeLayout;


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

            final RecentVisited recentVisited = recentVisiteds.get(position);

            if (recentVisited.getName() != null) {
                String name = recentVisited.getName();
                artistName.setText(name);
            }

            if (recentVisited.getPosterPath() != null) {
                String poster = "https://image.tmdb.org/t/p/w500" + recentVisited.getPosterPath();
                ImageLoader imageLoader = ImageLoader.getInstance();
                imageLoader.displayImage(poster, imgPoster);
            }

            Log.d(TAG, "onBind: ID ID -> " + recentVisited.getRecentVisiedID());

            mRelativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int type = recentVisited.getType();
                    long id;
                    if (type > -1) {
                        if (type == Config.MOVIE) {
                            id = recentVisited.getRecentVisiedID();

                            mOnImageSelectedListener.onMovieImageSelected(id);
                        } else if (type == Config.TV) {

                            id = recentVisited.getRecentVisiedID();
                            mOnImageSelectedListener.onTvImageSelected(id);

                        } else if (type == Config.ARTIST) {
                            id = recentVisited.getRecentVisiedID();
                            mOnImageSelectedListener.onArtistImageSelect(id);

                        }

                    }

                }
            });


        }
    }

}
