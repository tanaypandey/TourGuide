package com.example.android.tourguide;

public class transport_items {
private int mDefaultTranslationId;

        /** String resource ID for the Miwok translation of the word */
        private int mMiwokTranslationId;

        /** Audio resource ID for the word */

        /** Image resource ID for the word */
        private int mImageResourceId = NO_IMAGE_PROVIDED;

        /** Constant value that represents no image was provided for this word */
        private static final int NO_IMAGE_PROVIDED = -1;


        public transport_items(int defaultTranslationId, int miwokTranslationId, int imageResourceId) {
            mDefaultTranslationId = defaultTranslationId;
            mMiwokTranslationId = miwokTranslationId;
            mImageResourceId = imageResourceId;
        }

        /**
         * Get the string resource ID for the default translation of the word.
         */
        public int getDefaultTranslationId() {
            return mDefaultTranslationId;
        }

        /**
         * Get the string resource ID for the Miwok translation of the word.
         */
        public int getMiwokTranslationId() {
            return mMiwokTranslationId;
        }

        /**
         * Return the image resource ID of the word.
         */
        public int getImageResourceId() {
            return mImageResourceId;
        }

        /**
         * Returns whether or not there is an image for this word.
         */
        public boolean hasImage() {
            return mImageResourceId != NO_IMAGE_PROVIDED;
        }

}
