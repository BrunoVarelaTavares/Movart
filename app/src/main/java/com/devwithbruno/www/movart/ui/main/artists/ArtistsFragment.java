package com.devwithbruno.www.movart.ui.main.artists;

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
import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.di.component.ActivityComponent;
import com.devwithbruno.www.movart.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bruno on 27/11/2017.
 */

public class ArtistsFragment extends BaseFragment implements ArtistsMvpView, ArtistsAdapter.OnImageSelectedListener {

    private static final String TAG = "ArtistsFragment";


    List<Artist> artistList;

    @Inject
    ArtistsMvpPresenter<ArtistsMvpView,ArtistsMvpInterator> mPresenter;

    @Inject
    ArtistsAdapter mArtistsAdapter;

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerViewArtists;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artists, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null){
            component.inject(this);
            mPresenter.onAttach(this);
            setUnBinder(ButterKnife.bind(this, view));
            mArtistsAdapter.setOnImageSelectedListener(this);
        }





        return view;
    }




    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    public void setupRecyclerview(RecyclerView.Adapter adapter, RecyclerView recyclerView){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();

    }




    @Override
    public void stopLoadingIndicator() {

    }

    @Override
    public void showArtists(List<Artist> artists) {
        mArtistsAdapter.addArtist(artists);

    }

    @Override
    public void onArtistImageSelect(long artistId, Artist artist) {

    }

    @Override
    protected void setUp(View view) {
        artistList = new ArrayList<>();
        setupRecyclerview(mArtistsAdapter, recyclerViewArtists);

        mPresenter.onViewPrepared();

    }
}
