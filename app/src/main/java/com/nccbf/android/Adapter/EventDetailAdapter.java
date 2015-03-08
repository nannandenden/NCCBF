package com.nccbf.android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nccbf.android.POJO.EventPOJO;
import com.nccbf.android.R;

import java.util.List;

/**
 * Created by nanden on 2/21/15.
 */
public class EventDetailAdapter extends ArrayAdapter <EventPOJO> {

    private Context mContext;
    private List<EventPOJO> mEvents;

    public EventDetailAdapter(Context context, List<EventPOJO> events) {
        super(context, R.layout.event_lv_detail, events);
        mEvents = events;
        mContext = context;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {

        EventPOJO event = mEvents.get(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View newView = inflater.inflate(R.layout.event_lv_detail, viewGroup, false);
        ImageView imageView1 = (ImageView) newView.findViewById(R.id.event_detail_iv);
        TextView textView1 = (TextView) newView.findViewById(R.id.event_detail_tv);
//        imageView1.setImageResource(event.getEventImage());
        textView1.setText(event.getTitle());

        return newView;
    }

}
