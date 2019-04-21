package com.devwithbruno.www.movart.ui.profil.favourite;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.di.component.ActivityComponent;
import com.devwithbruno.www.movart.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Bruno on 27/11/2017.
 */

public class FavoritesFragment extends BaseFragment implements FavoritesMvpView{


    public static final String TAG = "FavoritesFragment";

    @Inject
    FavoritesMvpPresenter<FavoritesMvpView,FavoritesMvpInteractor> mPresenter;


    public static FavoritesFragment newInstance() {
        Bundle args = new Bundle();
        FavoritesFragment fragment = new FavoritesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        ActivityComponent component =  getActivityComponent();
        if (component != null){
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
           mPresenter.onAttach(this);
        }


        return view;
    }




    @Override
    protected void setUp(View view) {

    }



    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }



}
