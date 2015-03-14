package com.nccbf.android.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.nccbf.android.R;
import com.nccbf.android.adapter.MySpinnerAdapter;
import com.nccbf.android.adapter.ViewPagerAdapter;
import com.nccbf.android.fragment.EventFragment;
import com.nccbf.android.fragment.MapFragment;
import com.nccbf.android.fragment.ScheduleFragment;
import com.nccbf.android.fragment.SocialMediaFragment;
import com.nccbf.android.pojo.EventPOJO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    private static final String TAG = "NCCBF";
    TabsAdapter mTabsAdapter;
    ViewPagerAdapter mViewPagerAdapter;
    ViewPager mViewPager;

    List<EventPOJO> mEventPojos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        ActionBar actionBar = getSupportActionBar();
        MySpinnerAdapter spinnerAdapter = new MySpinnerAdapter(this);
        List<String> dateList = new ArrayList<String>();
        dateList.add("April 11");
        dateList.add("April 12");
        dateList.add("April 18");
        dateList.add("April 19");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dateList);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        View view = getLayoutInflater().inflate(R.layout.spinner_layout, null);


        mTabsAdapter = new TabsAdapter(this, mViewPager);

        mTabsAdapter.addTab(actionBar.newTab().setIcon(R.drawable.nccbf_logo), EventFragment.class, null);

        mTabsAdapter.addTab(actionBar.newTab().setIcon(R.drawable.nccbf_logo), ScheduleFragment.class, null);

        mTabsAdapter.addTab(actionBar.newTab().setIcon(R.drawable.nccbf_logo), MapFragment.class, null);

        mTabsAdapter.addTab(actionBar.newTab().setIcon(R.drawable.nccbf_logo), SocialMediaFragment.class, null);

        mViewPager.setAdapter(mTabsAdapter);

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment selectedFragment = mTabsAdapter.getItem(mViewPager.getCurrentItem());

//                selectedFragment.


            }
        });

        actionBar.setCustomView(view);

        actionBar.setDisplayShowCustomEnabled(true);

//        mViewPager = (ViewPager) findViewById(R.id.pager);
//        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
//
//        PagerSlidingTabStrip pageSliderWidget = (PagerSlidingTabStrip) findViewById(R.id.tabs);
//        pageSliderWidget.setViewPager(mViewPager);


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
//        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//
//        mViewPager.setAdapter(mViewPagerAdapter);


//
//        task.execute(new Object());





    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        MenuItem item = menu.findItem(R.id.action_change_content); // id of our custom menu item
//        Spinner spinner = (Spinner) item.getActionView().findViewById(R.id.spinner);
//        return true;
//    }

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
