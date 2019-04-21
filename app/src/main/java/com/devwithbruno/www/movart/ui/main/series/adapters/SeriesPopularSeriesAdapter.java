package com.devwithbruno.www.movart.ui.main.series.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.ui.base.BaseActivity;
import com.devwithbruno.www.movart.ui.base.BaseViewHolder;
import com.devwithbruno.www.movart.ui.main.series.SeriesMvpInteractor;
import com.devwithbruno.www.movart.ui.main.series.SeriesMvpView;
import com.devwithbruno.www.movart.utils.ImageAnimation;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bruno on 22/01/2018.
 */

public class SeriesPopularSeriesAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    List<Tv> mTvList;

    public interface  OnImageSelectedListener{
        void onPopularSeriesImageSelect(List<Tv> tvList, Tv tv, String position);
    }

    public OnImageSelectedListener mOnImageSelectedListener;



    public SeriesPopularSeriesAdapter(List<Tv> tvList) {
        this.mTvList = tvList;

    }

    public void setOnImageSelectedListener(OnImageSelectedListener mOnImageSelectedListener) {
        this.mOnImageSelectedListener = mOnImageSelectedListener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_home_list_trailers, parent, false);
        return new SeriesPopularSeriesAdapter.MyViewHolder(view);
    }

    public void addSeries(List<Tv> tvList) {
        this.mTvList.addAll(tvList);
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mTvList.size();
    }



    public class MyViewHolder extends BaseViewHolder {


        @Inject
        public SeriesPopularSeriesAdapterMvpPresenter <SeriesMvpView, SeriesMvpInteractor> mPresenter;

        @BindView(R.id.tvName)
        public TextView tvTitle;


        @BindView(R.id.imagePoster)
        public ImageView imgPoster;

        @BindView(R.id.iv_youtube_poster)
        public ImageView  imgPosterYoutubeVideo;

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
            ((BaseActivity)itemView.getContext()).getActivityComponent().inject(this);


        }

        @Override
        protected void clear() {

        }

        @Override
        public void onBind(final int position) {
            super.onBind(position);

            final Tv tv = mTvList.get(position);

            if (tv.getName() != null){
                tvTitle.setText(tv.getName());
            }


            if (tv.getPosterPath() != null){
                String poster = "https://image.tmdb.org/t/p/w500" + tv.getPosterPath();
                ImageLoader imageLoader = ImageLoader.getInstance();
                imageLoader.displayImage(poster, imgPoster);
            }

            if (tv.getId() != -1){
                mPresenter.getSerieImageTrailer(tv.getId(), imgPosterYoutubeVideo);

            }

            imgPosterYoutubeVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String positionTamanho = (position + 1) + " de " + mTvList.size();
                    if (tv.getId() != -1)
                        mOnImageSelectedListener.onPopularSeriesImageSelect(mTvList, tv,positionTamanho);


                }
            });




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


        }

    }


}
