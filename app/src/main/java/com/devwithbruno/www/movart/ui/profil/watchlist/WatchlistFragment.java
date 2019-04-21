package com.devwithbruno.www.movart.ui.profil.watchlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Watchlist;
import com.devwithbruno.www.movart.di.component.ActivityComponent;
import com.devwithbruno.www.movart.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;

/**
 * Created by Bruno on 27/11/2017.
 */

public class WatchlistFragment extends BaseFragment implements WatchlistMvpView,
        WatchlistAdapter.OnImageSelectedListener {

    public static final String TAG = "WatchlistFragment";

    @Inject
    WatchlistMvpPresenter<WatchlistMvpView, WatchlistMvpInteractor> mPresenter;


    @Inject
    WatchlistAdapter mWatchlistAdapter;


    @BindView(R.id.backArrow)
    public ImageView imageViewBackArrow;

    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;

    private List<Watchlist> watchlistList;

    public Box<Watchlist> watchlistBox;


    public static WatchlistFragment newInstance() {
        Bundle args = new Bundle();
        WatchlistFragment fragment = new WatchlistFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_watchlist, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            mWatchlistAdapter.setOnImageSelectedListener(this);


        }


        return view;
    }




    @OnClick(R.id.backArrow)
    void onBackArrowClick() {

    }



    public void setupRecyclerview(RecyclerView.Adapter adapter, RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();

    }


    @Override
    protected void setUp(View view) {
        watchlistList = new ArrayList<>();
        setupRecyclerview(mWatchlistAdapter, mRecyclerView);
        mPresenter.onViewPrepared();
    }

    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }


    @Override
    public void onMovieImageSelect(long movieID) {

    }

    @Override
    public void onTvImageSelected(long tvID) {

    }

    @Override
    public void updateWatchlistList(List<Watchlist> watchlists) {
        Log.d(TAG, "updateWatchlistList: + WatchlistAdapter " + watchlists.size());
        mWatchlistAdapter.add(watchlists);
    }

    @Override
    public void clearData() {
        mWatchlistAdapter.clearData();
    }
}
