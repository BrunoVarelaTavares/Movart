package com.devwithbruno.www.movart.ui.adaptes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.network.api.ApiCalls;
import com.devwithbruno.www.movart.data.model.Movie;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Bruno on 28/11/2017.
 */

public class GenreMoviesAdapter extends RecyclerView.Adapter<GenreMoviesAdapter.MyViewHolder> {

    private static final String TAG = "GenreMoviesAdapter";

    private Context mContext;
    private List<Movie> movieList;
    private ApiCalls apiCalls;

    public GenreMoviesAdapter(Context mContext, List<Movie> movieList) {
        Log.d(TAG, "GenreMoviesAdapter: ");
        this.mContext = mContext;
        this.movieList = movieList;
        apiCalls = new ApiCalls();
    }

    @Override
    public GenreMoviesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_genre_list_card,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        String name = movieList.get(position).getTitle();
        String vote = Double.toString(movieList.get(position).getVote_average());
        Log.d(TAG, "onBindViewHolder: ");

       holder.textViewName.setText(name);
       holder.textViewVote.setText(vote);
       final long movieID = movieList.get(position).getId();

        String poster = "https://image.tmdb.org/t/p/w500" + movieList.get(position).getPoster_path();

        Log.d(TAG, "onBindViewHolder: "  + poster);

       apiCalls.getMovie(mContext,movieID,holder.relativeLayout);
       apiCalls.getCastForGenre(mContext,movieID, holder.textViewCast);






        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(poster, holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName,textViewCast, textViewVote;
        public ImageView imgPoster;
        public RelativeLayout relativeLayout;



        public MyViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "MyViewHolder: ");
            textViewName = (TextView) itemView.findViewById(R.id.tv_name);
            textViewCast = (TextView)itemView.findViewById(R.id.tv_cast);
            textViewVote = (TextView)itemView.findViewById(R.id.tv_vote);
            imgPoster = (ImageView)itemView.findViewById(R.id.iv_image_genre_list);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relLayout1);


        }
    }


}
