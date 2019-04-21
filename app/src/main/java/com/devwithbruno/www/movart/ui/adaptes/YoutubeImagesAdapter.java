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
import com.devwithbruno.www.movart.data.model.Movie;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Bruno on 28/11/2017.
 */

public class YoutubeImagesAdapter extends RecyclerView.Adapter<YoutubeImagesAdapter.MyYoutubeHolder> {

    private static final String TAG = "YoutubeImagesAdapter";

    private Context mContext;
    private List<Movie> movieList;

    private ApiCalls apiCalls;


    public YoutubeImagesAdapter(Context mContext, List<Movie> movieList) {
        this.mContext = mContext;
        this.movieList = movieList;

        this.apiCalls = new ApiCalls();

    }

    @Override
    public MyYoutubeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_list_trailers, parent, false);

        return new MyYoutubeHolder(view);
    }


    @Override
    public void onBindViewHolder(final MyYoutubeHolder holder, final int position) {
        String vote = movieList.get(position).getTitle();
        String releaseDate = "Release Date " + movieList.get(position).getRelease_date();
        String poster = "https://image.tmdb.org/t/p/w500" + movieList.get(position).getPoster_path();

        apiCalls.getTrailers(mContext,movieList,position,holder.imgPosterYoutubeVideo,holder.imgPosterYoutubeVideo);

//        final Movie  movie = movieList.get(position);
//
//        final String positionTamanho = (position+1) + " de "  + movieList.size();
//
//
//        Client client = new Client();
//        MoviesService apiService = client.getClient().create(MoviesService.class);
//        Observable<TrailerResponse> observable = apiService.getMovieTrailer(movieList.get(position).getId(), BuildConfig.THE_MOVIE_DB_API_TOKEN)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread());
//        observable.subscribe(new Observer<TrailerResponse>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(TrailerResponse trailerResponse) {
//                final List<Trailer> trailers = trailerResponse.getResult();
//                StringBuilder urlsVideo = new StringBuilder();
//                urlsVideo.append("https://img.youtube.com/vi/");
//                if (trailers.size() >= 0) {
//                    if (trailers.get(0).getKey() != null) {
//                        urlsVideo.append(trailers.get(0).getKey());
//                    } else if (trailers.get(1).getKey() != null) {
//                        urlsVideo.append(trailers.get(1).getKey());
//                    }
//                } else {
//                    urlsVideo.append("");
//                }
//
//
//
//                urlsVideo.append("/0.jpg");
//                String urls = urlsVideo.toString();
//
//
//                ImageLoader imageLoader = ImageLoader.getInstance();
//                imageLoader.displayImage(urls, holder.imgPosterYoutubeVideo);
//
//
//                holder.imgPosterYoutubeVideo.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (trailers.size() >= 0) {
//                            Intent intent = new Intent(mContext, VideoActivity.class);
//                            intent.putExtra(String.valueOf(R.string.movie_youtube_id), trailers.get(0).getKey());
//                            intent.putExtra("movie_extra", movie);
//                            intent.putExtra("position", positionTamanho);
//                            intent.putParcelableArrayListExtra(String.valueOf(R.string.upcoming_movies_extra), (ArrayList<? extends Parcelable>) movieList);
//
//                            mContext.startActivity(intent);
//                        }
//                    }
//                });





//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//
//            }
//        });


        holder.relaseDate.setText(releaseDate);
        holder.movieTitle.setText(vote);


        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(poster, holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public class MyYoutubeHolder extends RecyclerView.ViewHolder {

        public TextView movieTitle, relaseDate;
        public ImageView imgPoster, imgPosterYoutubeVideo;



        public MyYoutubeHolder(View itemView) {
            super(itemView);
            movieTitle = (TextView) itemView.findViewById(R.id.tvName);
            relaseDate = (TextView) itemView.findViewById(R.id.tvReleaseDate);
            imgPoster = (ImageView) itemView.findViewById(R.id.imagePoster);
            imgPosterYoutubeVideo = (ImageView) itemView.findViewById(R.id.iv_youtube_poster);


        }
    }


}
