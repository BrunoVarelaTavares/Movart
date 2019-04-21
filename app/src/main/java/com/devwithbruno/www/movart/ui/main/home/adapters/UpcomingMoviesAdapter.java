package com.devwithbruno.www.movart.ui.main.home.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.Watchlist;
import com.devwithbruno.www.movart.ui.base.BaseActivity;
import com.devwithbruno.www.movart.ui.base.BaseViewHolder;
import com.devwithbruno.www.movart.ui.main.home.HomeMvpInteractor;
import com.devwithbruno.www.movart.ui.main.home.HomeMvpView;
import com.devwithbruno.www.movart.utils.DateFormatter;
import com.devwithbruno.www.movart.utils.GeneralConfig;
import com.devwithbruno.www.movart.utils.ImageAnimation;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bruno on 23/01/2018.
 */

public class UpcomingMoviesAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    List<Movie> mMovieList;
    List<String> urlUrl;

    public interface  OnImageSelectedListener{
        void onUpMovieImageSelect(List<Movie>  movieList, Movie movie, String position);
        void onAddToWatchlist(Watchlist watchlist);
        void removeFromWatchlist(Watchlist watchlist);
        boolean isOnWatchlist(Movie movie);
    }

    public OnImageSelectedListener mOnImageSelectedListener;



    public UpcomingMoviesAdapter(List<Movie> movieList) {
        this.mMovieList = movieList;
        urlUrl = new ArrayList<>();

    }

    public void setmOnImageSelectedListener(OnImageSelectedListener mOnImageSelectedListener) {
        this.mOnImageSelectedListener = mOnImageSelectedListener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_home_list_trailers, parent, false);
        return new MyViewHolder(view);
    }

    public void addMovies(List<Movie> movieList) {
        this.mMovieList.addAll(movieList);
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }



    public class MyViewHolder extends BaseViewHolder {




        @Inject
        public UpcomingAdapterMvpPresenter<HomeMvpView, HomeMvpInteractor> mUpcomingPresenter;

        @BindView(R.id.tvName)
        public TextView movieTitle;


        @BindView(R.id.tvReleaseDate)
        public TextView relaseDate;


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

            final Movie movie = mMovieList.get(position);

            if (movie.getTitle() != null){
                movieTitle.setText(movie.getTitle());
            }

            if (movie.getRelease_date() != null){
                String releaseDate = "Release Date: " + DateFormatter.getDateFullMonthName(movie.getRelease_date());
                relaseDate.setText(releaseDate);
            }

            if (movie.getPoster_path() != null){
                String poster = "https://image.tmdb.org/t/p/w500" + movie.getPoster_path();
                ImageLoader imageLoader = ImageLoader.getInstance();
                imageLoader.displayImage(poster, imgPoster);
            }

            if (movie.getId() != -1){
                mUpcomingPresenter.getMovieImageTrailers(movie.getId(), imgPosterYoutubeVideo);

            }

            ImageAnimation.unCheckImage(imageViewBookMarkGreen,
                    imageViewCheck, imageViewBookMark, imageViewAdd);



            if (mOnImageSelectedListener.isOnWatchlist(movie)) {
                ImageAnimation.checkImage(imageViewBookMark, imageViewAdd,
                        imageViewBookMarkGreen, imageViewCheck);

                imageViewBookMarkGreen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ImageAnimation.unCheckImage(imageViewBookMarkGreen,
                                imageViewCheck, imageViewBookMark, imageViewAdd);
                        mOnImageSelectedListener.removeFromWatchlist(GeneralConfig.movieToWatchlist(movie));
                    }
                });
            } else {

                imageViewBookMark.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        ImageAnimation.checkImage(imageViewBookMark, imageViewAdd,
                                imageViewBookMarkGreen, imageViewCheck);
                        mOnImageSelectedListener.onAddToWatchlist(GeneralConfig.movieToWatchlist(movie));
                    }
                });

            }




            imgPosterYoutubeVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String positionTamanho = (position + 1) + " de " + mMovieList.size();
                    if (movie.getId() != -1)
                    mOnImageSelectedListener.onUpMovieImageSelect(mMovieList, movie,positionTamanho);


                }
            });

        }

    }



    public void clearData(){
        mMovieList.clear();
        notifyDataSetChanged();
    }



}
