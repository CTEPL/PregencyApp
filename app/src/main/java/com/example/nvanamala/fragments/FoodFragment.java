package com.example.nvanamala.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nvanamala.pregnencyapp.R;

/**
 * Created by nvanamala on 6/15/2016.
 */

public class FoodFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_home_fragment,null,false);
        return view;
    }
}
