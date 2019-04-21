package com.devwithbruno.www.movart.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.RecentVisited;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.Watchlist;
import com.devwithbruno.www.movart.di.ActivityContext;
import com.devwithbruno.www.movart.di.PerActivity;
import com.devwithbruno.www.movart.ui.main.MainInteractor;
import com.devwithbruno.www.movart.ui.main.MainMvpInteractor;
import com.devwithbruno.www.movart.ui.main.MainMvpPresenter;
import com.devwithbruno.www.movart.ui.main.MainMvpView;
import com.devwithbruno.www.movart.ui.main.MainPresenter;
import com.devwithbruno.www.movart.ui.main.ViewPagerAdapter;
import com.devwithbruno.www.movart.ui.main.artists.ArtistsAdapter;
import com.devwithbruno.www.movart.ui.main.artists.ArtistsInteractor;
import com.devwithbruno.www.movart.ui.main.artists.ArtistsMvpInterator;
import com.devwithbruno.www.movart.ui.main.artists.ArtistsMvpPresenter;
import com.devwithbruno.www.movart.ui.main.artists.ArtistsMvpView;
import com.devwithbruno.www.movart.ui.main.artists.ArtistsPresenter;
import com.devwithbruno.www.movart.ui.main.home.HomeInteractor;
import com.devwithbruno.www.movart.ui.main.home.HomeMvpInteractor;
import com.devwithbruno.www.movart.ui.main.home.HomeMvpPresenter;
import com.devwithbruno.www.movart.ui.main.home.HomeMvpView;
import com.devwithbruno.www.movart.ui.main.home.HomePresenter;
import com.devwithbruno.www.movart.ui.main.home.adapters.PopularArtistsAdapter;
import com.devwithbruno.www.movart.ui.main.home.adapters.PopularMoviesAdapter;
import com.devwithbruno.www.movart.ui.main.home.adapters.PopularSeriesAdapter;
import com.devwithbruno.www.movart.ui.main.home.adapters.UpcomingAdapterMvpPresenter;
import com.devwithbruno.www.movart.ui.main.home.adapters.UpcomingMoviesAdapter;
import com.devwithbruno.www.movart.ui.main.home.adapters.UpcomingPresenter;
import com.devwithbruno.www.movart.ui.main.movies.MoviesInteractor;
import com.devwithbruno.www.movart.ui.main.movies.MoviesMvpInteractor;
import com.devwithbruno.www.movart.ui.main.movies.MoviesMvpPresenter;
import com.devwithbruno.www.movart.ui.main.movies.MoviesMvpView;
import com.devwithbruno.www.movart.ui.main.movies.MoviesPresenter;
import com.devwithbruno.www.movart.ui.main.movies.adapters.ComingSoonMoviesAdapter;
import com.devwithbruno.www.movart.ui.main.movies.adapters.MoviesPopularMoviesAdapter;
import com.devwithbruno.www.movart.ui.main.movies.adapters.MoviesPopularMoviesAdapterMvpPresenter;
import com.devwithbruno.www.movart.ui.main.movies.adapters.MoviesPopularMoviesPresenter;
import com.devwithbruno.www.movart.ui.main.movies.adapters.PlayingNowMoviesAdapter;
import com.devwithbruno.www.movart.ui.main.movies.adapters.TopRatedMoviesAdapter;
import com.devwithbruno.www.movart.ui.main.series.SeriesInteractor;
import com.devwithbruno.www.movart.ui.main.series.SeriesMvpInteractor;
import com.devwithbruno.www.movart.ui.main.series.SeriesMvpPresenter;
import com.devwithbruno.www.movart.ui.main.series.SeriesMvpView;
import com.devwithbruno.www.movart.ui.main.series.SeriesPresenter;
import com.devwithbruno.www.movart.ui.main.series.adapters.SeriesAiringTodaySeriesAdapter;
import com.devwithbruno.www.movart.ui.main.series.adapters.SeriesOnTheAirSeriesAdapter;
import com.devwithbruno.www.movart.ui.main.series.adapters.SeriesPopularSeriesAdapter;
import com.devwithbruno.www.movart.ui.main.series.adapters.SeriesPopularSeriesAdapterMvpPresenter;
import com.devwithbruno.www.movart.ui.main.series.adapters.SeriesPopularSeriesPresenter;
import com.devwithbruno.www.movart.ui.main.series.adapters.SeriesTopRatedSeriesAdapter;
import com.devwithbruno.www.movart.ui.profil.ProfileInteractor;
import com.devwithbruno.www.movart.ui.profil.ProfileMvpInteractor;
import com.devwithbruno.www.movart.ui.profil.ProfileMvpPresenter;
import com.devwithbruno.www.movart.ui.profil.ProfileMvpView;
import com.devwithbruno.www.movart.ui.profil.ProfilePresenter;
import com.devwithbruno.www.movart.ui.profil.RecentVisitedAdapter;
import com.devwithbruno.www.movart.ui.profil.favourite.FavoritesInteractor;
import com.devwithbruno.www.movart.ui.profil.favourite.FavoritesMvpInteractor;
import com.devwithbruno.www.movart.ui.profil.favourite.FavoritesMvpPresenter;
import com.devwithbruno.www.movart.ui.profil.favourite.FavoritesMvpView;
import com.devwithbruno.www.movart.ui.profil.favourite.FavoritesPresenter;
import com.devwithbruno.www.movart.ui.profil.lists.ListsInteractor;
import com.devwithbruno.www.movart.ui.profil.lists.ListsMvpInteractor;
import com.devwithbruno.www.movart.ui.profil.lists.ListsMvpPresenter;
import com.devwithbruno.www.movart.ui.profil.lists.ListsMvpView;
import com.devwithbruno.www.movart.ui.profil.lists.ListsPresenter;
import com.devwithbruno.www.movart.ui.profil.rating.RatingsInteractor;
import com.devwithbruno.www.movart.ui.profil.rating.RatingsMvpInteractor;
import com.devwithbruno.www.movart.ui.profil.rating.RatingsMvpPresenter;
import com.devwithbruno.www.movart.ui.profil.rating.RatingsMvpView;
import com.devwithbruno.www.movart.ui.profil.rating.RatingsPresenter;
import com.devwithbruno.www.movart.ui.profil.watchlist.WatchListInteractor;
import com.devwithbruno.www.movart.ui.profil.watchlist.WatchlistAdapter;
import com.devwithbruno.www.movart.ui.profil.watchlist.WatchlistMvpInteractor;
import com.devwithbruno.www.movart.ui.profil.watchlist.WatchlistMvpPresenter;
import com.devwithbruno.www.movart.ui.profil.watchlist.WatchlistMvpView;
import com.devwithbruno.www.movart.ui.profil.watchlist.WatchlistPresenter;
import com.devwithbruno.www.movart.utils.rx.AppSchedulerProvider;
import com.devwithbruno.www.movart.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Bruno on 15/01/2018.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;


    public ActivityModule(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }


    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView, MainMvpInteractor> provideMainPresenter(
            MainPresenter<MainMvpView, MainMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ProfileMvpPresenter<ProfileMvpView, ProfileMvpInteractor> provideProfilePresenter(
            ProfilePresenter<ProfileMvpView,ProfileMvpInteractor> presenter){
        return presenter;
    }

    @Provides
    @PerActivity
    FavoritesMvpPresenter<FavoritesMvpView,FavoritesMvpInteractor> provideFavoritesPresenter(
            FavoritesPresenter<FavoritesMvpView,FavoritesMvpInteractor> presenter){
                return presenter;
    }

    @Provides
    @PerActivity
    ListsMvpPresenter<ListsMvpView,ListsMvpInteractor> provideListsPresenter(
            ListsPresenter<ListsMvpView,ListsMvpInteractor> presenter){
        return presenter;
    }

    @Provides
    @PerActivity
    RatingsMvpPresenter<RatingsMvpView,RatingsMvpInteractor> provideRatingsPresenter(
            RatingsPresenter<RatingsMvpView,RatingsMvpInteractor> presenter){
        return presenter;
    }

    @Provides
    @PerActivity
    WatchlistMvpPresenter<WatchlistMvpView,WatchlistMvpInteractor> provideWatchlistPresenter(
            WatchlistPresenter<WatchlistMvpView,WatchlistMvpInteractor> presenter){
        return presenter;
    }




    @Provides
    ViewPagerAdapter provideViewPagerAdapter(AppCompatActivity activity) {
        return new ViewPagerAdapter(activity.getSupportFragmentManager());
    }


    @Provides
    @PerActivity
    MainMvpInteractor provideMainMvpInteractor(MainInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    ProfileMvpInteractor provideProfilMvpInteractor(ProfileInteractor interactor){
        return interactor;
    }

    @Provides
    @PerActivity
    FavoritesMvpInteractor provideFavoritesInteractor(FavoritesInteractor interactor){
        return interactor;
    }


    @Provides
    @PerActivity
    ListsMvpInteractor provideListIterator(ListsInteractor interactor){
        return interactor;
    }

    @Provides
    @PerActivity
    RatingsMvpInteractor provideRatingsInteractor(RatingsInteractor interactor){
        return interactor;
    }


    @Provides
    @PerActivity
    WatchlistMvpInteractor provideWatchlistMvpInteractor(WatchListInteractor interactor){
        return interactor;
    }


    @Provides
    HomeMvpPresenter<HomeMvpView, HomeMvpInteractor> provideHomeMvpPresenter(
            HomePresenter<HomeMvpView, HomeMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    MoviesMvpPresenter<MoviesMvpView, MoviesMvpInteractor> provideMoviesMvpPresenter(
            MoviesPresenter<MoviesMvpView, MoviesMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    SeriesMvpPresenter<SeriesMvpView,SeriesMvpInteractor> provideSeriesMvpPresenter(
            SeriesPresenter<SeriesMvpView,SeriesMvpInteractor> presenter){
        return presenter;
    }

    @Provides
    ArtistsMvpPresenter<ArtistsMvpView,ArtistsMvpInterator> provideArtistsMvpPresenter(
            ArtistsPresenter<ArtistsMvpView,ArtistsMvpInterator> presenter){
                return presenter;
    }


    @Provides
    @PerActivity
    HomeMvpInteractor provideHomeMvpInteractor(HomeInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    MoviesMvpInteractor provideMoviesMvpInteractor(MoviesInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    SeriesMvpInteractor provideSeriesMvpInteractor(SeriesInteractor interactor){
                return interactor;
    }

    @Provides
    @PerActivity
    ArtistsMvpInterator provideArtistsMvpInterator(ArtistsInteractor interactor){
        return interactor;
    }







    @Provides
    PopularMoviesAdapter providePopularMoviesAdapter() {
        return new PopularMoviesAdapter(new ArrayList<Movie>());
    }

    @Provides
    UpcomingMoviesAdapter provideUpcomingMoviesAdapter() {
        return new UpcomingMoviesAdapter(new ArrayList<Movie>());
    }

    @Provides
    MoviesPopularMoviesAdapter provideMoviesPopularMoviesAdapter() {
        return new MoviesPopularMoviesAdapter(new ArrayList<Movie>());
    }

    @Provides
    PopularSeriesAdapter providePopularSeriesAdapter() {
        return new PopularSeriesAdapter(new ArrayList<Tv>());
    }


    @Provides
    PopularArtistsAdapter providePopularArtistsAdapter() {
        return new PopularArtistsAdapter(new ArrayList<Artist>());
    }

    @Provides
    SeriesPopularSeriesAdapter proovideSeriesPopularSeriesAdapter(){
        return new SeriesPopularSeriesAdapter(new ArrayList<Tv>());
    }

    @Provides
    RecentVisitedAdapter provideRecentVisitedAdapter(){
        return new RecentVisitedAdapter(new ArrayList<RecentVisited>());
    }

    @Provides
    WatchlistAdapter provideWatchlistAdapter(){
        return new WatchlistAdapter(new ArrayList<Watchlist>());
    }

    @Provides
    ArtistsAdapter provideArtistsAdapter(){
        return new ArtistsAdapter(new ArrayList<>());
    }


    @Provides
    UpcomingAdapterMvpPresenter<HomeMvpView, HomeMvpInteractor> provideUpcomingAdapterPresenter(
            UpcomingPresenter<HomeMvpView, HomeMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    MoviesPopularMoviesAdapterMvpPresenter<MoviesMvpView, MoviesMvpInteractor>
    provideMoviesPopularMoviesAdapterMvpPresenter(MoviesPopularMoviesPresenter<MoviesMvpView,
            MoviesMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    SeriesPopularSeriesAdapterMvpPresenter<SeriesMvpView, SeriesMvpInteractor>
    provideSeriesPopularSeriesAdapterMvpPresenter(SeriesPopularSeriesPresenter<SeriesMvpView,
            SeriesMvpInteractor> presenter){
        return presenter;
    }



    @Provides
    PlayingNowMoviesAdapter providePlayingNowMoviesAdapter(){
        return  new PlayingNowMoviesAdapter(new ArrayList<Movie>());
    }

    @Provides
    TopRatedMoviesAdapter provideTopRatedMoviesAdapter(){
        return new TopRatedMoviesAdapter(new ArrayList<Movie>());
    }


    @Provides
    ComingSoonMoviesAdapter provideComingSoonMoviesAdapter(){
        return new ComingSoonMoviesAdapter(new ArrayList<Movie>());
    }


    @Provides
    SeriesTopRatedSeriesAdapter provideSeriesTopRatedSeriesAdapter(){
        return new SeriesTopRatedSeriesAdapter(new ArrayList<Tv>());
    }


    @Provides
    SeriesOnTheAirSeriesAdapter provideSeriesOnTheAirSeriesAdapter(){
        return new SeriesOnTheAirSeriesAdapter(new ArrayList<Tv>());
    }


    @Provides
    SeriesAiringTodaySeriesAdapter provideSeriesAiringTodaySeriesAdapter(){
        return new SeriesAiringTodaySeriesAdapter(new ArrayList<Tv>());
    }

    /**
     *
     *
     */

//    private static final String BASE_URL = "base_url";
//
//    @Provides
//    @Named(BASE_URL)
//    String provideBaseUrl() {
//        return Config.BASE_URL;
//    }
//
//
//    @Provides
//    Retrofit provideRetrofit(@Named(BASE_URL) String baseUrl) {
//        return new Retrofit.Builder().baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//    }
//
//    @Provides
//    MoviesService provideMoviesService(Retrofit retrofit){
//        return retrofit.create(MoviesService.class);
//    }
//
//
//    public static final String DATABASE = "database_name";
//
//    @Provides
//    @Named(DATABASE)
//    String provideDatabaseName(){
//        return Config.MOVIES_TABLE_NAME;
//    }
//
//
//    @Provides
//    PopularMoviesDb providePopularMoviesDao(AppCompatActivity context, @Named(DATABASE) String databaseName){
//        return Room.databaseBuilder(context,PopularMoviesDb.class, databaseName).build();
//    }
//
//
//    @Provides
//    PopularMoviesDao provideMoviesDao(PopularMoviesDb popularMoviesDb){
//        return popularMoviesDb.popularMoviesDao();
//    }
//
//
//
//    @Provides
//    @Local
//    public PopularMoviesDataSource providePopularMoviesLocalDataSource(
//            PopularMoviesLocalDataSource popularMoviesLocalDataSource){
//        return popularMoviesLocalDataSource;
//    }
//
//
//    @Provides
//    @Remote
//    public PopularMoviesDataSource providePopularMoviesRemoteDataSource(
//            PopularMoviesRemoteDataSource popularMoviesRemoteDataSource){
//        return popularMoviesRemoteDataSource;
//    }
}
