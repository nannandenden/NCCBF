package com.nccbf.android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import com.nccbf.android.R;

public class MyMapFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_map, container, false);

        return rootView;
    }

//    @Override
//    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
//        return paramLayoutInflater.inflate(R.layout.fragment_map, paramViewGroup, false);
//    }
}