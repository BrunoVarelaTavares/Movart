package com.devwithbruno.www.movart.data.network.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.devwithbruno.www.movart.BuildConfig;
import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.data.model.ArtistCast;
import com.devwithbruno.www.movart.data.model.ArtistCastResponse;
import com.devwithbruno.www.movart.data.model.ArtistResponse;
import com.devwithbruno.www.movart.data.model.ArtistsImageResponse;
import com.devwithbruno.www.movart.data.model.Cast;
import com.devwithbruno.www.movart.data.model.CreditsResponse;
import com.devwithbruno.www.movart.data.model.Crew;
import com.devwithbruno.www.movart.data.model.Image;
import com.devwithbruno.www.movart.data.model.ImagesResponse;
import com.devwithbruno.www.movart.data.model.Movie;
import com.devwithbruno.www.movart.data.model.MovieResponse;
import com.devwithbruno.www.movart.data.model.Review;
import com.devwithbruno.www.movart.data.model.ReviewsResponse;
import com.devwithbruno.www.movart.data.model.TaggedImagesResponse;
import com.devwithbruno.www.movart.data.model.Trailer;
import com.devwithbruno.www.movart.data.model.TrailerResponse;
import com.devwithbruno.www.movart.data.model.Tv;
import com.devwithbruno.www.movart.data.model.TvResponse;
import com.devwithbruno.www.movart.ui.artistsdetails.ArtistsActivity;
import com.devwithbruno.www.movart.ui.video.VideoActivity;
import com.devwithbruno.www.movart.ui.adaptes.ArtistListAdapter;
import com.devwithbruno.www.movart.ui.adaptes.ArtistesAdapter;
import com.devwithbruno.www.movart.ui.adaptes.ArtistsImageAdapter;
import com.devwithbruno.www.movart.ui.adaptes.CastAdapter;
import com.devwithbruno.www.movart.ui.adaptes.GenreMoviesAdapter;
import com.devwithbruno.www.movart.ui.adaptes.ImageAdapter;
import com.devwithbruno.www.movart.ui.adaptes.MoviesAdapter;
import com.devwithbruno.www.movart.ui.adaptes.TvAdapter;
import com.devwithbruno.www.movart.ui.adaptes.ReviewsListAdapter;
import com.devwithbruno.www.movart.ui.adaptes.SlideUpAdapter;
import com.devwithbruno.www.movart.ui.adaptes.TrailerListAdapter;
import com.devwithbruno.www.movart.ui.adaptes.YoutubeImagesAdapter;
import com.devwithbruno.www.movart.ui.details.DetailsActivity;
import com.devwithbruno.www.movart.utils.ListFragment;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Bruno on 06/12/2017.
 */

public class ApiCalls {

    private static final String TAG = "ApiCalls";

