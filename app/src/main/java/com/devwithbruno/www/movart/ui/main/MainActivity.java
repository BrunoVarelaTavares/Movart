package com.devwithbruno.www.movart.ui.main;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.ui.base.BaseActivity;
import com.devwithbruno.www.movart.ui.main.artists.ArtistsFragment;
import com.devwithbruno.www.movart.ui.main.home.HomeFragment;
import com.devwithbruno.www.movart.ui.main.movies.MoviesFragment;
import com.devwithbruno.www.movart.ui.main.series.SeriesFragment;
import com.devwithbruno.www.movart.ui.profil.ProfileActivity;
import com.devwithbruno.www.movart.utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    ViewPagerAdapter adapter;

    @Inject
    MainMvpPresenter<MainMvpView, MainMvpInteractor> mPresenter;

    @BindView(R.id.tab_scroll)
    public TabLayout tabLayout;

    @BindView(R.id.viewpager)
    public ViewPager viewPager;

    @BindView(R.id.ic_search)
    public ImageView imgViewSearch;

    @BindView(R.id.eTSearch)
    public EditText editTextSearch;

    @BindView(R.id.imageViewProfilBackg)
    public ImageView imageViewProfilBackGround;
    //movart_icon
    @BindView(R.id.movart_icon)
    public ImageView imageMovartIcon;
    //backArrow
    @BindView(R.id.backArrow)
    public ImageView imageViewBackArrow;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        initImageLoader();
        mPresenter.onAttach(this);

        setUp();






    }

    @Override
    protected void setUp() {
        new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        tabLayout.setTabTextColors(
                ContextCompat.getColor(this, R.color.grey),
                ContextCompat.getColor(this, R.color.white)
        );
        tabLayout.setupWithViewPager(viewPager);


        adapter.addFragment(new HomeFragment(), getString(R.string.frag_home));
        adapter.addFragment(new MoviesFragment(), getString(R.string.frag_movies_name));
        adapter.addFragment(new SeriesFragment(), getString(R.string.frag_series_name) );
        adapter.addFragment(new ArtistsFragment(), getString(R.string.frag_artists_name));
        adapter.addFragment(new MoviesFragment(), getString(R.string.frag_movies_name));
        adapter.addFragment(new SeriesFragment(), getString(R.string.frag_series_name) );
        viewPager.setAdapter(adapter);



    }


    @OnClick(R.id.ic_search) void search(){
        imgViewSearch.setVisibility(View.GONE);
        imageMovartIcon.setVisibility(View.GONE);
        imageViewBackArrow.setVisibility(View.VISIBLE);
        editTextSearch.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.backArrow) void backArrow(){
        imageViewBackArrow.setVisibility(View.GONE);
        editTextSearch.setVisibility(View.GONE);
        imgViewSearch.setVisibility(View.VISIBLE);
        imageMovartIcon.setVisibility(View.VISIBLE);

    }





    @OnClick(R.id.imageViewProfilBackg) void openProfilActivity(){
        startActivity(ProfileActivity.getStartIntent(this));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }



    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(this);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }


    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
