package com.nccbf.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class ScheduleFragment extends Fragment {

    private ScheduleDetailAdapter mScheduleDetailAdapter;
    private ListView mListView;
    private List<EventPOJO> mEvents;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mEvents = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            EventPOJO sampleEvent1 = new EventPOJO();
            sampleEvent1.setTitle("JCCCNC Stage");

            mEvents.add(sampleEvent1);
        }

        mScheduleDetailAdapter = new ScheduleDetailAdapter(getActivity(), mEvents);


        //get the view from fragment_schedule.xml
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        mListView = (ListView) view.findViewById(R.id.schedule_lv);

        mListView.setAdapter(mScheduleDetailAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                EventPOJO clickedPojo = mScheduleDetailAdapter.getItem(position);

                Toast.makeText(getActivity(), "Clicked Title: " + clickedPojo.getTitle() + " at position: " + position, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), SingleEventInfoActivity.class);

                startActivity(intent);
            }
        });

        return view;
    }
}
