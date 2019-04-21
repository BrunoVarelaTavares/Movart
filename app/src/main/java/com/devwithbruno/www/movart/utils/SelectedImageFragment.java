package com.devwithbruno.www.movart.utils;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Image;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Bruno on 19/12/2017.
 */

public class SelectedImageFragment extends Fragment {


    private ImageView imageView, mBackArrow;

    private static final String TAG = "SelectedImageFragment";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_selected, container, false);
        imageView = (ImageView)view.findViewById(R.id.img);
        mBackArrow = (ImageView) view.findViewById(R.id.backArrow);

        Bundle bundle = getArguments();
        if (bundle != null){
          Image image =  bundle.getParcelable("image_selected");
            String poster = "https://image.tmdb.org/t/p/w500" + image.getFile_path();

            Log.d(TAG, "onCreateView: DIAA" +  poster);


            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(poster, imageView);


        }

        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();

            }
        });


        return view;
    }
}
