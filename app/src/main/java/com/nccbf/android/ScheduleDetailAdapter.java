package com.nccbf.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nanden on 2/19/15.
 */
public class ScheduleDetailAdapter extends ArrayAdapter<EventPOJO> {

    private Context mContext;
    private List<EventPOJO> mEvents;

    public ScheduleDetailAdapter(Context context, List<EventPOJO> events) {
        super(context, R.layout.schedule_lv_detail, events);
        mEvents = events;
        mContext = context;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {

        EventPOJO event = mEvents.get(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View newView = inflater.inflate(R.layout.schedule_lv_detail, viewGroup, false);
        TextView textView1 = (TextView) newView.findViewById(R.id.event_start_tv);
        TextView textView2 = (TextView) newView.findViewById(R.id.event_end_tv);
        TextView textView3 = (TextView) newView.findViewById(R.id.event_name_tv);

        textView1.setText(event.getStartDate());
        textView2.setText(event.getEndDate());
        textView3.setText(event.getTitle());
        return newView;
    }

}
