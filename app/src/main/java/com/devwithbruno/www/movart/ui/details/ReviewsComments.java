package com.devwithbruno.www.movart.ui.details;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;


public class ReviewsComments extends Fragment {

    private Context mContext;


    private TextView textViewAuthor, textViewContent;
    private ImageView mBackArrow;


    public ReviewsComments() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reviews_comments, container, false);
        mContext = getActivity();
        textViewAuthor = (TextView) view.findViewById(R.id.tv_author);
        textViewContent = (TextView) view.findViewById(R.id.tv_content);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String author = bundle.getString("author_name");
            String content = bundle.getString("reviews_content");
            textViewAuthor.setText(author);
            textViewContent.setText(content);
//            ListAdapterCrew listAdapter = new ListAdapterCrew(mContext,R.layout.layout_item_list, crew);
//            mListView.setAdapter(listAdapter);
        }


        mBackArrow = (ImageView) view.findViewById(R.id.backArrow);
        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((DetailsActivity) mContext).showLayout();

                getActivity().getSupportFragmentManager().popBackStack();

            }
        });


        return view;
    }


}
