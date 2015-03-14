package com.nccbf.android.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nccbf.android.R;

/**
 * Created by labtob on 3/14/2015.
 */
public class MySpinnerAdapter extends BaseAdapter {

    protected String[] dates = {"April 11", "April 12", "April 18", "April 19" };
    protected Context mContext;


    public MySpinnerAdapter(Context context){
        mContext = context;

    }


    @Override
    public int getCount() {
        return 4;
    }



    @Override
    public Object getItem(int position) {
        return dates[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        TextView tv;
            if(v == null){
                v.inflate(mContext, R.layout.spinner_detail_layout, parent);
                tv = (TextView) v.findViewById(R.id.spinner_detail_date);
                tv.setText(dates[position]);
            } else{
                tv = (TextView) v.findViewById(R.id.spinner_detail_date);
                tv.setText(dates[position]);
            }

        return v;
    }
}
