package com.devwithbruno.www.movart.ui.artistsdetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.network.api.ApiCalls;
import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.ArtistCast;
import com.devwithbruno.www.movart.data.model.Image;
import com.devwithbruno.www.movart.ui.adaptes.ArtistsImageAdapter;
import com.devwithbruno.www.movart.utils.DateFormatter;
import com.devwithbruno.www.movart.utils.FilmographyListFragment;
import com.devwithbruno.www.movart.utils.GridImagesFragment;
import com.devwithbruno.www.movart.utils.SelectedImageFragment;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bruno on 17/12/2017.
 */

public class ArtistsActivity extends AppCompatActivity
        implements GridImagesFragment.OnGridImageSelectedListener{
//        , ArtistesAdapter.OnArtistsSelectedListener {


    private static final String TAG = "ArtistsActivity";


    @BindView(R.id.iv_poster)
    public ImageView imageViewPoster;

    @BindView(R.id.tv_name)
    public TextView textViewArtistName;


    @BindView(R.id.tv_know_for)
    public TextView textViewArtistKnowFor;


    @BindView(R.id.tv_bio)
    public TextView textViewArtistBio;


    @BindView(R.id.tv_birthday)
    public TextView textViewBirtday;

    @BindView(R.id.iv_one)
    public ImageView imageViewOne;

    @BindView(R.id.iv_two)
    public ImageView imageViewTwo;

    @BindView(R.id.iv_tree)
    public ImageView imageViewTree;

    @BindView(R.id.iv_four)
    public ImageView imageViewFour;

    @BindView(R.id.iv_more_img_tho)
    public ImageView imageViewMoreImages;


    @BindView(R.id.container)
    public FrameLayout mFrameLayout;

    @BindView(R.id.relLayout1)
    public RelativeLayout mRelativeLayout;

    @BindView(R.id.iv_poster_one)
    public ImageView imageViewPosterOne;

    @BindView(R.id.iv_poster_two)
    public ImageView imageViewPosterTwo;

    @BindView(R.id.iv_poster_three)
    public ImageView imageViewPosterThree;

    @BindView(R.id.ic_bookmark_one)
    public ImageView imageViewBookMarkOne;

    @BindView(R.id.ic_bookmark_two)
    public ImageView imageViewBookMarkTwo;


    @BindView(R.id.ic_bookmark_three)
    public ImageView imageViewBookMarkThree;


    @BindView(R.id.ic_add_one)
    public ImageView imageViewAddOne;

    @BindView(R.id.ic_add_two)
    public ImageView imageViewAddTwo;

    @BindView(R.id.ic_add_three)
    public ImageView imageViewAddThree;

    @BindView(R.id.ic_bookmark_green_one)
    public ImageView imageViewBookMarkGreenOne;

    @BindView(R.id.ic_bookmark_green_two)
    public ImageView imageViewBookMarkGreenTwo;

    @BindView(R.id.ic_bookmark_green_three)
    public ImageView imageViewBookMarkGreenThree;

    @BindView(R.id.ic_check_one)
    public ImageView imageViewCheckOne;

    @BindView(R.id.ic_check_two)
    public ImageView imageViewCheckTwo;

    @BindView(R.id.ic_check_three)
    public ImageView imageViewCheckThree;

    @BindView(R.id.tv_name_one)
    public TextView textViewNameOne;

    @BindView(R.id.tv_name_two)
    public TextView textViewNameTwo;


    @BindView(R.id.tv_name_three)
    public TextView textViewNameThree;

    @BindView(R.id.tv_year_one)
    public TextView textViewYearOne;

    @BindView(R.id.tv_year_two)
    public TextView textViewYearTwo;

    @BindView(R.id.tv_year_three)
    public TextView textViewYearThree;


    @BindView(R.id.tv_filmography)
    public TextView textViewFilmography;

    //tv_details_born_date
    @BindView(R.id.tv_details_born_date)
    public TextView textViewDetailsBornDate;


    @BindView(R.id.tv_details_name)
    public TextView textViewDetailsName;

    @BindView(R.id.relLayout3)
    public RelativeLayout relativeLayoutKnowFor;



    private Context mContext;


    @BindView(R.id.recycler_view_image_artists)
    public RecyclerView recyclerViewImageArtists;

    private List<Image> imageList;
    private ApiCalls apiCalls;
    private ArtistsImageAdapter artistsImageAdapter;


    private boolean isFragmentOne;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistes);
        ButterKnife.bind(this);
        mContext = this;
        Log.d(TAG, "onCreate: ");
        imageList = new ArrayList<>();
        apiCalls = new ApiCalls();
        init();
    }


    public void init() {
        Log.d(TAG, "init: ");
        Intent intent = getIntent();
        if (intent.hasExtra("artist_extra")) {
            Artist artist = intent.getExtras().getParcelable("artist_extra");
            final long artistsID = artist.getId();
            String name = artist.getName();


            String birthday = "";
            if (artist.getDeathday() == null) {
                String age = getAge(artist.getBirthday());
                String birthdayFormated = DateFormatter.getDateHalfMonthName(artist.getBirthday());
                birthday = birthdayFormated + " (age " + age + ")" + "\n"
                        + artist.getPlace_of_birth();
            } else {
                String age = getAge(artist.getBirthday(), artist.getDeathday());
                String birthdayFormated = DateFormatter.getDateHalfMonthName(artist.getBirthday());
                String dFormated = DateFormatter.getDateHalfMonthName(artist.getDeathday());
                birthday = birthdayFormated + "\n"
                        + artist.getPlace_of_birth() + "\n\n" +
                        "Died:\n" +
                        dFormated + " (age " + age + ")";

            }


            String bio = artist.getBiography();
            String poster = "https://image.tmdb.org/t/p/w500" + artist.getProfile_path();


            artistsImageAdapter = new ArtistsImageAdapter(mContext, imageList);
            setupRecyclerview(artistsImageAdapter, recyclerViewImageArtists);

            textViewArtistName.setText(name);
            textViewDetailsName.setText(name);
            if (artist.getBirthday() != null) {
                textViewBirtday.setText(birthday);
                textViewDetailsBornDate.setText(birthday);
            } else {

            }


            textViewArtistBio.setText(bio);


            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(poster, imageViewPoster);

            apiCalls.getArtistsImages(mContext, artistsID, recyclerViewImageArtists);
            apiCalls.getArtistsTaggedImages(mContext, artistsID, recyclerViewImageArtists);

            setupKnowFor(artistsID);



            textViewFilmography.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    hideLayout();
                    FilmographyListFragment filmographyListFragment = new FilmographyListFragment();
                    Bundle args = new Bundle();
                    args.putLong("artist_id", artistsID);
                    filmographyListFragment.setArguments(args);
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, filmographyListFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();


                }
            });
        }


        setupButtons(imageViewBookMarkOne,imageViewAddOne,imageViewBookMarkGreenOne,imageViewCheckOne);
        setupButtons(imageViewBookMarkTwo,imageViewAddTwo,imageViewBookMarkGreenTwo,imageViewCheckTwo);
        setupButtons(imageViewBookMarkThree,imageViewAddThree,imageViewBookMarkGreenThree,imageViewCheckThree);




    }




    private void setupKnowFor(long artistsID){
        Intent intent = getIntent();
        if (intent.hasExtra("artist_info")) {
            Artist artist = intent.getExtras().getParcelable("artist_info");
            if (artist.getKnown_for().size() == 0){
                    relativeLayoutKnowFor.setVisibility(View.GONE);
            }else {
                relativeLayoutKnowFor.setVisibility(View.VISIBLE);
            }



            Log.d(TAG, "setupKnowFor: sasasa" + artist.getKnown_for().size());
            for (int i = 0; i < 3; i++) {
                if (artist.getKnown_for().size() > i){
                    if (artist.getKnown_for().get(i).getOriginal_title() != null){
                        String name = artist.getKnown_for().get(i).getOriginal_title();
                        if (i == 0){
                            textViewNameOne.setText(name);
                        }else if (i == 1){
                            textViewNameTwo.setText(name);
                        }else{
                            textViewNameThree.setText(name);
                        }

                    }
                    if ( artist.getKnown_for().get(i).getRelease_date() != null){
                        String date = DateFormatter.getDateYear(artist.getKnown_for().get(i).getRelease_date());
                        if (i == 0){
                            textViewYearOne.setText(date);
                        }else if (i == 1){
                            textViewYearTwo.setText(date);
                        }else{
                            textViewYearThree.setText(date);
                        }
                    }
                    if ( artist.getKnown_for().get(i).getPoster_path() != null){
                        String poster = "https://image.tmdb.org/t/p/w500" + artist.getKnown_for().get(i).getPoster_path();
                        ImageLoader imageLoader = ImageLoader.getInstance();
                        if (i == 0){
                            imageLoader.displayImage(poster, imageViewPosterOne);
                        }else if (i == 1){
                            imageLoader.displayImage(poster, imageViewPosterTwo);
                        }else{
                            imageLoader.displayImage(poster, imageViewPosterThree);
                        }
                    }

                    if (artist.getKnown_for().get(i).getId() != -1){
                        long id =  artist.getKnown_for().get(i).getId();

                        if (i == 0){
                            onImageClick(imageViewPosterOne, id);
                        }else if (i == 1){
                            onImageClick(imageViewPosterTwo, id);
                        }else{
                            onImageClick(imageViewPosterThree, id);
                        }
                    }

                }


            }

//            String name = artist.getKnown_for().get(0).getOriginal_title();
//            artist.getKnown_for().get(0).getPosterPath();
//
//            String date = artist.getKnown_for().get(0).getRelease_date();
//            String d = DateFormatter.getDateYear(date);
//            textViewNameOne.setText(name);
//            textViewYearOne.setText(d);
//
//            String poster = "https://image.tmdb.org/t/p/w500" + artist.getKnown_for().get(0).getPosterPath();
//            ImageLoader imageLoader = ImageLoader.getInstance();
//            imageLoader.displayImage(poster, imageViewPosterOne);

        }else {
            apiCalls.getArtistCredits(mContext, artistsID);



        }

    }

    public void setupRecyclerview(RecyclerView.Adapter adapter, RecyclerView recyclerView) {
        Log.d(TAG, "setupRecyclerview: ");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();

    }


    private String getAge(String age) {
        String a = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar dob = Calendar.getInstance();
            dob.setTime(sdf.parse(age));
            a = "" + age(dob);
        } catch (Exception e) {

        }

        return a;
    }

    private String getAge(String age, String d) {
        String a = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar dob = Calendar.getInstance();
            dob.setTime(sdf.parse(age));
            a = "" + ages(dob, d);
        } catch (Exception e) {

        }

        return a;
    }


    private int age(Calendar dob) throws Exception {
        Calendar today = Calendar.getInstance();
        int curYear = today.get(Calendar.YEAR);
        int dobYear = dob.get(Calendar.YEAR);

        int age = curYear - dobYear;

        int curMonth = today.get(Calendar.MONTH);
        int dobMonth = dob.get(Calendar.MONTH);
        if (dobMonth > curMonth) {
            age--;
        } else if (dobMonth == curMonth) {
            int curDay = today.get(Calendar.DAY_OF_MONTH);
            int dobDay = dob.get(Calendar.DAY_OF_MONTH);
            if (dobDay > curDay) {
                age--;

            }
        }
        return age;

    }


    private int ages(Calendar dob, String date) throws Exception {
        String[] array = date.split("-");
        int curYear = Integer.parseInt(array[0]);
        int curMonth = Integer.parseInt(array[1]);
        int dobDay = Integer.parseInt(array[2]);


        Calendar today = Calendar.getInstance();
//        curYear = today.get(Calendar.YEAR);
        int dobYear = dob.get(Calendar.YEAR);

        int age = curYear - dobYear;

//        curMonth = today.get(Calendar.MONTH);
        int dobMonth = dob.get(Calendar.MONTH);
        if (dobMonth > curMonth) {
            age--;
        } else if (dobMonth == curMonth) {
            int curDay = today.get(Calendar.DAY_OF_MONTH);
//             dobDay = dob.get(Calendar.DAY_OF_MONTH);
            if (dobDay > curDay) {
                age--;

            }
        }
        return age;

    }


    public void getImages(final List<Image> imageList) {
        if (!imageList.isEmpty()) {
            if (imageList.size() > 0) {
                if (imageList.get(0).getFile_path() != null) {
                    String poster = "https://image.tmdb.org/t/p/w500" + imageList.get(0).getFile_path();
                    Log.d(TAG, "getImages: ->IMAGESPOS er " + poster);
                    ImageLoader imageLoader = ImageLoader.getInstance();
                    imageLoader.displayImage(poster, imageViewOne);
                    onImageClick(imageViewOne, imageList,0);
                }

            }

            if (imageList.size() > 1) {
                if (imageList.get(1).getFile_path() != null) {
                    String poster = "https://image.tmdb.org/t/p/w500" + imageList.get(1).getFile_path();
                    ImageLoader imageLoader = ImageLoader.getInstance();
                    imageLoader.displayImage(poster, imageViewTwo);
                    onImageClick(imageViewTwo, imageList,1);
                }

            }

            if (imageList.size() > 2) {
                if (imageList.get(2).getFile_path() != null) {
                    String poster = "https://image.tmdb.org/t/p/w500" + imageList.get(2).getFile_path();
                    ImageLoader imageLoader = ImageLoader.getInstance();
                    imageLoader.displayImage(poster, imageViewTree);
                    onImageClick(imageViewTree, imageList,2);
                }

            }


            if (imageList.size() > 3) {
                if (imageList.get(3).getFile_path() != null) {
                    String poster = "https://image.tmdb.org/t/p/w500" + imageList.get(3).getFile_path();
                    ImageLoader imageLoader = ImageLoader.getInstance();
                    imageLoader.displayImage(poster, imageViewFour);
                    onImageClick(imageViewFour, imageList,3);
                }

            }


            imageViewMoreImages.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    hideLayout();
                    Bundle args = new Bundle();
                    GridImagesFragment gridImagesFragment = new GridImagesFragment();
                    args.putParcelableArrayList("artists_images", (ArrayList<? extends Parcelable>) imageList);
                    gridImagesFragment.setArguments(args);
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, gridImagesFragment);
                    transaction.addToBackStack(getString(R.string.GridImagesFragmentBackStack));
                    transaction.commit();


                }
            });

        }


    }

    private void onImageClick(ImageView imageView, final List<Image> imageList,final int imagePosition){
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideLayout();
                Bundle args = new Bundle();
                GridImagesFragment gridImagesFragment = new GridImagesFragment();
                args.putParcelableArrayList("artists_images", (ArrayList<? extends Parcelable>) imageList);
                args.putInt("image_position", imagePosition);
                gridImagesFragment.setArguments(args);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, gridImagesFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });




    }






    public void hideLayout() {
        mRelativeLayout.setVisibility(View.GONE);
        mFrameLayout.setVisibility(View.VISIBLE);


    }


    public void showLayout() {
        mRelativeLayout.setVisibility(View.VISIBLE);
        mFrameLayout.setVisibility(View.GONE);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        FragmentManager manager = getSupportFragmentManager();
        if (mFrameLayout.getVisibility() == View.VISIBLE && manager.getBackStackEntryCount() == 0) {
            showLayout();
        }else {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

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

    public void onArtistSelect(List<ArtistCast> castList) {
        if (castList.size() == 0){
            relativeLayoutKnowFor.setVisibility(View.GONE);
        }else {
            relativeLayoutKnowFor.setVisibility(View.VISIBLE);
        }

        if (!castList.isEmpty()) {
            for (int i = 0; i < 3; i++) {
                if (castList.size() > i){
                    if (castList.get(i).getOriginal_title() != null){
                        String name = castList.get(i).getOriginal_title();
                        if (i == 0){
                            textViewNameOne.setText(name);
                        }else if (i == 1){
                            textViewNameTwo.setText(name);
                        }else{
                            textViewNameThree.setText(name);
                        }
                    }
                    if (castList.get(i).getRelease_date() != null){
                        String date = DateFormatter.getDateYear(castList.get(i).getRelease_date());
                        if (i == 0){
                            textViewNameOne.setText(date);
                        }else if (i == 1){
                            textViewNameTwo.setText(date);
                        }else{
                            textViewNameThree.setText(date);
                        }
                    }
                    if (castList.get(i).getPoster_path() != null){
                        String poster = "https://image.tmdb.org/t/p/w500" + castList.get(i).getPoster_path();
                        ImageLoader imageLoader = ImageLoader.getInstance();
                        if (i == 0){
                            imageLoader.displayImage(poster, imageViewPosterOne);
                        }else if (i == 1){
                            imageLoader.displayImage(poster, imageViewPosterTwo);
                        }else{
                            imageLoader.displayImage(poster, imageViewPosterThree);
                        }
                    }

                    if (castList.get(i).getId() != -1){
                        long id =  castList.get(i).getId();

                        if (i == 0){
                           onImageClick(imageViewPosterOne, id);
                        }else if (i == 1){
                            onImageClick(imageViewPosterTwo, id);
                        }else{
                            onImageClick(imageViewPosterThree, id);
                        }
                    }
                }
            }
        }


    }


    /**
     *
     * @param imageView
     * @param movieID
     */
    private void onImageClick(final ImageView imageView, final long movieID){
        apiCalls.getMovie(mContext,movieID,imageView);

    }


    private void setupButtons(final ImageView imageViewBookMark, final ImageView imageViewAdd,
                              final ImageView imageViewBookMarkGreen,final ImageView  imageViewCheck){
        imageViewBookMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imageViewBookMark.getVisibility() == View.VISIBLE) {
                    imageViewBookMark.setVisibility(View.GONE);
                    imageViewAdd.setVisibility(View.GONE);
                    imageViewBookMarkGreen.setVisibility(View.VISIBLE);
                    imageViewCheck.setVisibility(View.VISIBLE);
                }

            }
        });


        imageViewBookMarkGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (imageViewBookMarkGreen.getVisibility() == View.VISIBLE){
                    imageViewBookMark.setVisibility(View.VISIBLE);
                    imageViewAdd.setVisibility(View.VISIBLE);
                    imageViewBookMarkGreen.setVisibility(View.GONE);
                    imageViewCheck.setVisibility(View.GONE);


                }
            }
        });
    }




}
