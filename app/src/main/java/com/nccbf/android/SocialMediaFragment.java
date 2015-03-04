package com.nccbf.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanden on 2/14/15.
 */
public class SocialMediaFragment extends android.support.v4.app.Fragment {

    private SocialMediaDetailAdapter mSocialMediaAdapter;
    private ListView mListView;
    private List<SocialMediaPOJO> mEvents;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mEvents = new ArrayList<>();


        SocialMediaPOJO sampleEvent1 = new SocialMediaPOJO();
        sampleEvent1.setSocialMediaIcon(R.drawable.ic_launcher);
        sampleEvent1.setTextView("FaceBook");
        mEvents.add(sampleEvent1);

        SocialMediaPOJO sampleEvent2 = new SocialMediaPOJO();
        sampleEvent2.setSocialMediaIcon(R.drawable.ic_launcher);
        sampleEvent2.setTextView("Instagram");
        mEvents.add(sampleEvent2);

        SocialMediaPOJO sampleEvent3 = new SocialMediaPOJO();
        sampleEvent3.setSocialMediaIcon(R.drawable.ic_launcher);
        sampleEvent3.setTextView("Twitter");
        mEvents.add(sampleEvent3);

        SocialMediaPOJO sampleEvent4 = new SocialMediaPOJO();
        sampleEvent4.setSocialMediaIcon(R.drawable.ic_launcher);
        sampleEvent4.setTextView("About");
        mEvents.add(sampleEvent4);


        mSocialMediaAdapter = new SocialMediaDetailAdapter(getActivity(),mEvents);

        //get the view from fragment_social_media.xml
        View view = inflater.inflate(R.layout.fragment_social_media, container, false);

        mListView = (ListView) view.findViewById(R.id.social_media_lv);

        mListView.setAdapter(mSocialMediaAdapter);

        return view;
    }
}
