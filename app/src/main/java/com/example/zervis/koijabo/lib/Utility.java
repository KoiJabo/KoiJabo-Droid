package com.example.zervis.koijabo.lib;

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

    public static String distanceString(int distance){
        String distanceString = "";
        if (distance<1000){
            distanceString = distance + "m away";
        }
        else if(distance>1000){
            distanceString = (distance/1000) + "km away";
        }
        return distanceString;
    }
}
