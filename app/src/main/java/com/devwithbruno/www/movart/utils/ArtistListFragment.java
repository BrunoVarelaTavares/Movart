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
import com.devwithbruno.www.movart.data.model.ArtistCast;
import com.devwithbruno.www.movart.ui.artistsdetails.ArtistsActivity;
import com.devwithbruno.www.movart.ui.adaptes.ArtistListAdapter;
import com.devwithbruno.www.movart.ui.details.DetailsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 16/12/2017.
 */

public class ArtistListFragment extends Fragment {

    private static final String TAG = "GenreListFragment";

    RecyclerView recyclerView;
    List<ArtistCast> artistCasts;
    ArtistListAdapter artistListAdapter;
    ApiCalls apiCalls;
    private Context mContext;
    private TextView textViewTopName;
    private ImageView mBackArrow;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_artist, container, false);
        mContext = getActivity();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_artist_list);
        textViewTopName = (TextView) view.findViewById(R.id.tv_top_name);
        mBackArrow = (ImageView) view.findViewById(R.id.backArrow);
        artistCasts = new ArrayList<>();
        apiCalls = new ApiCalls();
        init();


        return view;
    }


    private void init() {
        //From ListAdapterDetailsGenres
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey("artist_id_movies")) {
                long artist_id = bundle.getLong("artist_id_movies");
                String name = bundle.getString("item_name");
                artistListAdapter = new ArtistListAdapter(mContext, artistCasts);
                setupRecyclerview(artistListAdapter, recyclerView);
                if (name != null) {
                    textViewTopName.setText(name);
                }
                apiCalls.getArtistMovieCast(mContext, artist_id, recyclerView);

            } else if (bundle.containsKey("artist_id_tv")) {
                    long artist_id = bundle.getLong("artist_id_tv");
                    String name = bundle.getString("item_name");
                    artistListAdapter = new ArtistListAdapter(mContext, artistCasts);
                    setupRecyclerview(artistListAdapter, recyclerView);
                    if (name != null) {
                        textViewTopName.setText(name);
                    }
                    apiCalls.getArtistTVCast(mContext, artist_id, recyclerView);


            }
        }


        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mContext instanceof DetailsActivity) {
                    getActivity().getSupportFragmentManager().popBackStack();
                } else if (mContext instanceof ArtistsActivity) {
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
