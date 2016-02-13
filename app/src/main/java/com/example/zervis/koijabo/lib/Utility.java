package com.example.zervis.koijabo.lib;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import java.util.ArrayList;

/**
 * Created by Zarvis on 09/02/2016.
 */
public class Utility {
    public static String listToStringBuilder(ArrayList<String> stringList){
        String string = "";
        for (int i=0; i< stringList.size(); i++){
            string += stringList.get(i) + " ";
        }
        return string;
    }

    public static String distanceString(Double distance){
        String distanceString = "";
        distanceString = String.format("%.02f km away",distance);


        return distanceString;
    }

    public static  String listToStringbuilderWithNewLine(ArrayList<String> stringArrayList){
        String string = "";
        for(int i = 0; i< stringArrayList.size(); i++){
            string += stringArrayList.get(i)+"\n";
        }
        return string;
    }

    public static String ratingText(double rating){
        if (rating > 0 && rating < 2)
            return "Not Good";
        else if (2 <= rating && rating <= 3)
            return "Average";
        else if (rating <= 4)
            return "Good";
        else if (rating == 5)
            return "Excelent";
        else
            return "Not Rated yet";
    }


}
