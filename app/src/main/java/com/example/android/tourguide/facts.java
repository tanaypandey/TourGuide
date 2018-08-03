package com.example.android.tourguide;

public class facts {

    private int  mfactsHeadingId;
    private int  mfactsId;
    private int mfactsImageId;

    public facts(int factsHeadingId, int factsId, int factsImageId){
        mfactsHeadingId = factsHeadingId;
        mfactsId = factsId;
        mfactsImageId = factsImageId;
    }

    public int getfactsHeadingId() {
        return mfactsHeadingId;
    }

    public int getfactsId() {
        return mfactsId;
    }

    public int getfactsImageId() {
        return mfactsImageId;
    }
}
