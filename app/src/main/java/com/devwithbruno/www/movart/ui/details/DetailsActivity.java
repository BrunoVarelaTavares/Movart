package com.devwithbruno.www.movart.ui.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.network.api.ApiCalls;
import com.devwithbruno.www.movart.data.model.Cast;
import com.devwithbruno.www.movart.data.model.Crew;
import com.devwithbruno.www.movart.data.model.Genre;
import com.devwithbruno.www.movart.data.model.Image;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.Review;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.ui.adaptes.CastAdapter;
import com.devwithbruno.www.movart.ui.adaptes.ImageAdapter;
import com.devwithbruno.www.movart.ui.adaptes.ListAdapterDetailsGenres;
import com.devwithbruno.www.movart.ui.adaptes.MoviesAdapter;
import com.devwithbruno.www.movart.ui.adaptes.ReviewsListAdapter;
import com.devwithbruno.www.movart.ui.adaptes.TrailerListAdapter;
import com.devwithbruno.www.movart.ui.adaptes.TvAdapter;
import com.devwithbruno.www.movart.utils.DateFormatter;
import com.devwithbruno.www.movart.utils.GridImagesFragment;
import com.devwithbruno.www.movart.utils.SelectedImageFragment;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bruno on 06/12/2017.
 */

public class DetailsActivity extends AppCompatActivity  implements GridImagesFragment.OnGridImageSelectedListener{

    private static final String TAG = "DetailsActivity";

    @BindView(R.id.tv_title) public TextView textViewTitle;
    @BindView(R.id.tw_vote) public TextView textViewVote;
    @BindView(R.id.tv_desc) public TextView textViewDecription;
    @BindView(R.id.tv_genre) public TextView textViewGenre;
    @BindView(R.id.tv_time) public TextView textViewMovieTime;
    @BindView(R.id.tw_director) public TextView textViewDirector;
    @BindView(R.id.tv_writers) public TextView textViewWritters;
    @BindView(R.id.tv_year) public TextView textViewYear;
    @BindView(R.id.tv_storyline) public TextView textViewStoryline;
    @BindView(R.id.tv_rel_date_info) public TextView textViewRelDateMoreInfo;
    @BindView(R.id.tv_country) public TextView textViewCountryOfOrigin;
    @BindView(R.id.tv_lag) public TextView textViewLanguaseSpoken;
    @BindView(R.id.tv_name_director) public TextView textViewLabelDirector;
    @BindView(R.id.text_two_details) public TextView textViewTwoDeatails;
    @BindView(R.id.tv_rating) public TextView textViewReviewsRating;

    @BindView(R.id.iw_poster) public ImageView imageViewPoster;

    @BindView(R.id.linearLayoutDirector) public LinearLayout linearLayoutDirectors;
    @BindView(R.id.linearLayoutWriters) public LinearLayout linearLayoutWriters;
    @BindView(R.id.container) public FrameLayout mFrameLayout;
    @BindView(R.id.relLayout1) public RelativeLayout mRelativeLayout;
    @BindView(R.id.relLayoutReviews) RelativeLayout relativeLayoutReviews;
    @BindView(R.id.relLayout5) public RelativeLayout getRelativeLayoutReviews;

    @BindView(R.id.recycler_view_list_image) public RecyclerView recyclerViewListImages;
    @BindView(R.id.recycler_view_list) public RecyclerView recyclerView;
    @BindView(R.id.recycler_view_cast) public RecyclerView recyclerViewCast;
    @BindView(R.id.recycler_view_reviews) public RecyclerView recyclerViewReviews;
    @BindView(R.id.recycler_view_similar) public RecyclerView recyclerViewSimilarMovies;
    @BindView(R.id.recycler_view_details_genre) public RecyclerView recyclerViewDetailsGenre;



    private ApiCalls apiCalls;

    List<String> trailers;
    List<String> videosIDs;
    List<Cast> castList;
    List<Crew> crewList;
    List<Image> imageList;
    List<Review> reviewList;
    List<Movie> similarMovieList;
    List<Genre> genreList;
    List<Tv> tvSimilarList;

   private TrailerListAdapter trailerListAdapter;
   private CastAdapter castAdapter;
   private ImageAdapter imageAdapter;
   private ReviewsListAdapter reviewsListAdapter;
   private MoviesAdapter similarMoviesAdapter;
   private ListAdapterDetailsGenres listAdapterDetailsGenres;
   private TvAdapter mSimilarTvAdapter;

