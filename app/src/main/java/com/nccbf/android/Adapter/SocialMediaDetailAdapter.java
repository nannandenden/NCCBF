package com.nccbf.android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nccbf.android.R;
import com.nccbf.android.POJO.SocialMediaPOJO;

import java.util.List;

/**
 * Created by nanden on 2/21/15.
 */

public class SocialMediaDetailAdapter extends ArrayAdapter<SocialMediaPOJO> {

    private Context mContext;
    private List<SocialMediaPOJO> mSocialMediaPOJOs;

    public SocialMediaDetailAdapter(Context context, List<SocialMediaPOJO> socialMediaPOJOs) {
        super(context, R.layout.social_media_lv_detail, socialMediaPOJOs);
        mSocialMediaPOJOs = socialMediaPOJOs;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        SocialMediaPOJO event = mSocialMediaPOJOs.get(position);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View newView = inflater.inflate(R.layout.social_media_lv_detail, viewGroup, false);
        ImageView socialMediaIconImageView = (ImageView) newView.findViewById(R.id.social_media_icon);
        TextView socialMediaNameTextView = (TextView) newView.findViewById(R.id.social_media_name);
        socialMediaIconImageView.setImageResource(event.getSocialMediaIcon());
        socialMediaNameTextView.setText(event.getTextView());


        return newView;

    }
}
