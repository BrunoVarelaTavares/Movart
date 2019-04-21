package com.devwithbruno.www.movart.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.devwithbruno.www.movart.R;

/**
 * Created by Bruno on 15/01/2018.
 */

public  final class Utils {

    private static final String TAG = "Utils";

    private Utils(){

    }


    public static ProgressDialog showLoadingDialog(Context context){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null){
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;



    }

}
