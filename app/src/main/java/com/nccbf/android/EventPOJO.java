package com.nccbf.android;

import java.util.Date;

/**
 * Created by nanden on 2/19/15.
 */
public class EventPOJO {

    private Date mStartDate;
    private Date mEndDate;
    private String mTitle;
    private Integer mLocation;
    private String mDescription;
    private String mId;
    private String mEventImageResource;

    public Date getStartDate()
    {
        return mStartDate;
    }

    public void setStartDate(Date startDate)
    {
        mStartDate = startDate;
    }

    public Date getEndDate() {

        return mEndDate;
    }

    public void setEndDate(Date endDate)
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

    public Integer getLocation()
    {
        return mLocation;
    }

    public void setLocation(Integer location)
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
