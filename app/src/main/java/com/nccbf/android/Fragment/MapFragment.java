package com.nccbf.android.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.nccbf.android.R;

/**
 * Created by nanden on 2/17/15.
 */
public class MapFragment extends FragmentActivity{

    static final LatLng HAMBURG = new LatLng(53.558, 9.927);
    static final LatLng KIEL = new LatLng(53.551, 9.993);
    private GoogleMap map;

//    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //get the view from fragment_map.xml
        View view = inflater.inflate(R.layout.fragment_map, container,false);
//        map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
//        map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map))
//                .getMap();

//        Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG)
//                .title("Hamburg"));
//        Marker kiel = map.addMarker(new MarkerOptions()
//                .position(KIEL)
//                .title("Kiel")
//                .snippet("Kiel is cool")
//                .icon(BitmapDescriptorFactory
//                        .fromResource(R.drawable.nccbf_logo)));
//
//        // Move the camera instantly to hamburg with a zoom of 15.
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG, 15));
//
//        // Zoom in, animating the camera.
//        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

        return view;
    }

}
