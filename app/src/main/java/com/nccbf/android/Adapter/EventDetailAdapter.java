package com.nccbf.android.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.nccbf.android.R;
import com.nccbf.android.pojo.EventPOJO;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by nanden on 2/21/15.
 */
public class EventDetailAdapter extends ArrayAdapter <EventPOJO> implements Filterable{

    //yo
    //yoyo


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
        Uri otherPath = Uri.parse("android.resource://com.nccbf.android/drawable/" + event.getEventImage());
        Picasso.with(mContext).load(otherPath).into(imageView1);
        textView1.setText(event.getTitle());

        return newView;
    }
//
//    @Override
//    public Filter getFilter() {
//        Filter filter = new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                return null;
//            }
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//
//            }
//        };
//    }
}
