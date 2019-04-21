package com.devwithbruno.www.movart.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Image;
import com.devwithbruno.www.movart.ui.artistsdetails.ArtistsActivity;
import com.devwithbruno.www.movart.ui.details.DetailsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 19/12/2017.
 */

public class GridImagesFragment extends Fragment {

    public interface OnGridImageSelectedListener {
        void onGridImageSelected(Image image);
    }

    OnGridImageSelectedListener mOnGridImageSelectedListener;


    private static final String TAG = "GridImagesFragment";
    private static final int NUM_GRID_COLUMNS = 3;


    private GridView gridView;
    private ImageView mBackArrow;
    boolean isDoneOnce = false;
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        try {
            mOnGridImageSelectedListener = (OnGridImageSelectedListener) getActivity();
        } catch (ClassCastException e) {
            Log.d(TAG, "onAttach: ClassCastException: " + e.getMessage());

        }
        super.onAttach(context);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid_images, container, false);
        gridView = (GridView) view.findViewById(R.id.gridView);
        mBackArrow = (ImageView) view.findViewById(R.id.backArrow);
        mContext = getActivity();
        init();

        return view;
    }


    private void init() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            final List<Image> images = bundle.getParcelableArrayList("artists_images");
            int gridWidth = getResources().getDisplayMetrics().widthPixels;
            int imageWidth = gridWidth / NUM_GRID_COLUMNS;
            gridView.setColumnWidth(imageWidth);
            ArrayList<String> imgUrls = new ArrayList<String>();
            for (int i = 0; i < images.size(); i++) {
                Log.d(TAG, "onDataChange:  Images path " + images.get(i).getFile_path());
                imgUrls.add(images.get(i).getFile_path());
            }
            String poster = "https://image.tmdb.org/t/p/w300";
            GridImageAdapter adapter = new GridImageAdapter(getActivity(), R.layout.layout_grid_image_card, poster, imgUrls);
            gridView.setAdapter(adapter);


            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    mOnGridImageSelectedListener.onGridImageSelected(images.get(position));


                }
            });

        }

        setupOnClickImageDetailsActivity();

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

    }


    private void setupOnClickImageDetailsActivity() {
        if (!isDoneOnce) {
            try {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Bundle bundle = getArguments();
                        if (bundle.containsKey("image_position")) {
                            final List<Image> images = bundle.getParcelableArrayList("artists_images");
                            int position = bundle.getInt("image_position");
                            mOnGridImageSelectedListener.onGridImageSelected(images.get(position));
                        }
                    }
                }, 300);
            } catch (Exception e) {

            }
            isDoneOnce = true;

        }


    }


    @Override
    public void onResume() {
        super.onResume();


    }
}
