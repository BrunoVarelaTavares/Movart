package com.devwithbruno.www.movart.ui.adaptes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private static final String TAG = "MoviesAdapter";

    private Context mContext;
    private List<Movie> movieList;
    private ApiCalls apiCalls;


    public MoviesAdapter(Context mContext, List<Movie> movieList) {
        this.mContext = mContext;
        this.movieList = movieList;
        apiCalls = new ApiCalls();
    }

    @Override
    public MoviesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_movie_card,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
       String vote = Double.toString(movieList.get(position).getVote_average());
       holder.rating.setText(vote);
       final long movieID = movieList.get(position).getId();

        String poster = "https://image.tmdb.org/t/p/w500" + movieList.get(position).getPoster_path();

        Log.d(TAG, "onBindViewHolder: "  + poster);

        apiCalls.getMovie(mContext,movieID,holder.imgPoster);


        holder.imageViewBookMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.imageViewBookMark.getVisibility() == View.VISIBLE) {
                    holder.imageViewBookMark.setVisibility(View.GONE);
                    holder.imageViewAdd.setVisibility(View.GONE);
                    holder.imageViewBookMarkGreen.setVisibility(View.VISIBLE);
                    holder.imageViewCheck.setVisibility(View.VISIBLE);
                }

            }
        });


        holder.imageViewBookMarkGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (holder.imageViewBookMarkGreen.getVisibility() == View.VISIBLE){
                    holder.imageViewBookMark.setVisibility(View.VISIBLE);
                    holder.imageViewAdd.setVisibility(View.VISIBLE);
                    holder.imageViewBookMarkGreen.setVisibility(View.GONE);
                    holder.imageViewCheck.setVisibility(View.GONE);


                }
            }
        });







//        holder.imgPoster.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(mContext, DetailsActivity.class);
//                intent.putExtra("movie_extra", movieID);
//                mContext.startActivity(intent);
//
//            }
//        });





        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(poster, holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView rating;
        public ImageView imgPoster, imageViewBookMark, imageViewBookMarkGreen,imageViewAdd,imageViewCheck;


        public MyViewHolder(View itemView) {
            super(itemView);
            rating = (TextView) itemView.findViewById(R.id.rating);
            imgPoster = (ImageView)itemView.findViewById(R.id.imagePoster);
            imageViewBookMark = (ImageView)itemView.findViewById(R.id.iv_bookmark);
            imageViewBookMarkGreen = (ImageView)itemView.findViewById(R.id.iv_bookmark_green);
            imageViewAdd = (ImageView)itemView.findViewById(R.id.iv_add);
            imageViewCheck = (ImageView)itemView.findViewById(R.id.iv_check);




        }
    }


}
