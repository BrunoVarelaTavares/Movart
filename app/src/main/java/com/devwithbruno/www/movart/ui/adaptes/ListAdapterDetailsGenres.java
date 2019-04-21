package com.devwithbruno.www.movart.ui.adaptes;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.network.api.ApiCalls;
import com.devwithbruno.www.movart.data.model.Genre;
import com.devwithbruno.www.movart.ui.details.DetailsActivity;
import com.devwithbruno.www.movart.utils.GenreListFragment;

import java.util.List;

/**
 * Created by Bruno on 28/11/2017.
 */

public class ListAdapterDetailsGenres extends RecyclerView.Adapter<ListAdapterDetailsGenres.MyViewHolder> {

    private static final String TAG = "MoviesAdapter";

    private Context mContext;
    private List<Genre> genreList;
    private ApiCalls apiCalls;

    public ListAdapterDetailsGenres(Context mContext, List<Genre> genreList) {
        this.mContext = mContext;
        this.genreList = genreList;
        apiCalls = new ApiCalls();
    }

    @Override
    public ListAdapterDetailsGenres.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_details_genres_card,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
       final String genre = genreList.get(position).getName();
       final long genreID = genreList.get(position).getId();
       final String genreName = genreList.get(position).getName();

        holder.genre.setText(genre);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                GenreListFragment listFragment = new GenreListFragment();
                FragmentTransaction transaction = ((DetailsActivity) mContext).getSupportFragmentManager().beginTransaction();
                args.putLong("genre_id", genreID);
                args.putString("genre_name", genreName);

                listFragment.setArguments(args);
                ((DetailsActivity)mContext).hideLayout();
//                transaction.setCustomAnimations(R.anim.slide_in_left,
//                        R.anim.slide_out_left,
//                        R.anim.slide_in_right,
//                        R.anim.slide_out_right);
                transaction.replace(R.id.container, listFragment);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });




       // apiCalls.getTv(mContext,movieID,holder.imgPoster);



    }

    @Override
    public int getItemCount() {
        return genreList.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView genre;
        public RelativeLayout relativeLayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            genre = (TextView) itemView.findViewById(R.id.tv_genre);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relLayout1);


        }
    }


}
