package com.slack.weeklychallengeone;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.slack.weeklychallengeone.adapters.MyAdapter;
import com.slack.weeklychallengeone.data.DataSource;
import com.slack.weeklychallengeone.utils.RecyclerViewUtility;

/**
 * Main Activity of the App that inflates the layout 'R.layout.activity_main'
 * containing the RecyclerView whose data is loaded by the Adapter {@link MyAdapter}
 *
 * @author Kaushik N Sanji
 */
public class MainActivity extends AppCompatActivity
        implements MyAdapter.OnAdapterItemCloseActionListener,
        MyAdapter.OnAdapterItemExpandListener {

    //For the RecyclerView
    private RecyclerView mRecyclerView;
    //For the Adapter of RecyclerView
    private MyAdapter mRecyclerAdapter;

    //Bundle Key Constant to save/restore the value of the Expanded Adapter Item position
    private static String EXPANDED_ITEM_VIEW_POSITION_INT_KEY = "RecyclerView.ExpandedItemPosition";

    //Called when the activity is to be created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Modifying the existing Toolbar to show Icon
        setupToolbarWithIcon();

        //Initializing the RecyclerView
        setupRecyclerView();
    }

    /**
     * Called to retrieve per-instance state from an activity before being killed
     * so that the state can be restored in {@link #onCreate} or
     * {@link #onRestoreInstanceState} (the {@link Bundle} populated by this method
     * will be passed to both).
     * <p>
     * <p>This method is called before an activity may be killed so that when it
     * comes back some time in the future it can restore its state.
     * <p>
     * <p>If called, this method will occur before {@link #onStop}.  There are
     * no guarantees about whether it will occur before or after {@link #onPause}.
     *
     * @param outState Bundle in which to place your saved state.
     * @see #onCreate
     * @see #onRestoreInstanceState
     * @see #onPause
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Saving the last expanded item
        outState.putInt(EXPANDED_ITEM_VIEW_POSITION_INT_KEY,
                (mRecyclerAdapter != null ? mRecyclerAdapter.getExpandedItemPos() : RecyclerView.NO_POSITION)
        );
    }

    /**
     * This method is called after {@link #onStart} when the activity is
     * being re-initialized from a previously saved state, given here in
     * <var>savedInstanceState</var>.
     * <p>This method is called between {@link #onStart} and
     * {@link #onPostCreate}.
     *
     * @param savedInstanceState the data most recently supplied in {@link #onSaveInstanceState}.
     * @see #onCreate
     * @see #onPostCreate
     * @see #onResume
     * @see #onSaveInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //Restoring the Expanded item state if present : START
        int expandedItemPosition = savedInstanceState.getInt(EXPANDED_ITEM_VIEW_POSITION_INT_KEY);
        if (expandedItemPosition > RecyclerView.NO_POSITION) {
            mRecyclerAdapter.setExpandedItem(expandedItemPosition);
        }
        //Restoring the Expanded item state if present : END

    }

    /**
     * Method that sets up the ActionBar/Toolbar to show the App Icon
     */
    private void setupToolbarWithIcon() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            //Enabling 'showHome' Option
            supportActionBar.setDisplayShowHomeEnabled(true);
            //Enabling 'useLogo' Option
            supportActionBar.setDisplayUseLogoEnabled(true);
            //Setting the Logo to show
            supportActionBar.setLogo(R.mipmap.ic_launcher);
        }
    }

    /**
     * Method that initializes the Layout Manager, Adapter
     * and Listeners for the RecyclerView
     */
    private void setupRecyclerView() {
        //Finding the RecyclerView
        mRecyclerView = findViewById(R.id.recyler_view);

        //Initializing the LinearLayoutManager with Vertical Orientation and start to end layout direction
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        //Setting the LayoutManager on the RecyclerView
        mRecyclerView.setLayoutManager(linearLayoutManager);

        //Initializing the Adapter for the List view
        mRecyclerAdapter = new MyAdapter(this, DataSource.getAdapterData(this));

        //Registering the OnAdapterItemCloseActionListener
        mRecyclerAdapter.setAdapterItemCloseActionListener(this);

        //Registering the OnAdapterItemExpandListener
        mRecyclerAdapter.setOnAdapterItemExpandListener(this);

        //Setting the Adapter on the RecyclerView
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    /**
     * Method invoked when the 'Close' Button Action on the Expanded item is clicked
     *
     * @param position is the Adapter position of the item on which this action was executed
     */
    @Override
    public void onCloseButtonClick(final int position) {
        //Scrolling to the item position passed after a delay of 10ms
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                RecyclerViewUtility.verticalScrollToItemPosition(mRecyclerView, position, 0, false);
            }
        }, 10); //delay mentioned to allow the RecyclerView animations to complete within that time
    }

    /**
     * Method invoked when the Collapsed item is clicked
     *
     * @param position is the Adapter position of the item on which the user clicked
     */
    @Override
    public void onCollapsedItemClick(final int position) {
        //Scrolling to the item position passed after a delay of 10ms
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.scrollToPosition(position);
            }
        }, 10); //delay mentioned to allow the RecyclerView animations to complete within that time
    }

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {

        //Implementing the 'Close' Button Action if any item is expanded, on click of Back Key
        if (mRecyclerAdapter != null && mRecyclerAdapter.getExpandedItemPos() > RecyclerView.NO_POSITION) {
            //Saving the position of expanded item
            int expandedItemPosition = mRecyclerAdapter.getExpandedItemPos();
            //Collapsing the Expanded Item
            mRecyclerAdapter.setExpandedItem(RecyclerView.NO_POSITION);
            //Scrolling to the last expanded item position after collapsing it
            onCloseButtonClick(expandedItemPosition);
            return;
        }

        super.onBackPressed();
    }

}