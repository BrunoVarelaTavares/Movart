package com.devwithbruno.www.movart.ui.profil;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.RecentVisited;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.ui.artistsdetails.ArtistsActivity;
import com.devwithbruno.www.movart.ui.base.BaseActivity;
import com.devwithbruno.www.movart.ui.details.DetailsActivity;
import com.devwithbruno.www.movart.ui.profil.favourite.FavoritesFragment;
import com.devwithbruno.www.movart.ui.profil.lists.ListsFragment;
import com.devwithbruno.www.movart.ui.profil.rating.RatingsFragment;
import com.devwithbruno.www.movart.ui.profil.watchlist.WatchlistFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends BaseActivity implements ProfileMvpView,RecentVisitedAdapter.OnImageSelectedListener {


    List<RecentVisited> recentVisitedList;


    @Inject
    ProfileMvpPresenter<ProfileMvpView, ProfileMvpInteractor> mPresenter;

    @Inject
    public RecentVisitedAdapter mRecentVisitedAdapter;

    @BindView(R.id.backArrow)
    public ImageView imageViewBackArrow;

    @BindView(R.id.imageViewBackgroundWatchlist)
    public ImageView imageViewBackgroundWatchlist;

    @BindView(R.id.imageViewBackgroundFavorites)
    public ImageView imageViewBackgroundFavorites;

    @BindView(R.id.imageViewBackgroundLists)
    public ImageView imageViewBackgroundList;

    @BindView(R.id.imageViewBackgroundRatings)
    public ImageView imageViewBackgroundRatings;

//    @BindView(R.id.container)
//    public FrameLayout mFrameLayout;

//    @BindView(R.id.relLayout1)
//    public RelativeLayout mRelativeLayout;

    @BindView(R.id.recycler_view_visited_items)
    public RecyclerView mRecyclerViewRecentVisited;

    @BindView(R.id.textViewClear)
    public TextView textViewClearHistory;

    @BindView(R.id.textViewNoRecentHistory)
    public TextView textViewNoRecentHistory;


    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, ProfileActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        mRecentVisitedAdapter.setOnImageSelectedListener(this);

        setUp();

    }

    @OnClick(R.id.backArrow) void onBackArrowClick(){
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @OnClick(R.id.textViewClear) void onClearHistoryClick(){
        //Fazer dialog box
        mPresenter.clearVisitedHistory();
        mRecentVisitedAdapter.clearData();
        textViewClearHistory.setVisibility(View.GONE);
        textViewNoRecentHistory.setVisibility(View.VISIBLE);
    }


    private static final String TAG = "ProfileActivity";
    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed: ");
       // super.onBackPressed();
//        FragmentManager manager = getSupportFragmentManager();
//        if (mFrameLayout.getVisibility() == View.VISIBLE && manager.getBackStackEntryCount() == 0){
         //   showProfileLayout();
//        }else {
//            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(WatchlistFragment.TAG);
        if (fragment == null){
            Log.d(TAG, "onBackPressed: IF ");
            super.onBackPressed();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }else {
            Log.d(TAG, "onBackPressed: ELSE ");
            onFragmentDetached(WatchlistFragment.TAG);
          //  showProfileLayout();
        }



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


    @Override
    public void onFragmentAttached() {
        Log.d(TAG, "onFragmentAttached: ");

    }

    @Override
    protected void setUp() {
        recentVisitedList = new ArrayList<>();
        setupRecyclerview(mRecentVisitedAdapter,mRecyclerViewRecentVisited);


        // Tirar isto daqui esta mal
        List<RecentVisited>  recentVisited = mPresenter.getAllRecentVisited();
        if (recentVisited.size() > 0){
            textViewNoRecentHistory.setVisibility(View.GONE);
            textViewClearHistory.setVisibility(View.VISIBLE);
        }

        mRecentVisitedAdapter.addRecentVisited(recentVisited);

    }






    @Override
    public void showFavoriteFragment() {
      //  hideProfileLayout();
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.container, FavoritesFragment.newInstance(), FavoritesFragment.TAG)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showListsFragment() {
      //  hideProfileLayout();
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.container, ListsFragment.newInstance(), ListsFragment.TAG)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showRatingFragment() {
       // hideProfileLayout();
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.container, RatingsFragment.newInstance(), RatingsFragment.TAG)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showWatchlistFragment() {
        Log.d(TAG, "showWatchlistFragment: ");
      // hideProfileLayout();
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .add(R.id.container, WatchlistFragment.newInstance(), WatchlistFragment.TAG)
                .commit();
    }

    @Override
    public void hideProfileLayout() {
       // mRelativeLayout.setVisibility(View.GONE);
      //  mFrameLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProfileLayout() {
        //mRelativeLayout.setVisibility(View.VISIBLE);
      //  mFrameLayout.setVisibility(View.GONE);
    }

    @Override
    public void openTvDetailsOnDetailsActivity(Tv tv) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("tv_extra", tv);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void openMovieDetailsOnDetailsActivity(Movie movie) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("movie_extra", movie);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


    }

    @Override
    public void openArtistDetails(Artist artist) {
        Intent intent = new Intent(this, ArtistsActivity.class);
        intent.putExtra("artist_extra", artist);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @OnClick(R.id.imageViewBackgroundFavorites) void onFavoritesImageClick(){
        mPresenter.openFavoritesFragment();
    }

    @OnClick(R.id.imageViewBackgroundRatings) void onRatingsImageClick(){
        mPresenter.openRatingsFragment();
    }

    @OnClick(R.id.imageViewBackgroundLists) void onListsImageClick(){
        mPresenter.openListsFragment();
    }

    @OnClick(R.id.imageViewBackgroundWatchlist) void onWatchlistImageClick(){
        mPresenter.openWatchlistFragment();
    }

    @Override
    public void onFragmentDetached(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null){
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                    .remove(fragment)
                    .commitNow();
        }
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onArtistImageSelect(long artistID) {
        mPresenter.onArtistImageSelect(artistID);
    }

    @Override
    public void onMovieImageSelected(long movieID) {
        mPresenter.onMovieImageSelect(movieID);
    }

    @Override
    public void onTvImageSelected(long tvID) {
        mPresenter.onTvImageSelect(tvID);

    }
}
