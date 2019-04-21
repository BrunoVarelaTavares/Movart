package com.devwithbruno.www.movart.ui.main.movies.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.ui.base.BaseActivity;
import com.devwithbruno.www.movart.ui.base.BaseViewHolder;
import com.devwithbruno.www.movart.ui.main.movies.MoviesMvpInteractor;
import com.devwithbruno.www.movart.ui.main.movies.MoviesMvpView;
import com.devwithbruno.www.movart.utils.ImageAnimation;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bruno on 22/01/2018.
 */

public class MoviesPopularMoviesAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    List<Movie> mMovieList;

    public interface  OnImageSelectedListener{
        void onPopularMoviesImageSelect(List<Movie>  movieList, Movie movie, String position);
    }

    public OnImageSelectedListener mOnImageSelectedListener;



    public MoviesPopularMoviesAdapter(List<Movie> movieList) {
        this.mMovieList = movieList;

    }

    public void setmOnImageSelectedListener(OnImageSelectedListener mOnImageSelectedListener) {
        this.mOnImageSelectedListener = mOnImageSelectedListener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_home_list_trailers, parent, false);
        return new MoviesPopularMoviesAdapter.MyViewHolder(view);
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
        public MoviesPopularMoviesAdapterMvpPresenter <MoviesMvpView, MoviesMvpInteractor> mPresenter;

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

//            if (movie.getRelease_date() != null){
//                String releaseDate = "Release Date: " + DateFormatter.getDateFullMonthName(movie.getRelease_date());
//                relaseDate.setText(releaseDate);
//            }

            if (movie.getPoster_path() != null){
                String poster = "https://image.tmdb.org/t/p/w500" + movie.getPoster_path();
                ImageLoader imageLoader = ImageLoader.getInstance();
                imageLoader.displayImage(poster, imgPoster);
            }

            if (movie.getId() != -1){
                mPresenter.getMovieImageTrailers(movie.getId(), imgPosterYoutubeVideo);

            }

            imgPosterYoutubeVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String positionTamanho = (position + 1) + " de " + mMovieList.size();
                    if (movie.getId() != -1)
                        mOnImageSelectedListener.onPopularMoviesImageSelect(mMovieList, movie,positionTamanho);


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
