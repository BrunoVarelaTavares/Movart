package com.devwithbruno.www.movart.ui.adaptes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.network.api.ApiCalls;
import com.devwithbruno.www.movart.data.model.ArtistCast;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Bruno on 28/11/2017.
 */

public class ArtistListAdapter extends RecyclerView.Adapter<ArtistListAdapter.MyViewHolder> {

    private static final String TAG = "GenreMoviesAdapter";

    private Context mContext;
    private List<ArtistCast> artistCasts;
    private ApiCalls apiCalls;

    public ArtistListAdapter(Context mContext, List<ArtistCast> artistCasts) {
        Log.d(TAG, "GenreMoviesAdapter: ");
        this.mContext = mContext;
        this.artistCasts = artistCasts;
        apiCalls = new ApiCalls();
    }

    @Override
    public ArtistListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_artist_list_card,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        String original_title = artistCasts.get(position).getOriginal_title();
        String originalName = artistCasts.get(position).getOriginal_name();
        String characterName = artistCasts.get(position).getCharacter();
        final long ID = artistCasts.get(position).getId();


        //Aqui fazer melhor é para ir para os filmes ou series na fimografia
        if (original_title == null){
            holder.textViewName.setText(originalName);
            apiCalls.getTv(mContext, ID, holder.relativeLayout);
        }else {
            holder.textViewName.setText(original_title);
            apiCalls.getMovie(mContext,ID,holder.relativeLayout);
        }





       holder.textViewCharacterName.setText(characterName);


        String poster = "https://image.tmdb.org/t/p/w500" + artistCasts.get(position).getPoster_path();

        Log.d(TAG, "onBindViewHolder: "  + poster);



         // Falta meter aqui se nao for um filme pode ser uma serie ver depois


//       apiCalls.getCastForGenre(mContext,movieID, holder.textViewCast);






        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(poster, holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return artistCasts.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName,textViewCharacterName;
        public ImageView imgPoster;
        public RelativeLayout relativeLayout;



        public MyViewHolder(View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.tv_name);
            textViewCharacterName = (TextView)itemView.findViewById(R.id.tv_character_name);
            imgPoster = (ImageView)itemView.findViewById(R.id.iv_image_genre_list);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relLayout1);


        }
    }


}
