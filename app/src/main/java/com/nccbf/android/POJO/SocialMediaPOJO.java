package com.nccbf.android.POJO;

/**
 * Created by nanden on 2/21/15.
 */
public class SocialMediaPOJO {

    private int mSocialMediaIcon;
    private String mTextView;
    private String mLink;


    public String getLink() {

        return mLink;
    }

    public void setLink(String link) {

        mLink = link;
    }

    public String getTextView(){

        return mTextView;
    }

    public void setTextView(String textView){

        mTextView = textView;

    }

    public int getSocialMediaIcon(){

        return mSocialMediaIcon;
    }

    public void setSocialMediaIcon(int socialMediaIcon){

        mSocialMediaIcon = socialMediaIcon;
    }

    @Override
    public String toString() {

        return mTextView;
    }


}
