package com.devwithbruno.www.movart.utils;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.ui.artistsdetails.ArtistsActivity;
import com.devwithbruno.www.movart.ui.details.DetailsActivity;

/**
 * Created by Bruno on 19/12/2017.
 */

public class FilmographyListFragment extends Fragment {

    private static final String TAG = "FilmographyListFragment";

    private ListView listView;
    private long artistID;
    private Context mContext;
    private ImageView mBackArrow;

    String[] stringsList = {"Movies", "Tv"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filmography_list, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        mBackArrow = (ImageView) view.findViewById(R.id.backArrow);
        mContext = getActivity();

        Bundle bundle = getArguments();
        if (bundle != null) {
            artistID = bundle.getLong("artist_id");

        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.layout_filmography_list_card, R.id.tv_text, stringsList);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String name = stringsList[position];
                if (position == 0) {
                    onItemSelectMovies(name);
                }
                if (position == 1) {
                   onItemSelectTv(name);
                }

            }
        });


        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mContext instanceof DetailsActivity) {
                    ((DetailsActivity) mContext).showLayout();
                    getActivity().getSupportFragmentManager().popBackStack();
                } else if (mContext instanceof ArtistsActivity) {
                    ((ArtistsActivity) mContext).showLayout();
                    getActivity().getSupportFragmentManager().popBackStack();
                }


            }
        });

        return view;
    }


    private void onItemSelectMovies(String name) {
        if (artistID != -1) {
            ArtistListFragment artistListFragment = new ArtistListFragment();
            Bundle args = new Bundle();
            args.putLong("artist_id_movies", artistID);
            args.putString("item_name", name);
            artistListFragment.setArguments(args);
            FragmentTransaction transaction = ((ArtistsActivity) mContext).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, artistListFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }

    private void onItemSelectTv(String name) {
        if (artistID != -1) {
            ArtistListFragment artistListFragment = new ArtistListFragment();
            Bundle args = new Bundle();
            args.putLong("artist_id_tv", artistID);
            args.putString("item_name", name);
            artistListFragment.setArguments(args);
            FragmentTransaction transaction = ((ArtistsActivity) mContext).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, artistListFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }






    }










}