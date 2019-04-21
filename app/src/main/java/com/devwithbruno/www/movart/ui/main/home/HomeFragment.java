package com.devwithbruno.www.movart.ui.main.home;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.Trailer;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.Watchlist;
import com.devwithbruno.www.movart.di.component.ActivityComponent;
import com.devwithbruno.www.movart.ui.artistsdetails.ArtistsActivity;
import com.devwithbruno.www.movart.ui.base.BaseFragment;
import com.devwithbruno.www.movart.ui.details.DetailsActivity;
import com.devwithbruno.www.movart.ui.main.home.adapters.PopularArtistsAdapter;
import com.devwithbruno.www.movart.ui.main.home.adapters.PopularMoviesAdapter;
import com.devwithbruno.www.movart.ui.main.home.adapters.PopularSeriesAdapter;
import com.devwithbruno.www.movart.ui.main.home.adapters.UpcomingMoviesAdapter;
import com.devwithbruno.www.movart.ui.video.VideoActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bruno on 27/11/2017.
 */

public class HomeFragment extends BaseFragment implements HomeMvpView, PopularMoviesAdapter.OnImageSelectedListener,
        PopularSeriesAdapter.OnImageSelectedListener, PopularArtistsAdapter.OnImageSelectedListener,
        UpcomingMoviesAdapter.OnImageSelectedListener{

    private static final String TAG = "HomeFragment";

    private List<Movie> movieList;
    private List<Movie> movieListYoutube;
    private List<Tv>   popularSeriesList;
    private List<Trailer> trailerImages;
    private List<Tv> popularSeries;
    private List<Artist> artistList;


    @Inject
    HomeMvpPresenter<HomeMvpView,HomeMvpInteractor> mPresenter;

    @Inject
    PopularMoviesAdapter mPopularMoviesAdapter;

    @Inject
    UpcomingMoviesAdapter mUpcomingMoviesAdapter;

    @Inject
    PopularArtistsAdapter mPopularArtistsAdapter;

    @Inject
    PopularSeriesAdapter mPopularSeriesAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @BindView(R.id.recycler_view_Youtube)
    RecyclerView recyclerViewYoutube;


    @BindView(R.id.recycler_view_p_series)
    RecyclerView recyclerViewPopularSeries;

    @BindView(R.id.recycler_view_artistis)
    RecyclerView recyclerViewArtistes;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Log.d(TAG, "onCreateView: ");

        ActivityComponent component = getActivityComponent();
        if (component != null){
            component.inject(this);
            mPresenter.onAttach(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPopularMoviesAdapter.setOnImageSelectedListener(this);
            mPopularSeriesAdapter.setOnImageSelectedListener(this);
            mPopularArtistsAdapter.setOnImageSelectedListener(this);
            mUpcomingMoviesAdapter.setmOnImageSelectedListener(this);
        }




        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

    }


    public void setupRecyclerview(RecyclerView.Adapter adapter, RecyclerView recyclerView){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();

    }







    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    protected void setUp(View view) {
        movieList = new ArrayList<>();
        setupRecyclerview(mPopularMoviesAdapter,recyclerView);

        movieListYoutube = new ArrayList<>();
        setupRecyclerview(mUpcomingMoviesAdapter,recyclerViewYoutube);
        trailerImages = new ArrayList<>();

        popularSeriesList = new ArrayList<>();
        setupRecyclerview(mPopularSeriesAdapter,recyclerViewPopularSeries);

        artistList = new ArrayList<>();
        setupRecyclerview(mPopularArtistsAdapter, recyclerViewArtistes);

        mPresenter.onViewPrepared();

    }

    @Override
    public void updatePopularMovies(List<Movie> movieList) {
        mPopularMoviesAdapter.addMovies(movieList);
    }

    @Override
    public void updateUpcomingMovies(List<Movie> movieList) { mUpcomingMoviesAdapter.addMovies(movieList);}



    @Override
    public void updatePopularSeries(List<Tv> tvList) {
        mPopularSeriesAdapter.addSeries(tvList);
    }

    @Override
    public void updatePopularArtists(List<Artist> artistList) {
        mPopularArtistsAdapter.addArtist(artistList);

    }


    @Override
    public void openMovieDetailsOnDetailsActivity(Movie movie) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("movie_extra", movie);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void openTvDatailsOnDetailsActivity(Tv tv) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("tv_extra", tv);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void openArtistOnArtistActivity(Artist artist, Artist artistInfo) {
        Intent intent = new Intent(getActivity(), ArtistsActivity.class);
        intent.putExtra("artist_extra", artist);
        if (artistInfo != null){
            intent.putExtra("artist_info", artistInfo);
        }
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

    }

    @Override
    public void openVideoOnVideoActivity(List<Movie> movieList, Movie movie,
                                         String position, List<Trailer> trailerList) {
        if (trailerList.size() >= 0) {
            Intent intent = new Intent(getActivity(), VideoActivity.class);
            intent.putExtra(String.valueOf(R.string.movie_youtube_id), trailerList.get(0).getKey());
            intent.putExtra("movie_extra", movie);
            intent.putExtra("position", position);
            intent.putParcelableArrayListExtra(String.valueOf(R.string.upcoming_movies_extra),
                    (ArrayList<? extends Parcelable>) movieList);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

    }

    @Override
    public void showPopularMovies(List<Movie> movies) {
        mPopularMoviesAdapter.addMovies(movies);

    }

    @Override
    public void showUpcomingMovies(List<Movie> movies) {
        mUpcomingMoviesAdapter.addMovies(movies);
    }

    @Override
    public void showPopularSeries(List<Tv> series) {
        mPopularSeriesAdapter.addSeries(series);
    }

    @Override
    public void showPopularArtists(List<Artist> artists) {
        mPopularArtistsAdapter.addArtist(artists);
    }

    @Override
    public void clearPopularMovies() {
      mPopularMoviesAdapter.clearData();

    }

    @Override
    public void clearUpcomingMovies() {
        mUpcomingMoviesAdapter.clearData();
    }

    @Override
    public void clearPopularSeries() {
        mPopularSeriesAdapter.clearData();

    }

    @Override
    public void clearPopularArtists() {
        mPopularArtistsAdapter.clearData();
    }

    @Override
    public void showNoDataMessage() {

    }

    @Override
    public void showErrorMessage(String error) {

    }

    @Override
    public void showMovieDetail(Movie movie) {

    }

    @Override
    public void stopLoadingIndicator() {

    }

    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }


    @Override
    public void onPopularMovieImageSelect(long movieID) {
        mPresenter.onMovieImageSelect(movieID);
    }

    @Override
    public void onAddToWatchlist(Watchlist watchlist) {
        mPresenter.addToWatchlist(watchlist);
    }

    @Override
    public void removeFromWatchlist(Watchlist watchlist) {
        mPresenter.removeFromWatchlist(watchlist);
    }

    @Override
    public boolean isOnWatchlist(Movie movie) {
        return mPresenter.movieIsOnWatchlist(movie);
    }

    @Override
    public void onPopularSerieImageSelect(long tvId) {
        mPresenter.onTvImageSelect(tvId);
    }

    @Override
    public void onAddTvToWatchlist(Watchlist watchlist) {
        mPresenter.addToWatchlist(watchlist);

    }

    @Override
    public void removeTvFromWatchlist(Watchlist watchlist) {
        mPresenter.removeFromWatchlist(watchlist);

    }

    @Override
    public boolean tvIsOnWatchlist(Tv tv) {
        return mPresenter.tvIsOnWatchlist(tv);
    }

    @Override
    public void onArtistImageSelect(long artistId, Artist artist) {
        mPresenter.onArtistImageSelect(artistId ,artist);
    }

    @Override
    public void onUpMovieImageSelect(List<Movie> movieList, Movie movie, String position) {
        mPresenter.onUpcomingImageSelect(movieList,movie,position);

    }

}
