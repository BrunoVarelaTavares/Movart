package com.devwithbruno.www.movart.ui.video;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.devwithbruno.www.movart.BuildConfig;
import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.network.api.ApiCalls;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.ui.adaptes.SlideUpAdapter;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bruno on 04/12/2017.
 */

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, SlidingUpPanelLayout.PanelSlideListener {


    private static final String TAG = "VideoActivity";


    String url;

    @BindView(R.id.youtube_view)
    public YouTubePlayerView youTubePlayerView;


    @BindView(R.id.tv_title)
    public TextView textViewTitle;


    @BindView(R.id.tw_overview)
    public TextView textViewOverview;

    @BindView(R.id.iw_number)
    public TextView textViewPosition;


    @BindView(R.id.iw_arrow_down)
    public ImageView imageViewArrowDown;

    @BindView(R.id.iw_arrow_up)
    public ImageView imageViewArrowUp;


    @BindView(R.id.sliding_layout)
    public SlidingUpPanelLayout slidingLayout;



    private List<Movie> movieList;
    public RecyclerView recyclerView;
    private SlideUpAdapter  slideUpAdapter;
    private Context mContext;
    private ApiCalls apiCalls;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        mContext = this;
        apiCalls = new ApiCalls();

        slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        slidingLayout.addPanelSlideListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_slide_up);

        init();


        setupYoutubeVideo();


        youTubePlayerView.initialize(BuildConfig.YOUTUBE_API_TOKEN, this);


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void setupRecyclerview(RecyclerView.Adapter adapter, RecyclerView recyclerView){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();

    }

    public void init(){

        movieList = new ArrayList<>();
        slideUpAdapter = new SlideUpAdapter(mContext, movieList);
        setupRecyclerview(slideUpAdapter,recyclerView);


        apiCalls.getUpcomingMoviesSlide(mContext, recyclerView);

    }

    @Override
    protected void onDestroy() {
        movieList.clear();
        super.onDestroy();
    }



    private void setupYoutubeVideo() {
        Intent intent = getIntent();
        url = "";
        if (intent.hasExtra(String.valueOf(R.string.movie_youtube_id))) {
            url = intent.getStringExtra(String.valueOf(R.string.movie_youtube_id));
        }

        if (intent.hasExtra(String.valueOf(R.string.upcoming_movies_extra))) {
            ArrayList<Movie> ss = intent.getParcelableArrayListExtra(String.valueOf(R.string.upcoming_movies_extra));
            for (int i = 0; i < ss.size(); i++) {
                Log.d(TAG, "setupYoutubeVideo: MESMO" +  ss.get(i));

            }


        }





        if (intent.hasExtra("movie_extra")) {
            Log.d(TAG, "setupYoutubeVideo: " + intent.hasExtra("movie_extra"));

            Movie movie = intent.getExtras().getParcelable("movie_extra");

            String title = movie.getTitle();
            textViewTitle.setText(title);

            String overview = movie.getOverview();
            textViewOverview.setText(overview);
        }

        if (intent.hasExtra("position")) {
            String p = intent.getStringExtra("position");
            textViewPosition.setText(p);
        }







    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b) {
            youTubePlayer.loadVideo(url);
            youTubePlayer.play();
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Log.d(TAG, "onInitializationFailure: BBB");
    }


    @Override
    public void onPanelSlide(View panel, float slideOffset) {

        imageViewArrowDown.setAlpha(slideOffset);




    }

    @Override
    public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
        if (slidingLayout.getPanelState().equals(SlidingUpPanelLayout.PanelState.DRAGGING)){
            if (imageViewArrowDown.getVisibility() == View.GONE){
                imageViewArrowUp.setVisibility(View.GONE);
                imageViewArrowDown.setVisibility(View.VISIBLE);

            }else if (imageViewArrowDown.getVisibility() == View.VISIBLE){
                imageViewArrowDown.setVisibility(View.GONE);
                imageViewArrowUp.setVisibility(View.VISIBLE);



            }

        }













    }
}
