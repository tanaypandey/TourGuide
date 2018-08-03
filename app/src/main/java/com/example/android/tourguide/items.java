package com.example.android.tourguide;

public class items {
    private int mPlaceNameId;
    private int mTimeId;
    private int mImageResourceId;
    private int mRatingId;
    private int mAddressId;
    private int mDescriptionId;

    public items(int PlaceNameId, int TimeId, int RatingId, int AddressId, int DescriptionId, int ImageResourceId) {
        mPlaceNameId = PlaceNameId;
        mTimeId = TimeId;
        mRatingId = RatingId;
        mImageResourceId = ImageResourceId;
        mAddressId = AddressId;
        mDescriptionId = DescriptionId;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public int getmPlaceName() {
        return mPlaceNameId;
    }

    public int getmRating() {
        return mRatingId;
    }

    public int getmTime() {
        return mTimeId;
    }

    public int getmAddressId() {
        return mAddressId;
    }

    public int getmDescriptionId(){
        return mDescriptionId;
    }
}
