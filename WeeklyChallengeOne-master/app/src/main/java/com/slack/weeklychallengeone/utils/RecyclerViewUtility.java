package com.slack.weeklychallengeone.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Utility class that provides convenience methods for use with {@link RecyclerView}
 *
 * @author Kaushik N Sanji
 */
public class RecyclerViewUtility {

    /**
     * Method that retrieves the item position of the first completely visible
     * or the partially visible item in the screen of the {@link RecyclerView}
     *
     * @param recyclerView is the instance of the {@link RecyclerView}
     * @return is the Integer value of the first item position that is currently visible in the screen
     */
    private static int getFirstVisibleItemPosition(RecyclerView recyclerView) {
        //Retrieving the Layout Manager of the RecyclerView
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            //When the Layout Manager is an instance of LinearLayoutManager

            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            //Retrieving the top completely visible item position
            int position = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            //Checking the validity of the above position
            if (position > RecyclerView.NO_POSITION) {
                return position; //Returning the same if valid
            } else {
                //Else, returning the top partially visible item position
                return linearLayoutManager.findFirstVisibleItemPosition();
            }
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            //When the Layout Manager is an instance of StaggeredGridLayoutManager

            StaggeredGridLayoutManager gridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            //Retrieving the top completely visible item position
            int position = gridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[0];
            //Checking the validity of the above position
            if (position > RecyclerView.NO_POSITION) {
                return position; //Returning the same if valid
            } else {
                //Else, returning the top partially visible item position
                return gridLayoutManager.findFirstVisibleItemPositions(null)[0];
            }
        }

        //On all else, returning -1 (RecyclerView.NO_POSITION)
        return RecyclerView.NO_POSITION;
    }

    /**
     * Method that smoothly scrolls to the item position passed in a vertical {@link RecyclerView}
     * such that the item gets displayed at the top of the parent {@link RecyclerView}.
     *
     * @param recyclerView   is the instance of the {@link RecyclerView}
     * @param targetPosition Integer value representing the adapter position of
     *                       the item view in the {@link RecyclerView}
     *                       to which the screen needs to be scrolled to.
     */
    private static void smoothVScrollToPositionWithViewTop(RecyclerView recyclerView, int targetPosition) {
        //Configuring the LinearSmoothScroller
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) {
            /**
             * When scrolling towards a child view, this method defines whether we should align the top
             * or the bottom edge of the child with the parent RecyclerView.
             *
             * @return SNAP_TO_START to align the top of the child with the parent RecyclerView.
             */
            @Override
            protected int getVerticalSnapPreference() {
                return LinearSmoothScroller.SNAP_TO_START;
            }
        };
        //Setting the item position to scroll to
        linearSmoothScroller.setTargetPosition(targetPosition);
        //Initiating the smooth scroll with LinearSmoothScroller
        recyclerView.getLayoutManager().startSmoothScroll(linearSmoothScroller);
    }

    /**
     * Method that scrolls the RecyclerView to the specified adapter position with the given offset from resolved layout
     * start.
     *
     * @param recyclerView   is the instance of the {@link RecyclerView}
     * @param targetPosition Integer value representing the adapter position of
     *                       the item view in the {@link RecyclerView}
     *                       to which the screen needs to be scrolled to.
     * @param offset         The distance (in pixels) between the start edge of the item view and
     *                       start edge of the RecyclerView.
     */
    private static void scrollToPositionWithOffset(RecyclerView recyclerView, int targetPosition, int offset) {
        //Retrieving the Layout Manager of the RecyclerView
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

        if (layoutManager instanceof LinearLayoutManager) {
            //When the Layout Manager is an instance of LinearLayoutManager
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            //Scrolling to the specified position with offset
            linearLayoutManager.scrollToPositionWithOffset(targetPosition, offset);

        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            //When the Layout Manager is an instance of StaggeredGridLayoutManager
            StaggeredGridLayoutManager gridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            //Scrolling to the specified position with offset
            gridLayoutManager.scrollToPositionWithOffset(targetPosition, offset);
        }
    }

    /**
     * Method that sets the Layout Manager's currently viewing position to the item position specified
     *
     * @param recyclerView    is the instance of the {@link RecyclerView}
     * @param targetPosition  Integer value representing the adapter position of
     *                        the item view in the {@link RecyclerView}
     *                        to which the screen needs to be scrolled to.
     * @param offset          The distance (in pixels) between the start edge of the item view and
     *                        start edge of the RecyclerView. Applicable only when #scrollImmediate is TRUE
     * @param scrollImmediate is a boolean which denotes the way in which the scroll to position
     *                        needs to be handled
     *                        <br/><b>TRUE</b> if the scroll to position needs to be set immediately
     *                        without any animation
     *                        <br/><b>FALSE</b> if the scroll to position needs to be done naturally
     *                        with the default animation
     */
    public static void verticalScrollToItemPosition(RecyclerView recyclerView, int targetPosition, int offset, boolean scrollImmediate) {
        if (targetPosition > RecyclerView.NO_POSITION) {
            //Scrolling to the item position passed when valid

            //Validating the position passed is different from the top one to update if required
            if (RecyclerViewUtility.getFirstVisibleItemPosition(recyclerView) != targetPosition) {
                if (scrollImmediate) {
                    //Scrolling to the item position immediately
                    scrollToPositionWithOffset(recyclerView, targetPosition, offset);
                } else {
                    //Scrolling to the item position naturally with smooth scroll
                    smoothVScrollToPositionWithViewTop(recyclerView, targetPosition);
                }
            }
        }
    }

}
