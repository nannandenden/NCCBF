package com.nccbf.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanden on 2/14/15.
 */
public class EventFragment extends android.support.v4.app.Fragment{

    private EventDetailAdapter mEventDetailAdapter;
    private ListView mListView;
    private List<EventPOJO> mEvents;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mEvents = new ArrayList<EventPOJO>();




        mEventDetailAdapter = new EventDetailAdapter(getActivity(), mEvents);

        //get the view from fragment_event.xml
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        mListView = (ListView) view.findViewById(R.id.event_lv);

        mListView.setAdapter(mEventDetailAdapter);

        //anonymous inner class to set event_lv Click Listener
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                EventPOJO clickedPojo = mEventDetailAdapter.getItem(position);

                Toast.makeText(getActivity(), "Clicked Title: " + clickedPojo.getTitle() + " at position: " + position, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), SingleEventInfoActivity.class);

                startActivity(intent);
            }
        });

        return view;
    }
}
