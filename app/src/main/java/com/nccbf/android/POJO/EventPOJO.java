package com.nccbf.android.pojo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by nanden on 2/19/15.
 */
public class EventPOJO {

    private String mStartDate;
    private String mEndDate;
    private String mTitle;
    private String mLocation;
    private String mDescription;
    private String mId;
    private String mEventImageResource;

    public EventPOJO() {

    }

    public EventPOJO(JSONObject jsonObject) {

        Iterator<String> jsonKeys = jsonObject.keys();

        while (jsonKeys.hasNext()) {

            String currentJsonKey = jsonKeys.next();

            try {
                switch (currentJsonKey) {

                    case ("name"):
                        mTitle = jsonObject.getString(currentJsonKey);
                        break;

                    case ("start_at"):
                        mStartDate = jsonObject.getString(currentJsonKey);
                        break;

                    case ("end_at"):
                        mEndDate = jsonObject.getString(currentJsonKey);
                        break;

                    case ("location_id"):
                        mLocation = jsonObject.getString(currentJsonKey);
                        break;

                    case ("image_name"):
                        mEventImageResource = jsonObject.getString(currentJsonKey);
                        break;

                    case ("description"):
                        mDescription = jsonObject.getString(currentJsonKey);
                        break;

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

    public String getStartDate()
    {
        return mStartDate;
    }

    public void setStartDate(String startDate)
    {
        mStartDate = startDate;
    }

    public String getEndDate() {

        return mEndDate;
    }

    public void setEndDate(String endDate)
    {
        mEndDate = endDate;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public void setTitle(String title)
    {
        mTitle = title;
    }

    public String getLocation()
    {
        return mLocation;
    }

    public void setLocation(String location)
    {
        mLocation = location;
    }

    public String getDescription()
    {
        return mDescription;
    }

    public void setDescription(String description)
    {
        mDescription = description;
    }

    public String getId()
    {
        return mId;
    }

    public void setId(int id)
    {
        mId = Integer.toString(id);
    }

    public String getEventImage(){

        return mEventImageResource;
    }

    public void setEventImage(String eventImage){

        mEventImageResource = eventImage;

    }


}
