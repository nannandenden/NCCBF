package com.nccbf.android;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by nanden on 2/17/15.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    final int PAGE_COUNT = 4;

    //tab titles
//    private String tabTitles[] = new String[] {"Event", "Schedule", "Map", "SocialMedia"};
//    Context context;

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){

            //Open EventFragment.java
            case 0:
                EventFragment eventFragment = new EventFragment();
                Log.d("Banana","Inside EventFragment");
                return eventFragment;

            //Open ScheduleFragment.java
            case 1:
                ScheduleFragment scheduleFragment = new ScheduleFragment();
                Log.d("Banana","Inside ScheduleFragment");
                return scheduleFragment;

            //Open SocialMediaFragment.java
            case 2:
                MapFragment mapFragment = new MapFragment();
                Log.d("Banana","Inside MapFragment");
                return mapFragment;

            //Open MapFragment.java
            case 3:
                SocialMediaFragment socialMediaFragment = new SocialMediaFragment();
                Log.d("Banana","Inside SocialMediaFragment");
                return socialMediaFragment;

        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";

        switch (position){

            case 0:
                title = "Event";
                break;

            //Open ScheduleFragment.java
            case 1:
                title = "Schedule";
                break;

            //Open SocialMediaFragment.java
            case 2:
                title = "Map";
                break;

            //Open MapFragment.java
            case 3:
                title = "Social Media";
                break;
        }

        return title;
    }
}
