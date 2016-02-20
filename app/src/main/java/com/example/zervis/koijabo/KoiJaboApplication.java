package com.example.zervis.koijabo;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by tonmoy on 20-Feb-16.
 */
public class KoiJaboApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize the SDK before executing any other operations,
        // especially, if you're using Facebook UI elements.
        FacebookSdk.sdkInitialize(getApplicationContext());

    }
}
