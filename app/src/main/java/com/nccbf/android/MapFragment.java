package com.nccbf.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nanden on 2/17/15.
 */
public class MapFragment extends android.support.v4.app.Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //get the view from fragment_map.xml
        View view = inflater.inflate(R.layout.fragment_map, container,false);
        return view;
    }
}
