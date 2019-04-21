package com.devwithbruno.www.movart.ui.adaptes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.devwithbruno.www.movart.R;
import com.devwithbruno.www.movart.data.network.api.ApiCalls;

import java.util.List;

/**
 * Created by Bruno on 09/12/2017.
 */

public class FilmographyListAdapter extends ArrayAdapter<String> {

    /**
     *
     * Esta classe nao esta a ser usada ainda
     * é para talvez fazer o card da All Filmography
     */



    private static final String TAG = "ListAdapterCrew";

    private LayoutInflater mInflater;
    private Context mContext;
    private int mLayoutResource;
    private List<String> names;
    private ApiCalls apiCalls;




    private static class ViewHolder{
        private TextView textViewName;
        private TextView textViewCount;
    }



    public FilmographyListAdapter(@NonNull Context context, int resource, List<String> names) {
        super(context, resource, names);
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayoutResource = resource;
        this.mContext = context;
        this.names = names;
        apiCalls = new ApiCalls();

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder holder;


        if (convertView == null){
            convertView = mInflater.inflate(mLayoutResource, parent, false);
            holder = new ViewHolder();
            holder.textViewName = (TextView)convertView.findViewById(R.id.tv_text);
//            holder.textViewCount = (TextView)convertView.findViewById(R.id.tv_count);


            convertView.setTag(holder);

        }else {


            holder = (ViewHolder) convertView.getTag();
        }


        String name = names.get(position);

        holder.textViewName.setText(name);


        return convertView;

    }
}
