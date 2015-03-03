package com.nccbf.android.network;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by nanden on 3/1/15.
 */
public class APIClient {

    private APIClientResponseHandler responseHandler;
    private APIName apiName;

    public APIClient(APIName apiName) {

        this.apiName = apiName;

    }


    public void doTheApiCall(final APIClientResponseHandler responseHandler) { //normally named execute

        this.responseHandler = responseHandler;

        new Thread(new Runnable() {
            @Override
            public void run() {

                JSONObject responseJsonObject = null;

                switch (apiName) {

                    case GET_EVENTS:
                        responseJsonObject = getEvents();
                        break;
                }

                if (responseJsonObject == null) {
                    responseHandler.onFailure();
                } else {
                    responseHandler.onSuccess(responseJsonObject);
                }

            }
        }).start();


    }

    private JSONObject getEvents() {

        return get("http://keitaito.com/sampleNCCBF/document.json");

    }


    private JSONObject get(String url) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseString = response.body().string();

            JSONObject jsonObject = new JSONObject(responseString);
            return jsonObject;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }


    public interface APIClientResponseHandler {

        public void onSuccess(JSONObject jsonObject);
        public void onFailure();

    }


}


