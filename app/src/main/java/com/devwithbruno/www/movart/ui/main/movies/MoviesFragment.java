package com.devwithbruno.www.movart.ui.main.movies;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.Trailer;
import com.devwithbruno.www.movart.di.component.ActivityComponent;
import com.devwithbruno.www.movart.ui.base.BaseFragment;
import com.devwithbruno.www.movart.ui.details.DetailsActivity;
import com.devwithbruno.www.movart.ui.main.movies.adapters.ComingSoonMoviesAdapter;
import com.devwithbruno.www.movart.ui.main.movies.adapters.MoviesPopularMoviesAdapter;
import com.devwithbruno.www.movart.ui.main.movies.adapters.PlayingNowMoviesAdapter;
import com.devwithbruno.www.movart.ui.main.movies.adapters.TopRatedMoviesAdapter;
import com.devwithbruno.www.movart.ui.video.VideoActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bruno on 27/11/2017.
 */

public class MoviesFragment extends BaseFragment implements MoviesMvpView,
        MoviesPopularMoviesAdapter.OnImageSelectedListener, PlayingNowMoviesAdapter.OnImageSelectedListener,
        TopRatedMoviesAdapter.OnImageSelectedListener, ComingSoonMoviesAdapter.OnImageSelectedListener{


    List<Movie> populatMoviesList;
    List<Movie> playingNowMovieList;
    List<Movie> topRatedMovieList;
    List<Movie> upcomingMovieList;


    @Inject
    MoviesMvpPresenter<MoviesMvpView, MoviesMvpInteractor> mPresenter;

    @Inject
    MoviesPopularMoviesAdapter mMoviesPopularMoviesAdapter;

    @Inject
    PlayingNowMoviesAdapter mPlayingNowMoviesAdapter;

    @Inject
    TopRatedMoviesAdapter mTopRatedMoviesAdapter;

    @Inject
    ComingSoonMoviesAdapter mComingSoonMoviesAdapter;



    @BindView(R.id.recycler_view_one)
    RecyclerView recyclerPopularMovies;

    @BindView(R.id.recycler_view_two)
    RecyclerView recyclerPlayingNowMovies;

    @BindView(R.id.recycler_view_tree)
    RecyclerView recyclerViewTopRatedMovies;

    @BindView(R.id.recycler_view_four)
    RecyclerView recyclerViewComingSoon;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);


        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
            setUnBinder(ButterKnife.bind(this, view));
            mMoviesPopularMoviesAdapter.setmOnImageSelectedListener(this);
            mPlayingNowMoviesAdapter.setOnImageSelectedListener(this);
            mTopRatedMoviesAdapter.setOnImageSelectedListener(this);
            mComingSoonMoviesAdapter.setOnImageSelectedListener(this);


        }

        return view;
    }


    @Override
    protected void setUp(View view) {
        populatMoviesList = new ArrayList<>();
        setupRecyclerview(mMoviesPopularMoviesAdapter, recyclerPopularMovies);

        playingNowMovieList = new ArrayList<>();
        setupRecyclerview(mPlayingNowMoviesAdapter, recyclerPlayingNowMovies);

        topRatedMovieList = new ArrayList<>();
        setupRecyclerview(mTopRatedMoviesAdapter, recyclerViewTopRatedMovies);

        upcomingMovieList = new ArrayList<>();
        setupRecyclerview(mComingSoonMoviesAdapter, recyclerViewComingSoon);

        mPresenter.onViewPrepared();

    }


    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }


    public void setupRecyclerview(RecyclerView.Adapter adapter, RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onPopularMoviesImageSelect(List<Movie> movieList, Movie movie, String position) {
        mPresenter.onPopularMoviesImageSelect(movieList, movie, position);

    }

    @Override
    public void updatePopularMovies(List<Movie> movieList) {
        mMoviesPopularMoviesAdapter.addMovies(movieList);
    }

    @Override
    public void updatePlayingNowMovies(List<Movie> movieList) {
        mPlayingNowMoviesAdapter.addMovies(movieList);
    }

    @Override
    public void updateTopRatedMovies(List<Movie> movieList) {
        mTopRatedMoviesAdapter.addMovies(movieList);
    }

    @Override
    public void updateComingSoonMovies(List<Movie> movieList) {
        mComingSoonMoviesAdapter.addMovies(movieList);
    }

    @Override
    public void updateLatestMovies(List<Movie> movieList) {
        mComingSoonMoviesAdapter.addMovies(movieList);

    }


    @Override
    public void openVideoOnVideoActivity(List<Movie> movieList, Movie movie, String position, List<Trailer> trailerList) {
        if (trailerList.size() >= 0) {
            Intent intent = new Intent(getActivity(), VideoActivity.class);
            intent.putExtra(String.valueOf(R.string.movie_youtube_id), trailerList.get(0).getKey());
            intent.putExtra("movie_extra", movie);
            intent.putExtra("position", position);
            intent.putParcelableArrayListExtra(String.valueOf(R.string.upcoming_movies_extra),
                    (ArrayList<? extends Parcelable>) movieList);
            startActivity(intent);
        }
    }

    @Override
    public void openDetailsActivity(Movie movie) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("movie_extra", movie);
        startActivity(intent);
    }

    @Override
    public void onImagePlayingNowMovieSelect(long movieID) {
        mPresenter.onMovieImageSelected(movieID);
    }

    @Override
    public void onImageTopRatedMovieSelect(long movieID) {
        mPresenter.onMovieImageSelected(movieID);

    }

    @Override
    public void onImageComingSoonMovieSelect(long movieID) {
        mPresenter.onMovieImageSelected(movieID);
    }

}
