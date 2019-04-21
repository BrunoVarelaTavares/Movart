package com.devwithbruno.www.movart.ui.adaptes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.network.api.ApiCalls;
import com.devwithbruno.www.movart.data.model.Crew;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Bruno on 09/12/2017.
 */

public class ListAdapterCrew extends ArrayAdapter<Crew> {

    private static final String TAG = "ListAdapterCrew";

    private LayoutInflater mInflater;
    private Context mContext;
    private int mLayoutResource;
    private List<Crew> crewList;
    private ApiCalls apiCalls;




    private static class ViewHolder{
        private ImageView image;
        private TextView textViewName;
        private TextView textViewDesc;

    }



    public ListAdapterCrew(@NonNull Context context, int resource, List<Crew> crewList) {
        super(context, resource, crewList);
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayoutResource = resource;
        this.mContext = context;
        this.crewList = crewList;
        apiCalls = new ApiCalls();

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder holder;


        if (convertView == null){
            convertView = mInflater.inflate(mLayoutResource, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView)convertView.findViewById(R.id.iv_image_post_list);
            holder.textViewName = (TextView)convertView.findViewById(R.id.tv_name);
            holder.textViewDesc = (TextView)convertView.findViewById(R.id.tv_desc);



            convertView.setTag(holder);

        }else {


            holder = (ViewHolder) convertView.getTag();
        }


        long artistID = crewList.get(position).getId();
        String name = crewList.get(position).getName();
        String desc = crewList.get(position).getJob();
        String poster = "https://image.tmdb.org/t/p/w500" + crewList.get(position).getProfile_path();
        Log.d("   ", "getView: poster " + poster);



        holder.textViewName.setText(name);
        holder.textViewDesc.setText(desc);


        apiCalls.getArtist(mContext,artistID,holder.image, null);


        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(poster, holder.image);









        return convertView;

    }
}
