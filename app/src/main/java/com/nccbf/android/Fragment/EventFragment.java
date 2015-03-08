package com.nccbf.android.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.nccbf.android.R;
import com.nccbf.android.activity.SingleEventInfoActivity;
import com.nccbf.android.adapter.EventDetailAdapter;
import com.nccbf.android.network.APIClient;
import com.nccbf.android.network.APIName;
import com.nccbf.android.pojo.EventPOJO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanden on 2/14/15.
 */
public class EventFragment extends android.support.v4.app.Fragment{

    private EventDetailAdapter mEventDetailAdapter;
    private ListView mListView;
    private List<EventPOJO> mEvents;
    private Handler mHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.welcome_message);
        mHandler = new Handler();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mEvents = new ArrayList<>();

        //get the view from fragment_event.xml
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        mListView = (ListView) view.findViewById(R.id.event_lv);


        APIClient apiClient = new APIClient(APIName.GET_EVENTS);


        apiClient.doTheApiCall(new APIClient.APIClientResponseHandler() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                try {
                    JSONArray jsonArray = jsonObject.getJSONArray("Events");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        mEvents.add(new EventPOJO(jsonArray.getJSONObject(i)));

                    }

                    mEventDetailAdapter = new EventDetailAdapter(getActivity(), mEvents);

                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mListView.setAdapter(mEventDetailAdapter);

                        }
                    });



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure() {
            }
        });

        //anonymous inner class to set event_lv Click Listener
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                EventPOJO clickedPojo = mEventDetailAdapter.getItem(position);

                Toast.makeText(getActivity(), "Clicked Title: " + clickedPojo.getTitle() + " at position: " + position, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), SingleEventInfoActivity.class);

                startActivity(intent);
            }
        });

        return view;
    }
}
