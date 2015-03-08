package com.nccbf.android.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nccbf.android.R;
import com.nccbf.android.adapter.SocialMediaDetailAdapter;
import com.nccbf.android.pojo.SocialMediaPOJO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanden on 2/14/15.
 */
public class SocialMediaFragment extends android.support.v4.app.Fragment {

    private static final String TAG = SocialMediaFragment.class.getSimpleName();
    private SocialMediaDetailAdapter mSocialMediaAdapter;
    private ListView mListView;
    private List<SocialMediaPOJO> mSocialMediaPojos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //socialMediaPojo is an arrayList for the listview
        mSocialMediaPojos = new ArrayList<SocialMediaPOJO>();

        SocialMediaPOJO facebookSocialMediaPojo = new SocialMediaPOJO();
        facebookSocialMediaPojo.setSocialMediaIcon(R.drawable.nccbf_logo);
        facebookSocialMediaPojo.setTextView("FaceBook");
        facebookSocialMediaPojo.setLink("https://www.facebook.com/NCCBF");
        mSocialMediaPojos.add(facebookSocialMediaPojo);

        SocialMediaPOJO instagramSocialMediaPojo = new SocialMediaPOJO();
        instagramSocialMediaPojo.setSocialMediaIcon(R.drawable.nccbf_logo);
        instagramSocialMediaPojo.setTextView("Instagram");
        instagramSocialMediaPojo.setLink("https://instagram.com/nc_cbf/");
        mSocialMediaPojos.add(instagramSocialMediaPojo);

        SocialMediaPOJO twitterSocialMediaPojo = new SocialMediaPOJO();
        twitterSocialMediaPojo.setSocialMediaIcon(R.drawable.nccbf_logo);
        twitterSocialMediaPojo.setTextView("Twitter");
        twitterSocialMediaPojo.setLink("https://twitter.com/search?q=nc_cbf");
        mSocialMediaPojos.add(twitterSocialMediaPojo);

        SocialMediaPOJO aboutNccbSocialMediaPojo = new SocialMediaPOJO();
        aboutNccbSocialMediaPojo.setSocialMediaIcon(R.drawable.nccbf_logo);
        aboutNccbSocialMediaPojo.setTextView("About");
        aboutNccbSocialMediaPojo.setLink("http://sfcherryblossom.org/?page_id=38");
        mSocialMediaPojos.add(aboutNccbSocialMediaPojo);


        mSocialMediaAdapter = new SocialMediaDetailAdapter(getActivity(), mSocialMediaPojos);

        //get the view from fragment_social_media.xml
        View view = inflater.inflate(R.layout.fragment_social_media, container, false);

        mListView = (ListView) view.findViewById(R.id.social_media_lv);

        mListView.setAdapter(mSocialMediaAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.d(TAG, "POSITION: " + position);

                SocialMediaPOJO socialMediaPOJO = mSocialMediaAdapter.getItem(position);

                String selectedMediaPojoLink = socialMediaPOJO.getLink();

                Intent webPageIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedMediaPojoLink));
                startActivity(webPageIntent);


            }
        });

        return view;
    }
}
