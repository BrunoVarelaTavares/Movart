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
import com.devwithbruno.www.movart.data.model.Tv;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Bruno on 28/11/2017.
 */

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.MyViewHolder> {

    private static final String TAG = "TvAdapter";

    private Context mContext;
    private ApiCalls apiCalls;
    private List<Tv> seriesList;
    private boolean as = false;

    public TvAdapter(Context mContext, List<Tv> seriesList) {
        this.mContext = mContext;
        this.seriesList = seriesList;
        apiCalls = new ApiCalls();
    }

    @Override
    public TvAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_movie_card,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
       String vote = Double.toString(seriesList.get(position).getVoteAverage());
       holder.rating.setText(vote);


       long id = seriesList.get(position).getId();

        String poster = "https://image.tmdb.org/t/p/w500" + seriesList.get(position).getPosterPath();

        Log.d(TAG, "onBindViewHolder: "  + poster);

        apiCalls.getTv(mContext,id, holder.imgPoster);

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(poster, holder.imgPoster);



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




//        holder.imageViewCheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////                if (!isCheck){
//                    Toast.makeText(mContext, "AASSS", Toast.LENGTH_LONG).show();
//                    holder.imageViewCheck.setVisibility(View.GONE);
//                    holder.imageViewAdd.setVisibility(View.GONE);
//                    holder.imageViewBookMarkGreen.setVisibility(View.VISIBLE);
//                    holder.imageViewCheck.setVisibility(View.VISIBLE);
//                    isCheck = true;
////                }else {
////                    holder.imageViewBookMarkGreen.setVisibility(View.GONE);
////                    holder.imageViewCheck.setVisibility(View.GONE);
////                    holder.imageViewCheck.setVisibility(View.VISIBLE);
////                    holder.imageViewAdd.setVisibility(View.VISIBLE);
////
////                    isCheck = false;
////
////                }
//
//            }
//        });







  //      Apagar e fazer como MovieAdapter
//        holder.imgPoster.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(mContext, "VAIA A A", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(mContext, ArtistsActivity.class);
//               // intent.putExtra("movie_extra", myMovie);
////
//                mContext.startActivity(intent);
//
//
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return seriesList.size();
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
