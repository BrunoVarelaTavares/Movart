package com.devwithbruno.www.movart.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Bruno on 17/01/2018.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder{

    private int mCurrentPosition;
    private BaseActivity mBaseActivity;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    protected abstract void clear();


    public void onBind(int position){
        mCurrentPosition = position;
        clear();
    }


    public  int getCurrentPosition(){
        return mCurrentPosition;
    }


}