    private Context mContext;


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        mContext = this;

        apiCalls = new ApiCalls();

        trailers = new ArrayList<>();
        videosIDs = new ArrayList<>();
        castList = new ArrayList<>();
        crewList = new ArrayList<>();
        imageList = new ArrayList<>();
        reviewList = new ArrayList<>();
        similarMovieList = new ArrayList<>();
        genreList = new ArrayList<>();
        tvSimilarList = new ArrayList<>();

        init();

    }



    @Override
    protected void onResume() {
        super.onResume();
    }





    public void setupSerieDetails(Intent intent){
        Tv tv = intent.getExtras().getParcelable("tv_extra");
        getRelativeLayoutReviews.setVisibility(View.GONE);
        linearLayoutWriters.setVisibility(View.GONE);
        textViewLabelDirector.setText("Executive Producer");
        textViewTwoDeatails.setText("Created By ");


        String title = tv.getName();
        String overview = tv.getOverview();
        Double aDouble = tv.getVoteAverage();
        String votes = aDouble + "/10";
        String releaseYear = tv.getFirstAirDate();
        List<Genre> genres = tv.getGenres();


        StringBuilder creators = new StringBuilder();
        for (int i = 0; i < tv.getCreatedBy().size(); i++) {
            creators.append(tv.getCreatedBy().get(i).getName());
            if (i !=tv.getCreatedBy().size() - 1) {
                creators.append(", ");
            }

        }

        textViewCountryOfOrigin.setText(creators.toString());



        long serieID = tv.getId();


        trailerListAdapter = new TrailerListAdapter(mContext, trailers,title,overview, videosIDs);
        setupRecyclerview(trailerListAdapter, recyclerView);

        castAdapter = new CastAdapter(mContext, castList);
        setupRecyclerview(castAdapter, recyclerViewCast);

        imageAdapter = new ImageAdapter(mContext, imageList);
        setupRecyclerview(imageAdapter, recyclerViewListImages);

        mSimilarTvAdapter = new TvAdapter(mContext,tvSimilarList);
        setupRecyclerview(mSimilarTvAdapter,recyclerViewSimilarMovies);



        listAdapterDetailsGenres = new ListAdapterDetailsGenres(mContext, genres);
        setupRecyclerview(listAdapterDetailsGenres,recyclerViewDetailsGenre);




        apiCalls.getTvTrailers(mContext, serieID, recyclerView, title,overview);

        apiCalls.getCastTv(mContext, serieID, recyclerViewCast);


        apiCalls.getTvCrew(mContext, serieID, textViewDirector, textViewWritters,
                linearLayoutDirectors);


        apiCalls.getTvImages(mContext, serieID, recyclerViewListImages);

        apiCalls.getTvSimilar(mContext,serieID,recyclerViewSimilarMovies);




        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < tv.getGenres().size(); i++) {
            builder.append(tv.getGenres().get(i).getName());
            if (i != tv.getGenres().size() - 1) {
                builder.append(", ");
            }

        }


        String lang = tv.getOriginalLanguage();
        textViewLanguaseSpoken.setText(lang);


        String relDate = DateFormatter.getDateFullMonthName(releaseYear);
        textViewRelDateMoreInfo.setText(relDate);
        relDate = DateFormatter.getDateYear(releaseYear);
        textViewYear.setText(relDate);



        String genre = builder.toString();
        textViewGenre.setText(genre);


        textViewTitle.setText(title);
        textViewDecription.setText(overview);
        textViewVote.setText(votes);


        textViewReviewsRating.setText(votes);
        textViewStoryline.setText(overview);


        String poster = "https://image.tmdb.org/t/p/w500" + tv.getPosterPath();

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(poster, imageViewPoster);

    }



    public void init() {
        Log.d(TAG, "init: ");
        Intent intent = getIntent();
        if (intent.hasExtra("movie_extra")) {
            setupMovieDetails(intent);
        }else if (intent.hasExtra("tv_extra")){
            setupSerieDetails(intent);

        }

    }



    public void setupMovieDetails(Intent intent){
        Movie  movie = intent.getExtras().getParcelable("movie_extra");
        getRelativeLayoutReviews.setVisibility(View.VISIBLE);
        textViewLabelDirector.setText("Director");
        textViewTwoDeatails.setText("Country of Origin");


        String title = movie.getTitle();
        String overview = movie.getOverview();
        Double aDouble = movie.getVote_average();
        String votes = aDouble + "/10";
        String releaseYear = movie.getRelease_date();
        List<Genre> genres = movie.getGenres();

        long movieID = movie.getId();

        trailerListAdapter = new TrailerListAdapter(mContext, trailers, title,overview,videosIDs);
        setupRecyclerview(trailerListAdapter, recyclerView);

        castAdapter = new CastAdapter(mContext, castList);
        setupRecyclerview(castAdapter, recyclerViewCast);


        imageAdapter = new ImageAdapter(mContext, imageList);
        setupRecyclerview(imageAdapter, recyclerViewListImages);

        similarMoviesAdapter = new MoviesAdapter(mContext,similarMovieList);
        setupRecyclerview(similarMoviesAdapter,recyclerViewSimilarMovies);

        reviewsListAdapter = new ReviewsListAdapter(mContext, reviewList);
        setupRecyclerview(reviewsListAdapter, recyclerViewReviews);

        listAdapterDetailsGenres = new ListAdapterDetailsGenres(mContext, genres);
        setupRecyclerview(listAdapterDetailsGenres,recyclerViewDetailsGenre);




        apiCalls.getMovieTrailers(mContext, movieID, recyclerView, title, overview);


        apiCalls.getCastMovies(mContext, movieID, recyclerViewCast);


        apiCalls.getCrew(mContext, movieID, textViewDirector, textViewWritters,
                linearLayoutDirectors, linearLayoutWriters);


        apiCalls.getMovieImages(mContext, movieID, recyclerViewListImages);


        apiCalls.getReviews(mContext, movieID,recyclerViewReviews);


        apiCalls.getMovieSimilar(mContext,movieID,recyclerViewSimilarMovies);


        int temp = movie.getRuntime();

        int hours = temp / 60;
        int min = temp % 60;
        String movieTime = hours + "h " + min + "m ";


        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < movie.getGenres().size(); i++) {
            builder.append(movie.getGenres().get(i).getName());
            if (i != movie.getGenres().size() - 1) {
                builder.append(", ");
            }

        }

        StringBuilder country = new StringBuilder();

        for (int i = 0; i < movie.getProduction_countries().size(); i++) {
            country.append(movie.getProduction_countries().get(i).getName());
            if (i != movie.getProduction_countries().size() - 1) {
                country.append(", ");
            }

        }

        String countrys = country.toString();
        textViewCountryOfOrigin.setText(countrys);

        StringBuilder lang = new StringBuilder();
        for (int i = 0; i < movie.getSpoken_languages().size(); i++) {
            lang.append(movie.getSpoken_languages().get(i).getName());
            if (i != movie.getSpoken_languages().size() - 1) {
                lang.append(", ");
            }

        }

        String langs = lang.toString();
        String relDate = DateFormatter.getDateFullMonthName(releaseYear);
        textViewLanguaseSpoken.setText(langs);
        textViewRelDateMoreInfo.setText(relDate);



        String genre = builder.toString();
        textViewGenre.setText(genre);


        textViewTitle.setText(title);
        textViewDecription.setText(overview);
        textViewVote.setText(votes);
        textViewMovieTime.setText(movieTime);
        relDate = DateFormatter.getDateYear(releaseYear);
        textViewYear.setText(relDate);
        textViewReviewsRating.setText(votes);
        textViewStoryline.setText(overview);


        String poster = "https://image.tmdb.org/t/p/w500" + movie.getPoster_path();


        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(poster, imageViewPoster);



    }





    public void hideLayout(){
        mRelativeLayout.setVisibility(View.GONE);
        mFrameLayout.setVisibility(View.VISIBLE);

    }


    public void showLayout(){
        mRelativeLayout.setVisibility(View.VISIBLE);
        mFrameLayout.setVisibility(View.GONE);
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        FragmentManager manager = getSupportFragmentManager();
        if (mFrameLayout.getVisibility() == View.VISIBLE && manager.getBackStackEntryCount() == 0){
            showLayout();
        }else {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }





    public void setupRecyclerview(RecyclerView.Adapter adapter, RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onGridImageSelected(Image image) {
        Bundle args = new Bundle();
        SelectedImageFragment selectedImageFragment = new SelectedImageFragment();
        args.putParcelable("image_selected", image);
        selectedImageFragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, selectedImageFragment);
        transaction.addToBackStack(getString(R.string.fragment_back_stack));
        transaction.commit();
    }
}
