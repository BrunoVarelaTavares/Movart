package com.devwithbruno.www.movart.utils;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.devwithbruno.www.movart.BuildConfig;
import com.devwithbruno.www.movart.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bruno on 04/12/2017.
 */

public class PlayVideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, SlidingUpPanelLayout.PanelSlideListener {


    private static final String TAG = "PlayVideoActivity";

    String url;

    @BindView(R.id.youtube_view)
    public YouTubePlayerView youTubePlayerView;


    @BindView(R.id.tv_title)
    public TextView textViewTitle;


    @BindView(R.id.tw_overview)
    public TextView textViewOverview;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_play_activity);
        ButterKnife.bind(this);

        setupYoutubeVideo();
        youTubePlayerView.initialize(BuildConfig.YOUTUBE_API_TOKEN, this);


    }






    private void setupYoutubeVideo() {
        Intent intent = getIntent();
        url = "";
        if (intent.hasExtra(String.valueOf(R.string.movie_youtube_id))) {
            url = intent.getStringExtra(String.valueOf(R.string.movie_youtube_id));
            //  textView1.setText(as);
        }

        if (intent.hasExtra("title")) {
            String title = intent.getExtras().getString("title");
            textViewTitle.setText(title);

        }
        if (intent.hasExtra("overview")){

            String overview = intent.getExtras().getString("overview");
            textViewOverview.setText(overview);


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






    }

    @Override
    public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {









    }
}
