package com.example.zervis.koijabo.fragments;


import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zervis.koijabo.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogInDialog extends DialogFragment {


    public LogInDialog() {
        // Required empty public constructor
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.fragment_log_in_dialog, null));

        return builder.create();
    }

}
