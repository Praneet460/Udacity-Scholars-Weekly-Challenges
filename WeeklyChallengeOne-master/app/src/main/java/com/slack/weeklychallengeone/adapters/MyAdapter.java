package com.slack.weeklychallengeone.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.slack.weeklychallengeone.R;
import com.slack.weeklychallengeone.models.CompositeModel;
import com.slack.weeklychallengeone.utils.IntentUtility;
import com.slack.weeklychallengeone.utils.TextAppearanceUtility;

import java.util.List;

/**
 * Adapter Class of the Heterogeneous RecyclerView present in the layout 'R.layout.activity_main'
 * inflated by the {@link com.slack.weeklychallengeone.MainActivity}
 * that is used along with the {@link android.support.v7.widget.LinearLayoutManager}
 * to bind and display a list of {@link CompositeModel} objects.
 *
 * @author Kaushik N Sanji
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //Stores a List of CompositeModel objects which is the Dataset of the Adapter
    private List<CompositeModel> mCompositeItemList;

    //Stores the reference to the Context
    private Context mContext;

    //Saves the position of the Item that was last expanded. Defaulted to -1
    private int mExpandedItemPos = RecyclerView.NO_POSITION;

    //Stores the Typeface used by the Item Title Text in the layout 'R.layout.row_layout'
    private Typeface mItemTitleTextTypeface;
    //Stores the Typeface used by the Item Description Text in the layout 'R.layout.row_layout'
    private Typeface mItemDescriptionTextTypeface;
    //Stores the Typeface used by the Author Title Text in the layout 'R.layout.author_card_layout'
    private Typeface mAuthorTitleTextTypeface;
    //Stores the Typeface used by the Author Text in the layout 'R.layout.author_card_layout'
    private Typeface mAuthorTextTypeface;

    //Stores the reference to the Listener OnAdapterItemCloseActionListener
    private OnAdapterItemCloseActionListener mAdapterItemCloseActionListener;

    //Stores the reference to the Listener OnAdapterItemExpandListener
    private OnAdapterItemExpandListener mOnAdapterItemExpandListener;

    /**
     * Constructor of the Adapter {@link MyAdapter}
     *
     * @param context           is the Context of the Activity
     * @param compositeItemList is the list of {@link CompositeModel} objects which is the Dataset of the Adapter
     */
    public MyAdapter(Context context, List<CompositeModel> compositeItemList) {
        mContext = context;
        mCompositeItemList = compositeItemList;

        //Loading the Typefaces to be used
        mItemTitleTextTypeface = ResourcesCompat.getFont(mContext, R.font.coprgtb);
        mItemDescriptionTextTypeface = ResourcesCompat.getFont(mContext, R.font.quintessential);
        mAuthorTitleTextTypeface = ResourcesCompat.getFont(mContext, R.font.lobster);
        mAuthorTextTypeface = ResourcesCompat.getFont(mContext, R.font.rothenbg);
    }

    /**
     * Method that registers the {@link OnAdapterItemCloseActionListener} for the
     * Activity to receive the 'Close' Button Action events.
     *
     * @param listener is the instance of the Activity implementing {@link OnAdapterItemCloseActionListener}
     */
    public void setAdapterItemCloseActionListener(OnAdapterItemCloseActionListener listener) {
        mAdapterItemCloseActionListener = listener;
    }

    /**
     * Method that registers the {@link OnAdapterItemExpandListener} for the
     * Activity to receive the Click event on Collapsed Item
     *
     * @param listener is the instance of the Activity implementing {@link OnAdapterItemExpandListener}
     */
    public void setOnAdapterItemExpandListener(OnAdapterItemExpandListener listener) {
        mOnAdapterItemExpandListener = listener;
    }

    /**
     * Return the view type of the item at <code>position</code> for the purposes
     * of view recycling.
     *
     * @param position position to query
     * @return integer value identifying the type of the view needed to represent the item at
     * <code>position</code>.
     */
    @Override
    public int getItemViewType(int position) {
        return mCompositeItemList.get(position).getRowLayout();
    }

    /**
     * Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent
     * an item.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflating the item Layout view
        //Passing False as we are attaching the View ourselves
        View view = LayoutInflater.from(mContext).inflate(viewType, parent, false);
        switch (viewType) {
            case R.layout.row_layout:
                //Instantiating the ItemViewHolder to initialize the reference to the view components in the this layout
                //and returning the same
                return new ItemViewHolder(view);
            case R.layout.author_card_layout:
                //Instantiating the AuthorViewHolder to initialize the reference to the view components in the this layout
                //and returning the same
                return new AuthorViewHolder(view);
            default:
                //Throwing an exception when an invalid ViewType occurs
                throw new IllegalArgumentException("Unsupported ViewType " + viewType);
        }
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the RecyclerView.ViewHolder#itemView to reflect the item at the given
     * position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //Retrieving the CompositeModel at the current item position
        CompositeModel compositeModel = mCompositeItemList.get(position);
        //Retrieving the ViewType at the current item position
        int itemViewType = getItemViewType(position);

        if (itemViewType == R.layout.row_layout) {
            //For the Item with layout 'R.layout.row_layout'

            //Casting to appropriate ViewHolder
            ItemViewHolder viewHolder = (ItemViewHolder) holder;

            //Reading the colors to use
            int colorPrimary = compositeModel.getColorPrimary();
            int colorPrimaryLight = compositeModel.getColorPrimaryLight();
            int colorPrimaryDark = compositeModel.getColorPrimaryDark();
            int colorAccent = compositeModel.getColorAccent();

            if (position == mExpandedItemPos) {
                //When this item is required to be expanded to a CardView

                //Setting the Title Text
                viewHolder.mFocusedTitleTextView.setText(compositeModel.getTitle());
                //Setting the Description text with Html Content
                TextAppearanceUtility.setHtmlText(viewHolder.mDescriptionTextView, compositeModel.getDescription());

                //Setting the colors for the view components
                viewHolder.mFocusedTitleTextView.setBackgroundColor(colorPrimary);
                viewHolder.mCardContentView.setBackgroundColor(colorPrimaryLight);
                viewHolder.mDescriptionTextView.setTextColor(colorPrimaryDark);
                viewHolder.mCloseButtonView.setTextColor(colorAccent);
                viewHolder.mLearnMoreButtonView.setTextColor(colorAccent);

                //Setting the Fonts to be used for the TextViews
                viewHolder.mFocusedTitleTextView.setTypeface(mItemTitleTextTypeface);
                viewHolder.mDescriptionTextView.setTypeface(mItemDescriptionTextTypeface);

                //Hiding the Default Title TextView
                viewHolder.mTitleTextView.setVisibility(View.GONE);
                //Displaying the CardView
                viewHolder.mIncludedCardView.setVisibility(View.VISIBLE);

                if (mOnAdapterItemExpandListener != null) {
                    //Propagating the call to the listener when registered to receive this event
                    mOnAdapterItemExpandListener.onCollapsedItemClick(position);
                }

            } else {
                //When this items is required to be collapsed as a normal list item

                //Setting the Title Text
                viewHolder.mTitleTextView.setText(compositeModel.getTitle());

                //Setting a Background Linear Gradient for the Title Text : START
                GradientDrawable gradientDrawable = new GradientDrawable();
                //Defining the colors to use for the gradient, in the order mentioned
                gradientDrawable.setColors(new int[]{colorPrimary, colorPrimaryDark, colorPrimary});
                gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                viewHolder.mTitleTextView.setBackground(gradientDrawable);
                //Setting a Background Linear Gradient for the Title Text : END

                //Setting the Font for the Title TextView
                viewHolder.mTitleTextView.setTypeface(mItemTitleTextTypeface);

                //Displaying the Default Title TextView
                viewHolder.mTitleTextView.setVisibility(View.VISIBLE);
                //Hiding the CardView
                viewHolder.mIncludedCardView.setVisibility(View.GONE);
            }

        } else if (itemViewType == R.layout.author_card_layout) {
            //For the Item with layout 'R.layout.author_card_layout'

            //Casting to appropriate ViewHolder
            AuthorViewHolder viewHolder = (AuthorViewHolder) holder;
            //Setting the Fonts to be used for the TextViews
            viewHolder.mAuthorTitleTextView.setTypeface(mAuthorTitleTextTypeface);
            viewHolder.mAuthorTextView.setTypeface(mAuthorTextTypeface);
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter,
     * which is the total number of {@link CompositeModel} objects in the adapter
     */
    @Override
    public int getItemCount() {
        return mCompositeItemList.size();
    }

    /**
     * Method that expands the selected item by position into a CardView
     * and collapses to a normal list item when the position
     * passed is {@link RecyclerView#NO_POSITION}
     *
     * @param position Integer value of the adapter position which needs to be expanded/collapsed
     */
    public void setExpandedItem(int position) {
        //Rebinding the old item first
        notifyItemChanged(mExpandedItemPos);
        //Updating the position of the item to be expanded
        mExpandedItemPos = position;
        if (mExpandedItemPos > RecyclerView.NO_POSITION) {
            //Rebinding the new item when valid
            notifyItemChanged(mExpandedItemPos);
        }
    }

    /**
     * Method that returns the position of the item that was in expanded state
     *
     * @return Integer value of the item position that was in expanded state.
     * This can also be {@link RecyclerView#NO_POSITION} when none of them
     * are in expanded state.
     */
    public int getExpandedItemPos() {
        return mExpandedItemPos;
    }

    /**
     * ViewHolder class for caching View components of the template item view 'R.layout.row_layout'
     */
    private class ItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //Declaring the View components of the template item view
        private TextView mTitleTextView;
        private TextView mFocusedTitleTextView;
        private TextView mDescriptionTextView;
        private Button mCloseButtonView;
        private Button mLearnMoreButtonView;
        private View mIncludedCardView;
        private View mCardContentView;

        /**
         * Constructor of the {@link ItemViewHolder}
         *
         * @param view is the inflated item layout View passed
         *             for caching its View components
         */
        ItemViewHolder(View view) {
            super(view);

            //Finding the view components to cache
            mTitleTextView = view.findViewById(R.id.title_text_id);
            mFocusedTitleTextView = view.findViewById(R.id.focused_title_text_id);
            mDescriptionTextView = view.findViewById(R.id.description_text_id);
            mCloseButtonView = view.findViewById(R.id.button_close_id);
            mLearnMoreButtonView = view.findViewById(R.id.button_learn_more_id);
            mIncludedCardView = view.findViewById(R.id.focused_card_include_id);
            mCardContentView = view.findViewById(R.id.focused_card_content_id);

            //Registering the click listener on Action Buttons
            mCloseButtonView.setOnClickListener(this);
            mLearnMoreButtonView.setOnClickListener(this);
            //Registering the click listener on the Item View
            view.setOnClickListener(this);
        }

        /**
         * Called when a view has been clicked.
         *
         * @param view The view that was clicked.
         */
        @Override
        public void onClick(View view) {
            //Retrieving the position of the item view clicked
            int adapterPosition = getAdapterPosition();
            if (adapterPosition > RecyclerView.NO_POSITION) {
                //Verifying the validity of the position before proceeding

                //Retrieving the CompositeModel at the item position
                CompositeModel compositeModel = mCompositeItemList.get(adapterPosition);

                //Taking action based on the view being clicked
                switch (view.getId()) {
                    case R.id.button_close_id:
                        //For the 'Close' Button Action

                        //Performing the action only when the position of the item last expanded was saved
                        if (mExpandedItemPos > RecyclerView.NO_POSITION) {
                            //Invalidating the expanded item position on Close
                            setExpandedItem(RecyclerView.NO_POSITION);
                            if (mAdapterItemCloseActionListener != null) {
                                //Propagating the call to the listener when registered to receive this event
                                mAdapterItemCloseActionListener.onCloseButtonClick(adapterPosition);
                            }
                        }
                        break;
                    case R.id.button_learn_more_id:
                        //For the 'Learn More' Button Action

                        //Launching the corresponding item's article in a Web Browser
                        IntentUtility.openLink(mContext, compositeModel.getResourceLink());
                        break;
                    default:
                        //For the Item View

                        //Setting the item to expanded CardView state when not expanded previously
                        if (mExpandedItemPos != adapterPosition) {
                            setExpandedItem(adapterPosition);
                        }
                }
            }
        }

    }

    /**
     * ViewHolder class for caching View components of the template item view 'R.layout.author_card_layout'
     */
    private class AuthorViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //Declaring the View components of the template item view
        private TextView mAuthorTitleTextView;
        private TextView mAuthorTextView;
        private ImageView mUdacityImageView;
        private ImageView mGithubImageView;
        private ImageView mLinkedinImageView;

        /**
         * Constructor of {@link AuthorViewHolder}
         *
         * @param view is the inflated item layout View passed
         *             for caching its View components
         */
        AuthorViewHolder(View view) {
            super(view);

            //Finding the view components to cache
            mAuthorTitleTextView = view.findViewById(R.id.author_title_text_id);
            mAuthorTextView = view.findViewById(R.id.author_sign_text_id);
            mUdacityImageView = view.findViewById(R.id.author_udacity_image_id);
            mGithubImageView = view.findViewById(R.id.author_github_image_id);
            mLinkedinImageView = view.findViewById(R.id.author_linkedin_image_id);

            //Registering the click listener on the ImageViews
            mUdacityImageView.setOnClickListener(this);
            mGithubImageView.setOnClickListener(this);
            mLinkedinImageView.setOnClickListener(this);
        }

        /**
         * Called when a view has been clicked.
         *
         * @param view The view that was clicked.
         */
        @Override
        public void onClick(View view) {
            //Retrieving the position of the item view clicked
            int adapterPosition = getAdapterPosition();
            if (adapterPosition > RecyclerView.NO_POSITION) {
                //Verifying the validity of the position before proceeding

                //Taking action based on the view being clicked
                switch (view.getId()) {
                    case R.id.author_udacity_image_id:
                        //For the Udacity ImageView

                        //Opens the webpage of the Scholarship course provided by Udacity
                        IntentUtility.openLink(mContext, mContext.getString(R.string.udacity_course_link));
                        break;
                    case R.id.author_github_image_id:
                        //For the GitHub ImageView

                        //Opens my Github profile
                        IntentUtility.openLink(mContext, mContext.getString(R.string.github_profile_link));
                        break;
                    case R.id.author_linkedin_image_id:
                        //For the LinkedIn ImageView

                        //Opens my LinkedIn profile
                        IntentUtility.openLink(mContext, mContext.getString(R.string.linkedin_profile_link));
                        break;
                }

            }
        }
    }

    /**
     * Interface that declares methods to be implemented by
     * the {@link com.slack.weeklychallengeone.MainActivity}
     * to receive event callbacks related to the 'Close' Button Action
     * on Expanded Items displayed by the RecyclerView's Adapter
     */
    public interface OnAdapterItemCloseActionListener {
        /**
         * Method invoked when the 'Close' Button Action on the Expanded item is clicked
         *
         * @param position is the Adapter position of the item on which this action was executed
         */
        void onCloseButtonClick(int position);
    }

    /**
     * Interface that declares methods to be implemented by
     * the {@link com.slack.weeklychallengeone.MainActivity}
     * to receive event callbacks related to the item click
     * on Collapsed Items displayed by the RecyclerView's Adapter
     */
    public interface OnAdapterItemExpandListener {
        /**
         * Method invoked when the Collapsed item is clicked
         *
         * @param position is the Adapter position of the item on which the user clicked
         */
        void onCollapsedItemClick(int position);
    }
}