    public void getPopularSeries(final Context mContext, final RecyclerView recyclerView) {
        Client client = new Client();
        TvService apiService = client.getClient().create(TvService.class);
        Observable<TvResponse> observable = apiService.getPopularSeries(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<TvResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: TVTV");
                
            }

            @Override
            public void onNext(TvResponse tvResponse) {
                List<Tv> series = tvResponse.getResults();
                Log.d(TAG, "onNext: TVTV -> " + series.toString());
                recyclerView.setAdapter(new TvAdapter(mContext, series));
              //  recyclerView.smoothScrollToPosition(0);

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: TVTV " + e.toString());

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: TVTV ");

            }
        });

    }


    public void getPopularArtists(final Context mContext, final RecyclerView recyclerView) {

        Client client = new Client();
        ArtistsService apiService = client.getClient().create(ArtistsService.class);
        Observable<ArtistResponse> observable = apiService.getPopularArtists(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<ArtistResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ArtistsF " );
                

            }

            @Override
            public void onNext(ArtistResponse artistResponse) {
                List<Artist> artists = artistResponse.getResults();
                 Log.d(TAG, "onNext: ArtistsF " + artists.size() );
                recyclerView.setAdapter(new ArtistesAdapter(mContext, artists));
              //  recyclerView.smoothScrollToPosition(0);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ArtistsF " + e.toString());

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ArtistsF ");

            }
        });


    }





    public void getMovie(final Context mContext, final long movieID, final View view) {
        Client client = new Client();
        MoviesService apiService = client.getClient().create(MoviesService.class);
        Observable<Movie> observable = apiService.getMovie(movieID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<Movie>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Movie movie) {
                if (movie != null) {
                    final Movie myMovie = movie;
                    Log.d(TAG, "DATAMOVIE: " + myMovie);
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(mContext, DetailsActivity.class);
                            intent.putExtra("movie_extra", myMovie);
                            mContext.startActivity(intent);

                        }
                    });

                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {


            }
        });


    }


    public void getArtist(final Context mContext, final long artistID, final View view, final Artist artistInfo) {
        Client client = new Client();
        ArtistsService apiService = client.getClient().create(ArtistsService.class);
        Observable<Artist> observable = apiService.getArtist(artistID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<Artist>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: QUERIA ");

            }

            @Override
            public void onNext(Artist artist) {
                if (artist != null) {
                    final Artist myArtist = artist;
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(mContext, ArtistsActivity.class);
                            intent.putExtra("artist_extra", myArtist);
                           // getArtistCredits(mContext, artistID, );
                            if (artistInfo != null){
                                intent.putExtra("artist_info", artistInfo);
                            }

                            mContext.startActivity(intent);

                        }
                    });
                }

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: QUERIA " + e.toString());

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: QUERIA ");

            }
        });

    }


    public void getArtistCredits(final Context mContext, final long artistID) {
        Client client = new Client();
        final ArtistsService apiService = client.getClient().create(ArtistsService.class);
        Observable<ArtistCastResponse> observable = apiService.getArtistsCredits(artistID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<ArtistCastResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: WSW ");

            }

            @Override
            public void onNext(ArtistCastResponse artistCastResponse) {
                if (artistCastResponse != null){
                  //  getArtistsCreditss(casts);
                    List<ArtistCast> casts = artistCastResponse.getCast();
                    ((ArtistsActivity)mContext).onArtistSelect(casts);



                }


            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: WSW");

            }

            @Override
            public void onComplete() {

            }
        });

    }



    /**
     * Ir directamente para a ArtistsActivity.class
     *
     * @param mContext
     * @param artistID
     */
    public void getArtistNow(final Context mContext, final long artistID) {
        Client client = new Client();
        ArtistsService apiService = client.getClient().create(ArtistsService.class);
        Observable<Artist> observable = apiService.getArtist(artistID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<Artist>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Artist artist) {
                if (artist != null) {
                    final Artist myArtist = artist;
                    Intent intent = new Intent(mContext, ArtistsActivity.class);
                    Log.d(TAG, "onNext: ADAR -> " +  myArtist.toString());
                    intent.putExtra("artist_extra", myArtist);
                    mContext.startActivity(intent);


                }

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: QUERIA " + e.toString());

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: QUERIA ");

            }
        });

    }


    public void getTv(final Context mContext, final long tvID, final View view) {
        Client client = new Client();
        TvService apiTvService = client.getClient().create(TvService.class);
        Observable<Tv> observable = apiTvService.getTv(tvID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<Tv>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Tv tv) {
                final Tv myTv = tv;
                if (myTv != null) {
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(mContext, DetailsActivity.class);
                            intent.putExtra("tv_extra", myTv);
                            mContext.startActivity(intent);


                        }
                    });


                }


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


    }


    public void getMovieTrailers(final Context mContext, final long movieID, final RecyclerView recyclerView, final String title, final String overview) {
        Client client = new Client();
        MoviesService apiService = client.getClient().create(MoviesService.class);
        final Observable<TrailerResponse> observable = apiService.getMovieTrailer(movieID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<TrailerResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: viva ");

            }

            @Override
            public void onNext(TrailerResponse trailerResponse) {
                Log.d(TAG, "onNext: viva ");
                List<Trailer> trailers = trailerResponse.getResult();
                List<String> trailersUrls = new ArrayList<>();
                List<String> videosID = new ArrayList<>();

                for (int i = 0; i < trailers.size(); i++) {
                    StringBuilder urlsVideo = new StringBuilder();
                    urlsVideo.append("https://img.youtube.com/vi/");
                    final String videoID = trailers.get(i).getKey();
                    videosID.add(videoID);
                    urlsVideo.append(videoID);
                    urlsVideo.append("/0.jpg");
                    trailersUrls.add(urlsVideo.toString());
                }

                recyclerView.setAdapter(new TrailerListAdapter(mContext, trailersUrls, title, overview, videosID));
//                recyclerView.smoothScrollToPosition(0);


            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: viva ");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete:  viva ");

            }
        });


    }

    public void getTvTrailers(final Context mContext, final long movieID, final RecyclerView recyclerView, final String title, final String overview) {
        Client client = new Client();
        TvService apiService = client.getClient().create(TvService.class);
        Observable<TrailerResponse> observable = apiService.getTvTrailer(movieID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<TrailerResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: viva ");

            }

            @Override
            public void onNext(TrailerResponse trailerResponse) {
                List<Trailer> trailers = trailerResponse.getResult();
                List<String> trailersUrls = new ArrayList<>();
                List<String> videosID = new ArrayList<>();

                for (int i = 0; i < trailers.size(); i++) {
                    StringBuffer urlsVideo = new StringBuffer();
                    urlsVideo.append("https://img.youtube.com/vi/");
                    final String videoID = trailers.get(i).getKey();
                    videosID.add(videoID);
                    urlsVideo.append(videoID);
                    urlsVideo.append("/0.jpg");
                    trailersUrls.add(urlsVideo.toString());
                }

                recyclerView.setAdapter(new TrailerListAdapter(mContext, trailersUrls, title, overview, videosID));
//                recyclerView.smoothScrollToPosition(0);


            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: viva ");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete:  viva ");

            }
        });


    }




    public void getMovieSimilar(final Context mContext, final long movieID, final RecyclerView recyclerView) {
        Client client = new Client();
        MoviesService apiService = client.getClient().create(MoviesService.class);
        Observable<MovieResponse> observable = apiService.getMovieSimilar(movieID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<MovieResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MovieResponse movieResponse) {
                List<Movie> movies = movieResponse.getMovies();
                recyclerView.setAdapter(new MoviesAdapter(mContext, movies));
             //   recyclerView.smoothScrollToPosition(0);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    public void getTvSimilar(final Context mContext, final long movieID, final RecyclerView recyclerView) {
        Client client = new Client();
        TvService apiService = client.getClient().create(TvService.class);
        Observable<TvResponse> observable = apiService.getTvSimilar(movieID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<TvResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: TV");
                
            }

            @Override
            public void onNext(TvResponse tvResponse) {
                List<Tv> tvs = tvResponse.getResults();
                Log.d(TAG, "onNext: TV ->" + tvs.toString());
                recyclerView.setAdapter(new TvAdapter(mContext, tvs));
            //    recyclerView.smoothScrollToPosition(0);

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: TV ");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: TV");

            }
        });
    }


    public void getMovieImages(final Context mContext, final long movieID, final RecyclerView recyclerView) {
        Client client = new Client();
        MoviesService apiService = client.getClient().create(MoviesService.class);
        Observable<ImagesResponse> observable = apiService.getMovieImages(movieID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<ImagesResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(ImagesResponse imagesResponse) {
                List<Image> images = imagesResponse.getPosters();
                recyclerView.setAdapter(new ImageAdapter(mContext, images));
              //  recyclerView.smoothScrollToPosition(0);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {


            }
        });


    }



    public void getTvImages(final Context mContext, final long movieID, final RecyclerView recyclerView) {
        Client client = new Client();
        TvService apiService = client.getClient().create(TvService.class);
        Observable<ImagesResponse> observable = apiService.getTvImages(movieID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<ImagesResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(ImagesResponse imagesResponse) {
                List<Image> images = imagesResponse.getPosters();
                recyclerView.setAdapter(new ImageAdapter(mContext, images));
              //  recyclerView.smoothScrollToPosition(0);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {


            }
        });


    }


    public void getArtistMovieCast(final Context mContext, final long artistID, final  RecyclerView recyclerView) {
        Client client = new Client();
        final ArtistsService apiService = client.getClient().create(ArtistsService.class);
        Observable<ArtistCastResponse> observable = apiService.getArtistMoviesCredits(artistID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<ArtistCastResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: WSW ");

            }

            @Override
            public void onNext(ArtistCastResponse artistCastResponse) {
                List<ArtistCast> artistCasts = artistCastResponse.getCast();
                if (!artistCasts.isEmpty()) {
                    recyclerView.setAdapter(new ArtistListAdapter(mContext, artistCasts));
                   // recyclerView.smoothScrollToPosition(0);

                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: WSW");

            }

            @Override
            public void onComplete() {

            }
        });

    }

    public void getArtistTVCast(final Context mContext, final long artistID, final  RecyclerView recyclerView) {
        Client client = new Client();
        final ArtistsService apiService = client.getClient().create(ArtistsService.class);
        Observable<ArtistCastResponse> observable = apiService.getArtistTVCredits(artistID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<ArtistCastResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: WSW ");

            }

            @Override
            public void onNext(ArtistCastResponse artistCastResponse) {
                List<ArtistCast> artistCasts = artistCastResponse.getCast();
                if (!artistCasts.isEmpty()) {
                    recyclerView.setAdapter(new ArtistListAdapter(mContext, artistCasts));
                    // recyclerView.smoothScrollToPosition(0);

                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: WSW");

            }

            @Override
            public void onComplete() {

            }
        });

    }










    public void getArtistsImages(final Context mContext, final long artistID, final RecyclerView recyclerView) {
        Client client = new Client();
        ArtistsService apiService = client.getClient().create(ArtistsService.class);
        Observable<ArtistsImageResponse> observable = apiService.getArtistsImages(artistID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<ArtistsImageResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArtistsImageResponse artistsImageResponse) {
                List<Image> images = artistsImageResponse.getProfiles();
                if (!images.isEmpty()) {
                    recyclerView.setAdapter(new ArtistsImageAdapter(mContext, images));
                   // recyclerView.smoothScrollToPosition(0);
//                    ((ArtistsActivity)mContext).getImages(images);

                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


    }


    public void getArtistsTaggedImages(final Context mContext, final long artistID, final RecyclerView recyclerView) {
        Client client = new Client();
        ArtistsService apiService = client.getClient().create(ArtistsService.class);
        Observable<TaggedImagesResponse> observable = apiService.getArtistsTaggedImages(artistID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<TaggedImagesResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TaggedImagesResponse taggedImagesResponse) {
                Log.d(TAG, "onNext: VEER ");
                List<Image> images = taggedImagesResponse.getResults();
                if (!images.isEmpty()) {
                    Log.d(TAG, "onNext: VEER " + images.size());
//                    recyclerView.setAdapter(new ArtistsImageAdapter(mContext, images));
//                    recyclerView.smoothScrollToPosition(0);
                    ((ArtistsActivity) mContext).getImages(images);


                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


    }


    public void getCastMovies(final Context mContext, final long movieID, final RecyclerView recyclerView) {

        Client client = new Client();
        MoviesService apiService = client.getClient().create(MoviesService.class);
        Observable<CreditsResponse> observable = apiService.getMovieCredits(movieID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<CreditsResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: DIAS");

            }

            @Override
            public void onNext(CreditsResponse creditsResponse) {
                Log.d(TAG, "onNext: DIAS");
                List<Cast> cast = creditsResponse.getCast();
                recyclerView.setAdapter(new CastAdapter(mContext, cast));


            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: DIAS");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: DIAS ");

            }
        });


    }


    public void getCastTv(final Context mContext, final long tvID, final RecyclerView recyclerView) {

        Client client = new Client();
        TvService apiService = client.getClient().create(TvService.class);
        Observable<CreditsResponse> observable = apiService.getTvCredits(tvID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<CreditsResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: DIAS");

            }

            @Override
            public void onNext(CreditsResponse creditsResponse) {
                Log.d(TAG, "onNext: DIAS");
                List<Cast> cast = creditsResponse.getCast();
                recyclerView.setAdapter(new CastAdapter(mContext, cast));


            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: DIAS");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: DIAS ");

            }
        });


    }


    public void getCastForGenre(final Context mContext, final long movieID, final TextView view) {

        Client client = new Client();
        MoviesService apiService = client.getClient().create(MoviesService.class);
        Observable<CreditsResponse> observable = apiService.getMovieCredits(movieID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<CreditsResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: DIAS");


            }

            @Override
            public void onNext(CreditsResponse creditsResponse) {
                Log.d(TAG, "onNext: DIAS");
                StringBuilder names = new StringBuilder();
                if (creditsResponse != null && creditsResponse.getCast().size() >= 5) {
                    for (int i = 0; i < 5; i++) {
                        names.append(creditsResponse.getCast().get(i).getName());
                        if (i != 4) {
                            names.append(", ");
                        }

                    }
                    view.setText(names);

                }

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: DIAS");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: DIAS ");

            }
        });


    }


    public void getMoviesByGenre(final Context mContext, final long genreID, final RecyclerView recyclerView) {

        Client client = new Client();
        MoviesService apiService = client.getClient().create(MoviesService.class);
        Observable<MovieResponse> observable = apiService.getMovieByGenre(genreID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<MovieResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: GER");

            }

            @Override
            public void onNext(MovieResponse movieResponse) {
                List<Movie> movies = movieResponse.getMovies();
                Log.d(TAG, "onNext: GER " + movies.toString());
                recyclerView.setAdapter(new GenreMoviesAdapter(mContext, movies));
//                recyclerView.smoothScrollToPosition(0);

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: GER ");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: GER ");

            }
        });


    }


    public void getSeriesByGenre(final Context mContext, final long genreID, final RecyclerView recyclerView) {

        Client client = new Client();
        MoviesService apiService = client.getClient().create(MoviesService.class);
        Observable<MovieResponse> observable = apiService.getMovieByGenre(genreID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<MovieResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: GER");

            }

            @Override
            public void onNext(MovieResponse movieResponse) {
                List<Movie> movies = movieResponse.getMovies();
                Log.d(TAG, "onNext: GER " + movies.toString());
                recyclerView.setAdapter(new GenreMoviesAdapter(mContext, movies));
//                recyclerView.smoothScrollToPosition(0);

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: GER ");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: GER ");

            }
        });


    }


    public void getReviews(final Context mContext, final long movieID, final RecyclerView recyclerView) {
        Client client = new Client();
        MoviesService apiService = client.getClient().create(MoviesService.class);
        Observable<ReviewsResponse> observable = apiService.getMovieReviews(movieID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<ReviewsResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ReviewsResponse reviewsResponse) {
                List<Review> reviews = reviewsResponse.getResults();
                recyclerView.setAdapter(new ReviewsListAdapter(mContext, reviews));
                recyclerView.smoothScrollToPosition(0);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }


    public void getCrew(final Context mContext, final long movieID, final TextView textViewDirector,
                        final TextView textViewWritters, final LinearLayout linearLayoutDirectors,
                        final LinearLayout linearLayoutWriters) {
        Client client = new Client();
        final MoviesService apiService = client.getClient().create(MoviesService.class);
        Observable<CreditsResponse> observable = apiService.getMovieCredits(movieID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<CreditsResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");

            }

            @Override
            public void onNext(CreditsResponse creditsResponse) {
                List<Crew> crews = creditsResponse.getCrew();
                Log.d(TAG, "onNext: ");

                if (crews != null) {
                    StringBuilder builderDirectors = new StringBuilder();
                    StringBuilder builderWritters = new StringBuilder();

                    final ArrayList<Crew> writers = new ArrayList<>();
                    final ArrayList<Crew> directors = new ArrayList<>();

                    for (int i = 0; i < crews.size(); i++) {
                        Log.d(TAG, "onNext: MEU For" + crews.get(i).getJob() + " " + crews.get(i).getName());
                        if (crews.get(i).getJob().equals("Director")) {
                            Crew crew = crews.get(i);
                            directors.add(crew);
                        } else if (crews.get(i).getDepartment().equals("Writing")) {
                            Crew crew = new Crew();
                            crew.setId(crews.get(i).getId());
                            crew.setName(crews.get(i).getName());
                            crew.setJob(crews.get(i).getJob());
                            crew.setProfile_path(crews.get(i).getProfile_path());
                            Log.d(TAG, "onNext: Membro " + crew.toString());
                            writers.add(crew);


                        }
                    }


                    if (directors.size() > -1) {
                        for (int i = 0; i < directors.size(); i++) {
                            builderDirectors.append(directors.get(i).getName());
                            if (i != directors.size() - 1) {
                                builderDirectors.append(", ");
                            }

                        }

                    }


                    if (writers.size() > -1) {
                        for (int i = 0; i < writers.size(); i++) {
                            builderWritters.append(writers.get(i).getName());
                            if (i != writers.size() - 1) {
                                builderWritters.append(", ");
                            }

                            if (i > 2) {
                                builderWritters.append(" and others");
                                break;
                            }

                        }

                    }


                    for (int i = 0; i < writers.size(); i++) {
                        Log.d(TAG, "onNext: " + writers.toString());

                    }


                    String dir = builderDirectors.toString();
                    final String writt = builderWritters.toString();


                    textViewDirector.setText(dir);
                    textViewWritters.setText(writt);


                    linearLayoutDirectors.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            //Se o numero de directores for 1 vai directamente para a Activity Artistas
                            if (directors.size() == 1) {
                                long id = directors.get(0).getId();
                                getArtistNow(mContext, id);
                            } else {
                                Bundle args = new Bundle();
                                ListFragment listFragment = new ListFragment();
                                FragmentTransaction transaction = ((DetailsActivity) mContext).getSupportFragmentManager().beginTransaction();
                                args.putParcelableArrayList("crew_list_directors", directors);
                                listFragment.setArguments(args);
                                ((DetailsActivity) mContext).hideLayout();
                                transaction.setCustomAnimations(R.anim.slide_in_left,
                                        R.anim.slide_out_left,
                                        R.anim.slide_in_right,
                                        R.anim.slide_out_right);
                                transaction.replace(R.id.container, listFragment);
                                transaction.addToBackStack(null);
                                transaction.commit();

//                            intent.putParcelableArrayListExtra("crew_list", (ArrayList<? extends Parcelable>) directors);

//                            mContext.startActivity(intent);

                            }

                        }
                    });


                    linearLayoutWriters.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (writers.size() == 1) {
                                long id = writers.get(0).getId();
                                getArtistNow(mContext, id);
                            } else {

                                Bundle args = new Bundle();
                                args.putParcelableArrayList("crew_list_writers", writers);
                                ListFragment listFragment2 = new ListFragment();
                                listFragment2.setArguments(args);
                                ((DetailsActivity) mContext).hideLayout();
                                FragmentTransaction transaction = ((DetailsActivity) mContext)
                                        .getSupportFragmentManager().beginTransaction();
                                transaction.setCustomAnimations(R.anim.slide_in_left,
                                        R.anim.slide_out_left,
                                        R.anim.slide_in_right,
                                        R.anim.slide_out_right);
                                transaction.add(R.id.container, listFragment2);
                                transaction.addToBackStack(null);
                                transaction.commit();

                            }

                        }
                    });


                }


            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");

            }
        });


    }


    public void getTvCrew(final Context mContext, final long movieID, final TextView textViewDirector,
                        final TextView textViewWritters, final LinearLayout linearLayoutDirectors) {
        Client client = new Client();
        final TvService apiService = client.getClient().create(TvService.class);
        Observable<CreditsResponse> observable = apiService.getTvCredits(movieID, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<CreditsResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");

            }

            @Override
            public void onNext(CreditsResponse creditsResponse) {
                List<Crew> crews = creditsResponse.getCrew();
                Log.d(TAG, "onNext: ");

                if (crews != null) {
                    StringBuilder builderDirectors = new StringBuilder();
                    StringBuilder builderWritters = new StringBuilder();

                    final ArrayList<Crew> writers = new ArrayList<>();
                    final ArrayList<Crew> directors = new ArrayList<>();

                    for (int i = 0; i < crews.size(); i++) {
                        Log.d(TAG, "onNext: MEU For" + crews.get(i).getJob() + " " + crews.get(i).getName());
                        if (crews.get(i).getJob().equals("Executive Producer")) {
                            Crew crew = crews.get(i);
                            directors.add(crew);
                        }
//                        else if (crews.get(i).getDepartment().equals("Writing")) {
//                            Crew crew = new Crew();
//                            crew.setId(crews.get(i).getId());
//                            crew.setName(crews.get(i).getName());
//                            crew.setJob(crews.get(i).getJob());
//                            crew.setProfile_path(crews.get(i).getProfile_path());
//                            Log.d(TAG, "onNext: Membro " + crew.toString());
//                            writers.add(crew);
//
//
//                        }
                    }


                    if (directors.size() > -1) {
                        for (int i = 0; i < directors.size(); i++) {
                            builderDirectors.append(directors.get(i).getName());
                            if (i != directors.size() - 1) {
                                builderDirectors.append(", ");
                            }

                        }

                    }
                    if (directors.size() == 0){
                        linearLayoutDirectors.setVisibility(View.GONE);
                    }


//                    if (writers.size() > -1) {
//                        for (int i = 0; i < writers.size(); i++) {
//                            builderWritters.append(writers.get(i).getName());
//                            if (i != writers.size() - 1) {
//                                builderWritters.append(", ");
//                            }
//
//                            if (i > 2) {
//                                builderWritters.append(" and others");
//                                break;
//                            }
//
//                        }
//
//                    }




                    String dir = builderDirectors.toString();
                    final String writt = builderWritters.toString();


                    textViewDirector.setText(dir);
                    textViewWritters.setText(writt);


                    linearLayoutDirectors.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d(TAG, "onClick: syh" +directors.size());
                            //Se o numero de directores for 1 vai directamente para a Activity Artistas
                            if (directors.size() == 1) {
                                long id = directors.get(0).getId();
                                getArtistNow(mContext, id);
                            } else {
                                Bundle args = new Bundle();
                                ListFragment listFragment = new ListFragment();
                                FragmentTransaction transaction = ((DetailsActivity) mContext).getSupportFragmentManager().beginTransaction();
                                args.putParcelableArrayList("crew_list_directors", directors);
                                listFragment.setArguments(args);
                                ((DetailsActivity) mContext).hideLayout();
                                transaction.setCustomAnimations(R.anim.slide_in_left,
                                        R.anim.slide_out_left,
                                        R.anim.slide_in_right,
                                        R.anim.slide_out_right);
                                transaction.replace(R.id.container, listFragment);
                                transaction.addToBackStack(null);
                                transaction.commit();

//                            intent.putParcelableArrayListExtra("crew_list", (ArrayList<? extends Parcelable>) directors);

//                            mContext.startActivity(intent);

                            }

                        }
                    });




