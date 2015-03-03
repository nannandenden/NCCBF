package com.nccbf.android;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nanden on 2/28/15.
 */
public class MyAsyncTask extends AsyncTask{


    public interface OnDataReturnListener{
        public void onDataReturn(List<EventPOJO> data);

    }

    Context mContext;
    OnDataReturnListener mOnDataReturnListener;



    public MyAsyncTask(Context context, OnDataReturnListener onDataReturnListener ){
        mContext = context;
        mOnDataReturnListener = onDataReturnListener;


    }


    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }

    @Override
    protected Object doInBackground(Object[] params) {

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://keitaito.com/sampleNCCBF/document.json");
        List<EventPOJO> eventPOJOs = new ArrayList<>();


        try {
            HttpResponse response = client.execute(post);

            HttpEntity entity = response.getEntity();
            String data = EntityUtils.toString(entity);
            Log.d("tag","data: " + data);

            JSONObject jsonObject= new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("Events");

            //empty list of EventPOJO

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM DD, yyyy, hh:mm:ss aa");



            for(int i = 0; i < jsonArray.length(); i++){

                EventPOJO eventPOJO = new EventPOJO();

                JSONObject jRealObject = jsonArray.getJSONObject(i);

                try {
                    Date startDate = simpleDateFormat.parse(jRealObject.getString("start_at"));
                    Date endDate = simpleDateFormat.parse(jRealObject.getString("end_at"));

                    String name = jRealObject.getString("name");
                    String location_id = jRealObject.getString("location_id");
                    String image_name = jRealObject.getString("image_name");       //string
                    String discription = jRealObject.getString("description");

//                eventPOJO.setStartDate(startDate);
//                eventPOJO.setEndDate(endDate);
//                eventPOJO.setTitle(name);
//                eventPOJO.setLocation(location_id);
////                eventPOJO.getEventImage(image_name);
//                eventPOJO.setDescription(discription);
//                eventPOJOs.add(eventPOJO);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }



//

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        mOnDataReturnListener.onDataReturn(eventPOJOs);
        return new Object();
    }

//    @Override
//    protected void onPreExecute(Boolean result) {
//        super.onPreExecute();
//    }
}


