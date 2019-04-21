package com.devwithbruno.www.movart.di.component;

import com.devwithbruno.www.movart.di.PerActivity;
import com.devwithbruno.www.movart.di.module.ActivityModule;
import com.devwithbruno.www.movart.di.module.ApiServiceModule;
import com.devwithbruno.www.movart.di.module.DatabaseModule;
import com.devwithbruno.www.movart.di.module.RepositoryModule;
import com.devwithbruno.www.movart.ui.main.MainActivity;
import com.devwithbruno.www.movart.ui.main.artists.ArtistsFragment;
import com.devwithbruno.www.movart.ui.main.home.HomeFragment;
import com.devwithbruno.www.movart.ui.main.home.adapters.UpcomingMoviesAdapter;
import com.devwithbruno.www.movart.ui.main.movies.MoviesFragment;
import com.devwithbruno.www.movart.ui.main.movies.adapters.MoviesPopularMoviesAdapter;
import com.devwithbruno.www.movart.ui.main.series.SeriesFragment;
import com.devwithbruno.www.movart.ui.main.series.adapters.SeriesPopularSeriesAdapter;
import com.devwithbruno.www.movart.ui.profil.ProfileActivity;
import com.devwithbruno.www.movart.ui.profil.favourite.FavoritesFragment;
import com.devwithbruno.www.movart.ui.profil.lists.ListsFragment;
import com.devwithbruno.www.movart.ui.profil.rating.RatingsFragment;
import com.devwithbruno.www.movart.ui.profil.watchlist.WatchlistFragment;

import dagger.Component;

/**
 * Created by Bruno on 15/01/2018.
 */


@PerActivity
@Component( modules = {ActivityModule.class, ApiServiceModule.class, DatabaseModule.class, RepositoryModule.class},
        dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(ProfileActivity activity);

    void inject(HomeFragment fragment);

    void inject(MoviesFragment fragment);

    void inject(SeriesFragment fragment);

    void inject(WatchlistFragment fragment);

    void inject(RatingsFragment fragment);

    void inject(ListsFragment fragment);

    void inject(FavoritesFragment fragment);

    void inject(ArtistsFragment fragment);

    void inject(UpcomingMoviesAdapter.MyViewHolder adapter);

    void inject(MoviesPopularMoviesAdapter.MyViewHolder myViewHolder);

    void inject(SeriesPopularSeriesAdapter.MyViewHolder myViewHolder);



}
