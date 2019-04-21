package com.devwithbruno.www.movart.ui.adaptes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.network.api.ApiCalls;
import com.devwithbruno.www.movart.data.model.Cast;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Bruno on 28/11/2017.
 */

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.MyViewHolder> {

    private static final String TAG = "CastAdapter";

    private Context mContext;
    private List<Cast> castList;
    private ApiCalls apiCalls;

    public CastAdapter(Context mContext, List<Cast> castList) {
        this.mContext = mContext;
        this.castList = castList;
        apiCalls = new ApiCalls();
        Log.d(TAG, "CastAdapter: ");
    }

    @Override
    public CastAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cast_card,parent,false);
        Log.d(TAG, "onCreateViewHolder: ");
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        String name = castList.get(position).getName();
        String poster = "https://image.tmdb.org/t/p/w300" + castList.get(position).getProfile_path();
        String characterName = castList.get(position).getCharacter();
        Log.d(TAG, "onBindViewHolder: ");


        final long artistID = castList.get(position).getId();
        apiCalls.getArtist(mContext,artistID,holder.imgPoster, null);


        Log.d(TAG, "onBindViewHolder: "  + poster);

        //apiCalls.getTv(mContext,movieID,holder.imgPoster);

        holder.textViewCastName.setText(name);
        holder.textViewCharacterName.setText(characterName);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(poster, holder.imgPoster);

    }

    @Override
    public int getItemCount() {
        return castList.size();
    }








    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewCastName, textViewCharacterName;
        public ImageView imgPoster;


        public MyViewHolder(View itemView) {
            super(itemView);
            textViewCastName = (TextView) itemView.findViewById(R.id.tv_actor_name);
            textViewCharacterName = (TextView) itemView.findViewById(R.id.tv_character_name);
            imgPoster = (ImageView)itemView.findViewById(R.id.iv_cast_image);
            Log.d(TAG, "MyViewHolder: ");


        }
    }


}
