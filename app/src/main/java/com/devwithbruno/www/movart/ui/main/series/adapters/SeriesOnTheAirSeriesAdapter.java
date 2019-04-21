package com.devwithbruno.www.movart.ui.main.series.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.ui.base.BaseViewHolder;
import com.devwithbruno.www.movart.utils.ImageAnimation;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bruno on 22/01/2018.
 */

public class SeriesOnTheAirSeriesAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final String TAG = "SeriesOnTheAirSeriesAdapter";
    private List<Tv> mTvList;

    public interface  OnImageSelectedListener{
        void onImageOnTheAirSerieSelected(long tvId);
    }

    public  OnImageSelectedListener mOnImageSelectedListener;



    public SeriesOnTheAirSeriesAdapter(List<Tv> tvList) {
        this.mTvList = tvList;
    }


    public void setOnImageSelectedListener(OnImageSelectedListener mOnImageSelectedListener){
        this.mOnImageSelectedListener = mOnImageSelectedListener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_movie_card,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);

    }

    @Override
    public int getItemCount() {
        return mTvList.size();
    }


    public void addSeries(List<Tv> tvList) {
        this.mTvList.addAll(tvList);
        notifyDataSetChanged();
    }


    public class MyViewHolder extends BaseViewHolder{

        @BindView(R.id.rating)
        public TextView rating;

        @BindView(R.id.imagePoster)
        public ImageView  imgPoster;

        @BindView(R.id.iv_bookmark)
        public ImageView  imageViewBookMark;

        @BindView(R.id.iv_bookmark_green)
        public ImageView  imageViewBookMarkGreen;

        @BindView(R.id.iv_add)
        public ImageView  imageViewAdd;

        @BindView(R.id.iv_check)
        public ImageView  imageViewCheck;


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

            final Tv tv = mTvList.get(position);

            if (tv.getVoteAverage() != -1){
                String vote = Double.toString(tv.getVoteAverage());
                rating.setText(vote);
            }

            if (tv.getPosterPath()!= null){
                String poster = "https://image.tmdb.org/t/p/w500" + tv.getPosterPath();
                ImageLoader imageLoader = ImageLoader.getInstance();
                imageLoader.displayImage(poster, imgPoster);
            }

            imageViewBookMark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageAnimation.checkImage(imageViewBookMark, imageViewAdd,
                            imageViewBookMarkGreen, imageViewCheck);
                }
            });

            imageViewBookMarkGreen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageAnimation.unCheckImage(imageViewBookMarkGreen,
                            imageViewCheck, imageViewBookMark, imageViewAdd);
                }
            });


            imgPoster.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tv.getId() != -1 && mOnImageSelectedListener != null){
                        long tvId = tv.getId();
                        mOnImageSelectedListener.onImageOnTheAirSerieSelected(tvId);


                    }







                }
            });


        }
    }







}
