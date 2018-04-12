package com.slack.weeklychallengeone.models;

import android.support.annotation.LayoutRes;

/**
 * Model class for storing composite data
 * displayed in the RecyclerView hosted by the {@link com.slack.weeklychallengeone.MainActivity}
 *
 * @author Kaushik N Sanji
 */
public class CompositeModel {

    //Stores the reference to the layout resource to use
    private int mRowLayout;
    //Stores the title text
    private String mTitle;
    //Stores the content/description tex
    private String mDescription;
    //Stores the link to the html content of the article
    private String mResourceLink;
    //Stores the Primary color value to use for the background of Title
    private int mColorPrimary;
    //Stores the Dark Primary color value to use for the description text
    private int mColorPrimaryDark;
    //Stores the Light Primary color value to use as the background of the content
    private int mColorPrimaryLight;
    //Stores the Accent color value to use for the action buttons
    private int mColorAccent;

    /**
     * Getter for {@link #mRowLayout}
     *
     * @return Integer value representing the layout resource to use
     */
    public int getRowLayout() {
        return mRowLayout;
    }

    /**
     * Getter for {@link #mTitle}
     *
     * @return String value representing the Title text
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Getter for {@link #mDescription}
     *
     * @return String value representing the Description Text
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Getter for {@link #mResourceLink}
     *
     * @return String value representing the link to the html content of the article
     */
    public String getResourceLink() {
        return mResourceLink;
    }

    /**
     * Getter for {@link #mColorPrimary}
     *
     * @return Integer value representing the color to use for the background of Title
     */
    public int getColorPrimary() {
        return mColorPrimary;
    }

    /**
     * Getter for {@link #mColorPrimaryDark}
     *
     * @return Integer value representing the color to use for the description text
     */
    public int getColorPrimaryDark() {
        return mColorPrimaryDark;
    }

    /**
     * Getter for {@link #mColorPrimaryLight}
     *
     * @return Integer value representing the color to use as the background of the content
     */
    public int getColorPrimaryLight() {
        return mColorPrimaryLight;
    }

    /**
     * Getter for {@link #mColorAccent}
     *
     * @return Integer value representing the color to use for the action buttons
     */
    public int getColorAccent() {
        return mColorAccent;
    }

    /**
     * Constructor of {@link CompositeModel} used by the Builder {@link CompositeModel.Builder}
     *
     * @param builder is the instance of Builder {@link CompositeModel.Builder}
     *                from which the {@link CompositeModel} is to be set up
     */
    private CompositeModel(final Builder builder) {
        mRowLayout = builder.mRowLayoutId;
        mTitle = builder.mTitle;
        mDescription = builder.mDescription;
        mResourceLink = builder.mResourceLink;
        mColorPrimary = builder.mColorPrimary;
        mColorPrimaryDark = builder.mColorPrimaryDark;
        mColorPrimaryLight = builder.mColorPrimaryLight;
        mColorAccent = builder.mColorAccent;
    }

    /**
     * The Builder class that constructs {@link CompositeModel}
     */
    public static class Builder {
        //Declaring the same members of CompositeModel
        private int mRowLayoutId;
        private String mTitle;
        private String mDescription;
        private String mResourceLink;
        private int mColorPrimary;
        private int mColorPrimaryDark;
        private int mColorPrimaryLight;
        private int mColorAccent;

        /**
         * Optional Setter for {@link CompositeModel#mRowLayout}
         *
         * @param rowLayoutId is the Integer value of the layout resource to use
         * @return Instance of {@link Builder}
         */
        public Builder setRowLayoutId(@LayoutRes final int rowLayoutId) {
            mRowLayoutId = rowLayoutId;
            return this;
        }

        /**
         * Optional Setter for {@link CompositeModel#mTitle}
         *
         * @param title is the String value to be used as the Title Text
         * @return Instance of {@link Builder}
         */
        public Builder setTitle(final String title) {
            mTitle = title;
            return this;
        }

        /**
         * Optional Setter for {@link CompositeModel#mDescription}
         *
         * @param description is the String value to be used the as the Description Text
         * @return Instance of {@link Builder}
         */
        public Builder setDescription(final String description) {
            mDescription = description;
            return this;
        }

        /**
         * Optional Setter for {@link CompositeModel#mResourceLink}
         *
         * @param resourceLink is the String value representing the link to html content of the article
         * @return Instance of {@link Builder}
         */
        public Builder setResourceLink(final String resourceLink) {
            mResourceLink = resourceLink;
            return this;
        }

        /**
         * Optional Setter for {@link CompositeModel#mColorPrimary}
         *
         * @param colorPrimary is the Integer value of the color to be used for the background of title text
         * @return Instance of {@link Builder}
         */
        public Builder setColorPrimary(final int colorPrimary) {
            mColorPrimary = colorPrimary;
            return this;
        }

        /**
         * Optional Setter for {@link CompositeModel#mColorPrimaryDark}
         *
         * @param colorPrimaryDark is the Integer value of the color to be used as the text color for the description text
         * @return Instance of {@link Builder}
         */
        public Builder setColorPrimaryDark(final int colorPrimaryDark) {
            mColorPrimaryDark = colorPrimaryDark;
            return this;
        }

        /**
         * Optional Setter for {@link CompositeModel#mColorPrimaryLight}
         *
         * @param colorPrimaryLight is the Integer value of the color to be used as the background of the content
         * @return Instance of {@link Builder}
         */
        public Builder setColorPrimaryLight(final int colorPrimaryLight) {
            mColorPrimaryLight = colorPrimaryLight;
            return this;
        }

        /**
         * Optional Setter for {@link CompositeModel#mColorAccent}
         *
         * @param colorAccent is the Integer value of the color to use for the action buttons
         * @return Instance of {@link Builder}
         */
        public Builder setColorAccent(final int colorAccent) {
            mColorAccent = colorAccent;
            return this;
        }

        /**
         * Method that generates the {@link CompositeModel}
         * from the Builder parameters set
         *
         * @return Instance of {@link CompositeModel}
         */
        public CompositeModel build() {
            return new CompositeModel(this);
        }
    }
}
