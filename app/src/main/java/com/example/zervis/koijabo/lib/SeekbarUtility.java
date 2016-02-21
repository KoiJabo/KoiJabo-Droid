package com.example.zervis.koijabo.lib;

/**
 * Created by Zervis on 30/01/2016.
 */
public class SeekbarUtility {

    public static String foodSeekbarValue(int rating){

        switch (rating){
            case 0:
                return "Will Never Try Again";
            case 1:
                return "Might Try Again";
            case 2:
                return "Average";
            case 3:
                return "Pretty Good";
            case 4:
                return "Awesome";
            default:
                return "";
        }
    }

    public static String serviceSeekbarValue(int rating){

        switch (rating){
            case 0:
                return "Ridiculously Bad";
            case 1:
                return "Needs Improvement";
            case 2:
                return "Average";
            case 3:
                return "Good";
            case 4:
                return "Excellent";
            default:
                return "";
        }
    }

    public static String ambienceSeekbarValue(int rating){

        switch (rating){
            case 0:
                return "Couldn't hear myself";
            case 1:
                return "Loud ";
            case 2:
                return "OK ";
            case 3:
                return "Good Environment";
            case 4:
                return "Awesome Space";
            default:
                return "";
        }
    }

    public static String cleanlinessSeekbarValue(int rating){

        switch (rating){
            case 0:
                return "Bio Hazard";
            case 1:
                return "Needs Cleaning";
            case 2:
                return "Average";
            case 3:
                return "Pretty Clean";
            case 4:
                return "Very Clean";
            default:
                return "";
        }
    }

    public static String generalSeekbarValue(int rating) {
        switch (rating){
            case 0:
                return "Very bad";
            case 1:
                return "Bad";
            case 2:
                return "Average";
            case 3:
                return "Good";
            case 4:
                return "Awesome";
            default:
                return "";
        }
    }
}
