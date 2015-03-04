package com.nccbf.android;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.nccbf.android.network.APIClient;
import com.nccbf.android.network.APIName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanden on 2/14/15.
 */
public class ScheduleFragment extends Fragment {

    private ScheduleDetailAdapter mScheduleDetailAdapter;
    private ListView mListView;
    private List<EventPOJO> mEvents;
    private Handler mHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mEvents = new ArrayList<>();
        //get the view from fragment_schedule.xml
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        mListView = (ListView) view.findViewById(R.id.schedule_lv);

        APIClient apiClient = new APIClient(APIName.GET_EVENTS);

        apiClient.doTheApiCall(new APIClient.APIClientResponseHandler() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                try {
                    JSONArray jsonArray = jsonObject.getJSONArray("Events");
                    for (int i = 0; i < jsonArray.length(); i++) {

                        mEvents.add(new EventPOJO(jsonArray.getJSONObject(i)));

                    }
                    mScheduleDetailAdapter = new ScheduleDetailAdapter(getActivity(), mEvents);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mListView.setAdapter(mScheduleDetailAdapter);
                        }
                    });
                }catch(JSONException e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onFailure() {

            }
        });


        mListView.setAdapter(mScheduleDetailAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                EventPOJO clickedPojo = mScheduleDetailAdapter.getItem(position);

                Toast.makeText(getActivity(), "Clicked Title: " + clickedPojo.getTitle() + " at position: " + position, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), SingleEventInfoActivity.class);

                startActivity(intent);
            }
        });

        return view;
    }
}
