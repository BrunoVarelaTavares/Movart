package com.devwithbruno.www.movart.utils;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Crew;
import com.devwithbruno.www.movart.ui.adaptes.ListAdapterCrew;
import com.devwithbruno.www.movart.ui.details.DetailsActivity;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    private Context mContext;

    private ListView mListView;
    private TextView textViewTopName;
    private ImageView mBackArrow;




    public ListFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        mListView = (ListView) view.findViewById(R.id.listView);
        mContext = getActivity();
        textViewTopName = (TextView) view.findViewById(R.id.tv_top_name);
        mBackArrow = (ImageView) view.findViewById(R.id.backArrow);
        init();


        return view;
    }



    public void init(){
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.getParcelableArrayList("crew_list_directors") != null) {
                textViewTopName.setText("Directors credits");
                ArrayList<Crew> crew = bundle.getParcelableArrayList("crew_list_directors");
                ListAdapterCrew listAdapter = new ListAdapterCrew(mContext, R.layout.layout_item_list, crew);
                mListView.setAdapter(listAdapter);

            } else if (bundle.getParcelableArrayList("crew_list_writers") != null) {
                textViewTopName.setText("Writing credits");
                ArrayList<Crew> crew = bundle.getParcelableArrayList("crew_list_writers");
                ListAdapterCrew listAdapter = new ListAdapterCrew(mContext, R.layout.layout_item_list, crew);
                mListView.setAdapter(listAdapter);
            }


        }





        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((DetailsActivity)mContext).showLayout();
                getActivity().getSupportFragmentManager().popBackStack();

            }
        });




    }




















    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction();
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }


//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction();
//    }
}
