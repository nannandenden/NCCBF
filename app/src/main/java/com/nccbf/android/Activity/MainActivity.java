package com.nccbf.android.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.nccbf.android.R;
import com.nccbf.android.fragment.EventFragment;
import com.nccbf.android.fragment.MyMapFragment;
import com.nccbf.android.fragment.ScheduleFragment;
import com.nccbf.android.fragment.SocialMediaFragment;
import com.nccbf.android.pojo.EventPOJO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    private static final String TAG = "NCCBF";
    TabsAdapter mTabsAdapter;
    ViewPager mViewPager;

    List<EventPOJO> mEventPojos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


//        MyAsyncTask task = new MyAsyncTask(this, new MyAsyncTask.OnDataReturnListener() {
//            @Override
//            //myasync task happens in the background, gets called when asynctast finishs
//            public void onDataReturn(List<EventPOJO> data) {
//                mEventPojos = data;
//
//                EventPOJO poj = mEventPojos.get(0);
//                poj.getTitle();
//
//
//            }
//        });
//
//
//        task.execute(new Object());

        mTabsAdapter = new TabsAdapter(this, mViewPager);

        mTabsAdapter.addTab(actionBar.newTab().setIcon(R.drawable.nccbf_logo), EventFragment.class, null);

        mTabsAdapter.addTab(actionBar.newTab().setIcon(R.drawable.nccbf_logo), ScheduleFragment.class, null);

        mTabsAdapter.addTab(actionBar.newTab().setIcon(R.drawable.nccbf_logo), MyMapFragment.class, null);

        mTabsAdapter.addTab(actionBar.newTab().setIcon(R.drawable.nccbf_logo), SocialMediaFragment.class, null);

        mViewPager.setAdapter(mTabsAdapter);


    }



    public static class TabsAdapter extends FragmentStatePagerAdapter
        implements ActionBar.TabListener, ViewPager.OnPageChangeListener {
        private final Context mContext;
        private final ActionBar mActionBar;
        private final ViewPager mViewPager;
        private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();

        static final class TabInfo {
            private final Class<?> clss;
            private final Bundle args;

            TabInfo(Class<?> _class, Bundle _args) {
                clss = _class;
                args = _args;
            }
        }

        public TabsAdapter(ActionBarActivity activity, ViewPager pager) {
            super(activity.getSupportFragmentManager());
            mContext = activity;
            mActionBar = activity.getSupportActionBar();
            mViewPager = pager;
            mViewPager.setAdapter(this);
            mViewPager.setOnPageChangeListener(this);
        }

        public void addTab(ActionBar.Tab tab, Class<?> clss, Bundle args) {
            TabInfo info = new TabInfo(clss, args);
            tab.setTag(info);
            tab.setTabListener(this);
            mTabs.add(info);
            mActionBar.addTab(tab);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mTabs.size();
        }

        @Override
        public Fragment getItem(int position) {
            TabInfo info = mTabs.get(position);
            return Fragment.instantiate(mContext, info.clss.getName(), info.args);
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            mActionBar.setSelectedNavigationItem(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            Object tag = tab.getTag();
            for (int i=0; i<mTabs.size(); i++) {
                if (mTabs.get(i) == tag) {
                    mViewPager.setCurrentItem(i);
                }
            }
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        }

    }
}
