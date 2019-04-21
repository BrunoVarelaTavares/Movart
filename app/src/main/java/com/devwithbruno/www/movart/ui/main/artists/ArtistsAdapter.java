package com.devwithbruno.www.movart.ui.main.artists;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.model.Artist;
import com.devwithbruno.www.movart.ui.base.BaseViewHolder;
import com.devwithbruno.www.movart.utils.DateFormatter;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.wonderkiln.blurkit.BlurKit;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Bruno on 24/01/2018.
 */

public class ArtistsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final String TAG = "ArtistsAdapter";
    private List<Artist> artistList;

    public interface  OnImageSelectedListener{
        void onArtistImageSelect(long artistId, Artist artist);
    }

    public OnImageSelectedListener mOnImageSelectedListener;



    public ArtistsAdapter(List<Artist> artistList) {
        this.artistList = artistList;
    }


    public void setOnImageSelectedListener(OnImageSelectedListener mOnImageSelectedListener){
        this.mOnImageSelectedListener = mOnImageSelectedListener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_artists_activity_card,parent,false);
        return new ArtistsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);

    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }


    public void addArtist(List<Artist> artistList) {
        this.artistList.addAll(artistList);
        notifyDataSetChanged();
    }


    public void clearData(){
        this.artistList.clear();
        notifyDataSetChanged();

    }

    public class MyViewHolder extends BaseViewHolder{

//        private Context mContext;
//
        @BindView(R.id.imageBackgroundPoster)
        public ImageView imageViewBackgroundPoster;

        @BindView(R.id.textViewName)
        public TextView artistName;

        @BindView(R.id.imagePoster)
        public CircleImageView imgPoster;

        @BindView(R.id.textViewYearOfBirth)
        public TextView textViewYearOfBirth;

        @BindView(R.id.relLayoutFilm)
        public RelativeLayout relativeLayoutFilm;

        @BindView(R.id.relLayoutBio)
        public RelativeLayout relativeLayoutBio;

        @BindView(R.id.relLayoutImages)
        public RelativeLayout relativeLayoutImages;




        public MyViewHolder(View itemView) {
            super(itemView);
            BlurKit.init(itemView.getContext());
            ButterKnife.bind(this, itemView);

        }

        @Override
        protected void clear() {

        }



        @Override
        public void onBind(int position) {
            super.onBind(position);

            final Artist artist = artistList.get(position);

            if (artist.getName() != null){
               String name = artist.getName();
               artistName.setText(name);
            }

            if (artist.getProfile_path() != null){
                String posterBackground = "https://image.tmdb.org/t/p/w500" + artist.getProfile_path();
                ImageLoader imageLoader = ImageLoader.getInstance();

                imageLoader.displayImage(posterBackground, imageViewBackgroundPoster);
                String poster = "https://image.tmdb.org/t/p/w200" + artist.getProfile_path();
                imageLoader.displayImage(poster, imgPoster);
            }


            if (artist.getBirthday() != null){
                String date = DateFormatter.getDateHalfMonthName(artist.getBirthday());
                textViewYearOfBirth.setText(date);


            }




//            imgPoster.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (artist.getId() != -1 && mOnImageSelectedListener != null){
//                        long artistId = artist.getId();
//                        mOnImageSelectedListener.onArtistImageSelect(artistId, artist);
//
//
//                    }
//
//                }
//            });

        }
    }

}
