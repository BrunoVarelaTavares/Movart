package com.devwithbruno.www.movart.utils;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
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
import com.devwithbruno.www.movart.ui.adaptes.GenreMoviesAdapter;
import com.devwithbruno.www.movart.ui.details.DetailsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 16/12/2017.
 */

public class GenreListFragment extends Fragment {

    private static final String TAG = "GenreListFragment";

    RecyclerView recyclerView;
    List<Movie> movieList;
    GenreMoviesAdapter genreMoviesAdapter;
    ApiCalls apiCalls;
    private Context mContext;
    private TextView textViewGenreName;
    private ImageView mBackArrow;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_genre, container, false);
        mContext = getActivity();
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view_list_genre_list);
        textViewGenreName = (TextView)view.findViewById(R.id.tv_top_name);
        mBackArrow = (ImageView) view.findViewById(R.id.backArrow);
        movieList = new ArrayList<>();
        apiCalls = new ApiCalls();
        init();







        return view;
    }


    public void init(){
        //From ListAdapterDetailsGenres
        Bundle bundle = getArguments();
        if (bundle != null){
            String genreName = bundle.getString("genre_name");
            long genreID = bundle.getLong("genre_id");
            genreMoviesAdapter = new GenreMoviesAdapter(mContext,movieList);
            setupRecyclerview(genreMoviesAdapter, recyclerView);
            if (genreName != null){
                textViewGenreName.setText(genreName);
            }
            apiCalls.getMoviesByGenre(mContext,genreID, recyclerView);

        }




        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mContext instanceof DetailsActivity) {
                    ((DetailsActivity) mContext).showLayout();
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });

    }





    public void setupRecyclerview(RecyclerView.Adapter adapter, RecyclerView recyclerView) {
        Log.d(TAG, "setupRecyclerview: ");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();

    }
}
