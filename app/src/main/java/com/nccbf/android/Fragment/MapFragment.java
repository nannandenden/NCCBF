package com.nccbf.android.fragment;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nccbf.android.R;

/**
 * Created by nanden on 2/17/15.
 */
public class MapFragment extends Fragment {

    //Japantown Peace Plaza 37.785309, -122.429744
    //Japantown Task Force  37.786379, -122.429301

    static final LatLng PEACEPLAZA = new LatLng(37.785309, -122.429744);
    static final LatLng TASKFORCE = new LatLng(37.786379, -122.429301);
    protected MapView mMapView;
    protected GoogleMap mGoogleMap;


    protected boolean mMarkerPlaced = false;




    //    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //get the view from fragment_map.xml
        View view = inflater.inflate(R.layout.fragment_map, container,false);
        mMapView = (MapView) view.findViewById(R.id.mapView);



        // Google Map support init
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mGoogleMap = mMapView.getMap();
        mGoogleMap.setMyLocationEnabled(true);
        mGoogleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location arg0) {
                // Check if a marker has been placed so markers don't stack up
                if (!mMarkerPlaced) {
                    mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(arg0.getLatitude(), arg0.getLongitude())));
                    mMarkerPlaced = true;
                } else {
                    mGoogleMap.setOnMyLocationChangeListener(null);
                }
            }
        });



        return view;
    }

}
