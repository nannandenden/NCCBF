package com.nccbf.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nanden on 2/21/15.
 */

public class SocialMediaDetailAdapter extends ArrayAdapter<SocialMediaPOJO> {

    private Context mContext;
    private List<SocialMediaPOJO> mEvents;

    public SocialMediaDetailAdapter(Context context, List<SocialMediaPOJO> events) {
        super(context, R.layout.social_media_lv_detail, events);
        mEvents = events;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        SocialMediaPOJO event = mEvents.get(position);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View newView = inflater.inflate(R.layout.social_media_lv_detail, viewGroup, false);
        ImageView imageView1 = (ImageView) newView.findViewById(R.id.social_media_icon);
        TextView textView1 = (TextView) newView.findViewById(R.id.social_media_name);
        imageView1.setImageResource(event.getSocialMediaIcon());
        textView1.setText(event.getTextView());

        return newView;

    }
}
