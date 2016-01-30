package com.example.zervis.koijabo.lib;

/**
 * Created by Zervis on 30/01/2016.
 */
public class SeekbarUtility {

    public static String foodSeekbarValue(int rating){

        switch (rating){
            case 1:
                return "Will Never Try Again";
            case 2:
                return "Might Try Again";
            case 3:
                return "Average";
            case 4:
                return "Pretty Good";
            case 5:
                return "Awesome";
            default:
                return "";
        }
    }

    public static String serviceSeekbarValue(int rating){

        switch (rating){
            case 1:
                return "Ridiculously Bad";
            case 2:
                return "Needs Improvement";
            case 3:
                return "Average";
            case 4:
                return "Good";
            case 5:
                return "Excellent";
            default:
                return "";
        }
    }

    public static String ambienceSeekbarValue(int rating){

        switch (rating){
            case 1:
                return "Couldn't hear myself";
            case 2:
                return "Loud ";
            case 3:
                return "OK ";
            case 4:
                return "Good Environment";
            case 5:
                return "Awesome Space";
            default:
                return "";
        }
    }

    public static String cleanlinessSeekbarValue(int rating){

        switch (rating){
            case 1:
                return "Bio Hazard";
            case 2:
                return "Needs Cleaning";
            case 3:
                return "Average";
            case 4:
                return "Pretty Clean";
            case 5:
                return "Very Clean";
            default:
                return "";
        }
    }
}