//                    linearLayoutWriters.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//
//                            if (writers.size() == 1) {
//                                long id = writers.get(0).getId();
//                                getArtistNow(mContext, id);
//                            } else {
//
//                                Bundle args = new Bundle();
//                                args.putParcelableArrayList("crew_list_writers", writers);
//                                ListFragment listFragment2 = new ListFragment();
//                                listFragment2.setArguments(args);
//                                ((DetailsActivity) mContext).hideLayout();
//                                FragmentTransaction transaction = ((DetailsActivity) mContext)
//                                        .getSupportFragmentManager().beginTransaction();
//                                transaction.setCustomAnimations(R.anim.slide_in_left,
//                                        R.anim.slide_out_left,
//                                        R.anim.slide_in_right,
//                                        R.anim.slide_out_right);
//                                transaction.add(R.id.container, listFragment2);
//                                transaction.addToBackStack(null);
//                                transaction.commit();
//
//                            }
//
//                        }
//                    });


                }


            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");

            }
        });


    }


    public void getPopularMovies(final Context mContext, final RecyclerView recyclerView) {

        Client client = new Client();
        MoviesService apiService = client.getClient().create(MoviesService.class);
        Observable<MovieResponse> observable = apiService.getPopularMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<MovieResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MovieResponse movieResponse) {
                List<Movie> movies = movieResponse.getMovies();
                Log.d(TAG, "onNext: GENRES " + movies.get(0));
                recyclerView.setAdapter(new MoviesAdapter(mContext, movies));
                recyclerView.smoothScrollToPosition(0);


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {


            }
        });


    }


    public void getUpcomingMovies(final Context mContext, final RecyclerView recyclerView) {

        Client client = new Client();
        MoviesService apiService = client.getClient().create(MoviesService.class);
        Observable<MovieResponse> observable = apiService.getUpcomingMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());


        observable.subscribe(new Observer<MovieResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MovieResponse movieResponse) {
                List<Movie> movies = movieResponse.getMovies();

                recyclerView.setAdapter(new YoutubeImagesAdapter(mContext, movies));
                // recyclerView.smoothScrollToPosition(0);


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }


    public void getTrailers(final Context mContext, final List<Movie> movieList,
                            int position, final ImageView imageView, final View view) {
        final Movie movie = movieList.get(position);
        final String positionTamanho = (position + 1) + " de " + movieList.size();

        Client client = new Client();
        MoviesService apiService = client.getClient().create(MoviesService.class);
        Observable<TrailerResponse> observable = apiService.getMovieTrailer(movieList.get(position).getId(), BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<TrailerResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TrailerResponse trailerResponse) {
                final List<Trailer> trailers = trailerResponse.getResult();
                try {
                    StringBuilder urlsVideo = new StringBuilder();
                    urlsVideo.append("https://img.youtube.com/vi/");
                    if (trailers.size() >= 0) {
                        if (trailers.get(0).getKey() != null) {
                            urlsVideo.append(trailers.get(0).getKey());
                        } else if (trailers.get(1).getKey() != null) {
                            urlsVideo.append(trailers.get(1).getKey());
                        }
                    } else {
                        urlsVideo.append("");
                    }


                    urlsVideo.append("/0.jpg");
                    String urls = urlsVideo.toString();


                    ImageLoader imageLoader = ImageLoader.getInstance();
                    imageLoader.displayImage(urls, imageView);


                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (trailers.size() >= 0) {
                                Intent intent = new Intent(mContext, VideoActivity.class);
                                intent.putExtra(String.valueOf(R.string.movie_youtube_id), trailers.get(0).getKey());
                                intent.putExtra("movie_extra", movie);
                                intent.putExtra("position", positionTamanho);
                                intent.putParcelableArrayListExtra(String.valueOf(R.string.upcoming_movies_extra),
                                        (ArrayList<? extends Parcelable>) movieList);

                                mContext.startActivity(intent);
                            }
                        }
                    });


                }catch (IndexOutOfBoundsException e){

                }


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {


            }
        });


    }


    public void getUpcomingMoviesSlide(final Context mContext, final RecyclerView recyclerView) {
        Client client = new Client();
        MoviesService apiService = client.getClient().create(MoviesService.class);
        Observable<MovieResponse> observable = apiService.getUpcomingMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());


        observable.subscribe(new Observer<MovieResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MovieResponse movieResponse) {
                List<Movie> movies = movieResponse.getMovies();
                recyclerView.setAdapter(new SlideUpAdapter(mContext, movies));
                recyclerView.smoothScrollToPosition(0);


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


//    final Movie  movie = movieList.get(position);
//    final String positionTamanho = (position+1) + " de "  + movieList.size();
//
//
//    Client client = new Client();
//    MoviesService apiService = client.getClient().create(MoviesService.class);
//    Observable<TrailerResponse> observable = apiService.getMovieTrailer(movieList.get(position).getId(), BuildConfig.THE_MOVIE_DB_API_TOKEN)
//            .subscribeOn(Schedulers.newThread())
//            .observeOn(AndroidSchedulers.mainThread());
//        observable.subscribe(new Observer<TrailerResponse>() {
//        @Override
//        public void onSubscribe(Disposable d) {
//
//        }
//
//        @Override
//        public void onNext(TrailerResponse trailerResponse) {
//            final List<Trailer> trailers = trailerResponse.getResult();
//            StringBuilder urlsVideo = new StringBuilder();
//            urlsVideo.append("https://img.youtube.com/vi/");
//            if (trailers.size() >= 0) {
//                if (trailers.get(0).getKey() != null) {
//                    urlsVideo.append(trailers.get(0).getKey());
//                } else if (trailers.get(1).getKey() != null) {
//                    urlsVideo.append(trailers.get(1).getKey());
//                }
//            } else {
//                urlsVideo.append("");
//            }
//
//
//            urlsVideo.append("/0.jpg");
//            String urls = urlsVideo.toString();
//            Log.d(TAG, "onNext: BBB URLS " + urls);
//
//
//            holder.imageViewPlay.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (trailers.size() >= 0) {
//                        Intent intent = new Intent(mContext, VideoActivity.class);
//                        intent.putExtra(String.valueOf(R.string.movie_youtube_id), trailers.get(0).getKey());
//                        intent.putExtra("movie_extra", movie);
//                        intent.putExtra("position", positionTamanho);
//                        mContext.startActivity(intent);
//                    }
//                }
//            });
//
//
//
//            ImageLoader imageLoader = ImageLoader.getInstance();
//            imageLoader.displayImage(urls, holder.imgPosterYoutubeVideo);
//
//
//        }
//
//        @Override
//        public void onError(Throwable e) {
//
//        }
//
//        @Override
//        public void onComplete() {
//
//
//        }
//    });


}
