package com.nccbf.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanden on 2/22/15.
 */

//
public class SingleScheduleActivity extends Activity {

    private ScheduleDetailAdapter mScheduleDetailAdapter;
    private TextView mTextView;
    private ListView mListView;
    private List<EventPOJO> mEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_schedule);

        TextView textView = (TextView)findViewById(R.id.single_event_schedule_tv);
        ListView listView = (ListView)findViewById(R.id.single_schedule_event_lv);

        mEvents = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            EventPOJO sampleEvent1 = new EventPOJO();
            sampleEvent1.setTitle("JCCCNC Stage");
            mEvents.add(sampleEvent1);
        }

        mScheduleDetailAdapter = new ScheduleDetailAdapter(SingleScheduleActivity.this, mEvents);

        mListView.setAdapter(mScheduleDetailAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EventPOJO clickedPojo = mScheduleDetailAdapter.getItem(position);

                Toast.makeText(SingleScheduleActivity.this, "Clicked Title: " + clickedPojo.getTitle() + " at position: " + position, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SingleScheduleActivity.this, SingleEventInfoActivity.class);

                startActivity(intent);
            }
        });

    }
}
