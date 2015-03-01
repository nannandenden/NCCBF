package com.nccbf.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by nanden on 2/21/15.
 */
public class SingleEventInfoActivity extends Activity {

    private TextView mSingleEvevtDiscripTextView;
    private TextView mLocationTextView;
    private TextView mScheduleTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_event_info);

        mSingleEvevtDiscripTextView = (TextView) findViewById(R.id.single_event_discrip_tv);

        mLocationTextView = (TextView) findViewById(R.id.single_event_location_tv);
        //jump to map MapFragment, how do I do that....?
        mLocationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mScheduleTextView = (TextView) findViewById(R.id.single_event_schedule_tv);
        //Jump to SingleScheduleActivity
        mScheduleTextView.setOnClickListener(new ScheduleTextViewOnClickListener());

    }

    //when you hve a lot of logic, this anonymous inner class is better
    private class ScheduleTextViewOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(SingleEventInfoActivity.this, SingleScheduleActivity.class);

            startActivity(intent);

        }
    }

}
