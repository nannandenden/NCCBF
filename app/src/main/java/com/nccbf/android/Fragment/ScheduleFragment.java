package com.nccbf.android.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.nccbf.android.R;
import com.nccbf.android.activity.SingleEventInfoActivity;
import com.nccbf.android.adapter.ScheduleDetailAdapter;
import com.nccbf.android.pojo.EventPOJO;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mEvents = new ArrayList<EventPOJO>();
        // 11th
        EventPOJO scheduleList1 = new EventPOJO();
        scheduleList1.setTitle("San Francisco Taiko Dojo");
        scheduleList1.setStartDate("2015-04-11 12:15 PM");
        scheduleList1.setEndDate("2015-04-11 01:15 PM");
        mEvents.add(scheduleList1);

        EventPOJO scheduleList2 = new EventPOJO();
        scheduleList2.setTitle("Opening Ceremony");
        scheduleList2.setStartDate("2015-04-11 1:15 PM");
        scheduleList2.setEndDate("2015-04-11 01:30 PM");
        mEvents.add(scheduleList2);

        EventPOJO scheduleList3 = new EventPOJO();
        scheduleList3.setTitle("Michiya Hanayagi and Michisuya Hanayagi Kai");
        scheduleList3.setStartDate("2015-04-11 1:30 PM");
        scheduleList3.setEndDate("2015-04-11 02:00 PM");
        mEvents.add(scheduleList3);

        // 12th
        EventPOJO scheduleList4 = new EventPOJO();
        scheduleList4.setTitle("Yamasho Kai");
        scheduleList4.setStartDate("2015-04-12 11:15 AM");
        scheduleList4.setEndDate("2015-04-12 11:45 AM");
        mEvents.add(scheduleList4);

        EventPOJO scheduleList5 = new EventPOJO();
        scheduleList5.setTitle("2015 Senior Appreciation Brunch Honorees");
        scheduleList5.setStartDate("2015-04-12 11:45 AM");
        scheduleList5.setEndDate("2015-04-12 12:00 PM");
        mEvents.add(scheduleList5);

        EventPOJO scheduleList6 = new EventPOJO();
        scheduleList6.setTitle("2015 Queen and Court");
        scheduleList6.setStartDate("2015-04-12 12:00 PM");
        scheduleList6.setEndDate("2015-04-12 12:30 PM");
        mEvents.add(scheduleList6);

        EventPOJO scheduleList7 = new EventPOJO();
        scheduleList7.setTitle("San Francisco Taiko Dojo");
        scheduleList7.setStartDate("2015-04-18 12:00 PM");
        scheduleList7.setEndDate("2015-04-18 12:30 PM");
        mEvents.add(scheduleList7);

        EventPOJO scheduleList8 = new EventPOJO();
        scheduleList8.setTitle("Grass Valley Taiko");
        scheduleList8.setStartDate("2015-04-18 12:30 PM");
        scheduleList8.setEndDate("2015-04-18 01:00 PM");
        mEvents.add(scheduleList8);

        EventPOJO scheduleList9 = new EventPOJO();
        scheduleList9.setTitle("Rosa Parks School Japanese Bilingual Bicultural Program");
        scheduleList9.setStartDate("2015-04-18 01:00 PM");
        scheduleList9.setEndDate("2015-04-18 01:30 PM");
        mEvents.add(scheduleList9);

        EventPOJO scheduleList10 = new EventPOJO();
        scheduleList10.setTitle("San Francisco Kendo Dojo");
        scheduleList10.setStartDate("2015-04-19 11:00 AM");
        scheduleList10.setEndDate("2015-04-19 12:00 PM");
        mEvents.add(scheduleList10);

        EventPOJO scheduleList11 = new EventPOJO();
        scheduleList11.setTitle("Enshin Karate");
        scheduleList11.setStartDate("2015-04-19 12:00 PM");
        scheduleList11.setEndDate("2015-04-19 12:30 PM");
        mEvents.add(scheduleList11);

        EventPOJO scheduleList12 = new EventPOJO();
        scheduleList12.setTitle("Japanese Music Institute of America");
        scheduleList12.setStartDate("2015-04-11 12:30 PM");
        scheduleList12.setEndDate("2015-04-11 01:30 PM");
        mEvents.add(scheduleList12);

        EventPOJO scheduleList13 = new EventPOJO();
        scheduleList13.setTitle("Minyo Minbu Festival");
        scheduleList13.setStartDate("2015-04-11 01:30 PM");
        scheduleList13.setEndDate("2015-04-11 03:00 PM");
        mEvents.add(scheduleList13);

        EventPOJO scheduleList14 = new EventPOJO();
        scheduleList14.setTitle("San Francisco Taiko Dojo");
        scheduleList14.setStartDate("2015-04-18 12:00 PM");
        scheduleList14.setEndDate("2015-04-18 12:30 PM");
        mEvents.add(scheduleList14);

        EventPOJO scheduleList15 = new EventPOJO();
        scheduleList15.setTitle("San Francisco Taiko Dojo");
        scheduleList15.setStartDate("2015-04-18 12:00 PM");
        scheduleList15.setEndDate("2015-04-18 12:30 PM");
        mEvents.add(scheduleList15);

        mScheduleDetailAdapter = new ScheduleDetailAdapter(getActivity(), mEvents);

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
