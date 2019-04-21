package com.devwithbruno.www.movart.utils;

import android.view.View;
import android.widget.ImageView;

/**
 * Created by Bruno on 22/01/2018.
 */

public class ImageAnimation {


    public static void checkImage(ImageView imageViewBookMark,ImageView imageViewAdd ,ImageView  imageViewBookMarkGreen, ImageView imageViewCheck){
        if (imageViewBookMark.getVisibility() == View.VISIBLE) {
            imageViewBookMark.setVisibility(View.GONE);
            imageViewAdd.setVisibility(View.GONE);
            imageViewBookMarkGreen.setVisibility(View.VISIBLE);
            imageViewCheck.setVisibility(View.VISIBLE);
        }

    }




    public static void unCheckImage(ImageView imageViewBookMarkGreen,ImageView imageViewCheck ,ImageView  imageViewBookMark, ImageView imageViewAdd){
        if (imageViewBookMarkGreen.getVisibility() == View.VISIBLE){
            imageViewBookMark.setVisibility(View.VISIBLE);
            imageViewAdd.setVisibility(View.VISIBLE);
            imageViewBookMarkGreen.setVisibility(View.GONE);
            imageViewCheck.setVisibility(View.GONE);


        }

    }

   /*
      holder.imageViewBookMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.imageViewBookMark.getVisibility() == View.VISIBLE) {
                    holder.imageViewBookMark.setVisibility(View.GONE);
                    holder.imageViewAdd.setVisibility(View.GONE);
                    holder.imageViewBookMarkGreen.setVisibility(View.VISIBLE);
                    holder.imageViewCheck.setVisibility(View.VISIBLE);
                }

            }
        });


        holder.imageViewBookMarkGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (holder.imageViewBookMarkGreen.getVisibility() == View.VISIBLE){
                    holder.imageViewBookMark.setVisibility(View.VISIBLE);
                    holder.imageViewAdd.setVisibility(View.VISIBLE);
                    holder.imageViewBookMarkGreen.setVisibility(View.GONE);
                    holder.imageViewCheck.setVisibility(View.GONE);


                }
            }
        });





     */



















}
