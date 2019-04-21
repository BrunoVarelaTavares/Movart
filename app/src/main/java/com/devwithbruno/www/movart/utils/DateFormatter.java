package com.devwithbruno.www.movart.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bruno on 22/12/2017.
 */

public class DateFormatter {


    public static String getDateFullMonthName(String stringDate) {
        String finalString = "";
        try {
            SimpleDateFormat oldSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = oldSimpleDateFormat.parse(stringDate);
            System.out.println(date.toString());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM d, yyyy");
            finalString = simpleDateFormat.format(date);

        } catch (Exception e) {
            return "";

        }
        return finalString;
    }

    public static String getDateHalfMonthName(String stringDate) {
        String finalString = "";
        try {
            SimpleDateFormat oldSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = oldSimpleDateFormat.parse(stringDate);
            System.out.println(date.toString());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMM yyyy");
            finalString = simpleDateFormat.format(date);

        } catch (Exception e) {
            return "";

        }
        return finalString;
    }


    public static String getDateYear(String stringDate) {
        String finalString = "";
        try {
            SimpleDateFormat oldSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = oldSimpleDateFormat.parse(stringDate);
            System.out.println(date.toString());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            finalString = simpleDateFormat.format(date);

        } catch (Exception e) {
            return "";

        }
        return finalString;
    }


}
