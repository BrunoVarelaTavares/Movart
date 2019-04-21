package com.devwithbruno.www.movart.ui.main.series;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Trailer;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.di.component.ActivityComponent;
import com.devwithbruno.www.movart.ui.base.BaseFragment;
import com.devwithbruno.www.movart.ui.details.DetailsActivity;
import com.devwithbruno.www.movart.ui.main.series.adapters.SeriesAiringTodaySeriesAdapter;
import com.devwithbruno.www.movart.ui.main.series.adapters.SeriesOnTheAirSeriesAdapter;
import com.devwithbruno.www.movart.ui.main.series.adapters.SeriesPopularSeriesAdapter;
import com.devwithbruno.www.movart.ui.main.series.adapters.SeriesTopRatedSeriesAdapter;
import com.devwithbruno.www.movart.ui.video.VideoActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bruno on 27/11/2017.
 */

public class SeriesFragment extends BaseFragment implements SeriesMvpView,
        SeriesPopularSeriesAdapter.OnImageSelectedListener, SeriesTopRatedSeriesAdapter.OnImageSelectedListener,
SeriesOnTheAirSeriesAdapter.OnImageSelectedListener, SeriesAiringTodaySeriesAdapter.OnImageSelectedListener{


    List<Tv> popularSeriesList;
    List<Tv> topRatedSeriesList;
    List<Tv> onTheAirSeriesList;
    List<Tv> airingTodaySeriesList;


    @Inject
    SeriesMvpPresenter<SeriesMvpView,SeriesMvpInteractor> mPresenter;

    @Inject
    SeriesPopularSeriesAdapter mSeriesPopularSeriesAdapter;

    @Inject
    SeriesTopRatedSeriesAdapter mSeriesTopRatedSeriesAdapter;

    @Inject
    SeriesOnTheAirSeriesAdapter mSeriesOnTheAirSeriesAdapter;

    @Inject
    SeriesAiringTodaySeriesAdapter mSeriesAiringTodaySeriesAdapter;


    @BindView(R.id.recycler_view_one)
    RecyclerView recyclerPopularSeries;

    @BindView(R.id.recycler_view_two)
    RecyclerView recyclerTopRatedSeries;

    @BindView(R.id.recycler_view_tree)
    RecyclerView recyclerViewOnTheAirSeries;

    @BindView(R.id.recycler_view_four)
    RecyclerView recyclerViewAiringTodaySeriesList;






    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);


        ActivityComponent component =  getActivityComponent();
        if (component != null){
            component.inject(this);
            mPresenter.onAttach(this);
            setUnBinder(ButterKnife.bind(this, view));
            mSeriesPopularSeriesAdapter.setOnImageSelectedListener(this);
            mSeriesTopRatedSeriesAdapter.setOnImageSelectedListener(this);
            mSeriesOnTheAirSeriesAdapter.setOnImageSelectedListener(this);
            mSeriesAiringTodaySeriesAdapter.setOnImageSelectedListener(this);

        }




        return view;
    }

    @Override
    protected void setUp(View view) {
        popularSeriesList = new ArrayList<>();
        setupRecyclerview(mSeriesPopularSeriesAdapter,recyclerPopularSeries);

        topRatedSeriesList = new ArrayList<>();
        setupRecyclerview(mSeriesTopRatedSeriesAdapter,recyclerTopRatedSeries);

        onTheAirSeriesList = new ArrayList<>();
        setupRecyclerview(mSeriesOnTheAirSeriesAdapter,recyclerViewOnTheAirSeries);

        airingTodaySeriesList = new ArrayList<>();
        setupRecyclerview(mSeriesAiringTodaySeriesAdapter, recyclerViewAiringTodaySeriesList);


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
    public void updatePopularSeries(List<Tv> tvList) {
        mSeriesPopularSeriesAdapter.addSeries(tvList);
    }

    @Override
    public void updateTopRatedSeries(List<Tv> tvList) {
        mSeriesTopRatedSeriesAdapter.addSeries(tvList);
    }

    @Override
    public void updateOnTheAirSeries(List<Tv> tvList) {
        mSeriesOnTheAirSeriesAdapter.addSeries(tvList);
    }

    @Override
    public void updateAiringTodaySeries(List<Tv> tvList) {
        mSeriesAiringTodaySeriesAdapter.addSeries(tvList);

    }

    @Override
    public void openVideoOnVideoActivity(List<Tv> tvList, Tv tv, String position, List<Trailer> trailers) {
        Intent intent = new Intent(getActivity(), VideoActivity.class);
        intent.putExtra(String.valueOf(R.string.movie_youtube_id), trailers.get(0).getKey());
//        intent.putExtra("movie_extra", movie);
//        intent.putExtra("position", position);
//        intent.putParcelableArrayListExtra(String.valueOf(R.string.upcoming_movies_extra),
//                (ArrayList<? extends Parcelable>) movieList);
        startActivity(intent);

    }


    @Override
    public void openDetailsActivity(Tv tv) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("tv_extra", tv);
        startActivity(intent);
    }

    @Override
    public void onPopularSeriesImageSelect(List<Tv> tvList, Tv tv, String position) {
        mPresenter.onPopularSeriesImageSelect(tvList,tv,position);

    }

    @Override
    public void onImageTopRatedSerieSelected(long tvId) {
        mPresenter.onTvImageSelected(tvId);

    }

    @Override
    public void onImageOnTheAirSerieSelected(long tvId) {
        mPresenter.onTvImageSelected(tvId);
    }

    @Override
    public void onImageAiringTodaySeriesSelected(long tvId) {
        mPresenter.onTvImageSelected(tvId);
    }
}
