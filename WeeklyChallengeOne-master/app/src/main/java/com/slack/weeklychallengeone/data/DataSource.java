package com.slack.weeklychallengeone.data;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.slack.weeklychallengeone.R;
import com.slack.weeklychallengeone.models.CompositeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Class responsible for preparing the Data required by the
 * RecyclerView's Adapter {@link com.slack.weeklychallengeone.adapters.MyAdapter}
 *
 * @author Kaushik N Sanji
 */
public class DataSource {

    /**
     * Method that generates the Data required by the RecyclerView's Adapter
     * {@link com.slack.weeklychallengeone.adapters.MyAdapter}
     *
     * @param context is the context of the Activity hosting the RecyclerView
     *                to show this data
     * @return List of {@link CompositeModel} objects required by {@link com.slack.weeklychallengeone.adapters.MyAdapter}
     */
    public static List<CompositeModel> getAdapterData(Context context) {
        ArrayList<CompositeModel> compositeModelArrayList = new ArrayList<>();

        //For Constraint Layout
        compositeModelArrayList.add(new CompositeModel.Builder()
                .setRowLayoutId(R.layout.row_layout)
                .setTitle(context.getString(R.string.constraint_layout_title))
                .setDescription(context.getString(R.string.constraint_layout_desc))
                .setResourceLink(context.getString(R.string.constraint_layout_link))
                .setColorPrimary(ContextCompat.getColor(context, R.color.constraintLayoutColorPrimary))
                .setColorPrimaryDark(ContextCompat.getColor(context, R.color.constraintLayoutColorPrimaryDark))
                .setColorPrimaryLight(ContextCompat.getColor(context, R.color.constraintLayoutColorPrimaryLight))
                .setColorAccent(ContextCompat.getColor(context, R.color.constraintLayoutColorAccent))
                .build());

        //For Linear Layout
        compositeModelArrayList.add(new CompositeModel.Builder()
                .setRowLayoutId(R.layout.row_layout)
                .setTitle(context.getString(R.string.linear_layout_title))
                .setDescription(context.getString(R.string.linear_layout_desc))
                .setResourceLink(context.getString(R.string.linear_layout_link))
                .setColorPrimary(ContextCompat.getColor(context, R.color.linearLayoutColorPrimary))
                .setColorPrimaryDark(ContextCompat.getColor(context, R.color.linearLayoutColorPrimaryDark))
                .setColorPrimaryLight(ContextCompat.getColor(context, R.color.linearLayoutColorPrimaryLight))
                .setColorAccent(ContextCompat.getColor(context, R.color.linearLayoutColorAccent))
                .build());

        //For Relative Layout
        compositeModelArrayList.add(new CompositeModel.Builder()
                .setRowLayoutId(R.layout.row_layout)
                .setTitle(context.getString(R.string.relative_layout_title))
                .setDescription(context.getString(R.string.relative_layout_desc))
                .setResourceLink(context.getString(R.string.relative_layout_link))
                .setColorPrimary(ContextCompat.getColor(context, R.color.relativeLayoutColorPrimary))
                .setColorPrimaryDark(ContextCompat.getColor(context, R.color.relativeLayoutColorPrimaryDark))
                .setColorPrimaryLight(ContextCompat.getColor(context, R.color.relativeLayoutColorPrimaryLight))
                .setColorAccent(ContextCompat.getColor(context, R.color.relativeLayoutColorAccent))
                .build());

        //For Card View
        compositeModelArrayList.add(new CompositeModel.Builder()
                .setRowLayoutId(R.layout.row_layout)
                .setTitle(context.getString(R.string.card_view_layout_title))
                .setDescription(context.getString(R.string.card_view_layout_desc))
                .setResourceLink(context.getString(R.string.card_view_layout_link))
                .setColorPrimary(ContextCompat.getColor(context, R.color.cardViewLayoutColorPrimary))
                .setColorPrimaryDark(ContextCompat.getColor(context, R.color.cardViewLayoutColorPrimaryDark))
                .setColorPrimaryLight(ContextCompat.getColor(context, R.color.cardViewLayoutColorPrimaryLight))
                .setColorAccent(ContextCompat.getColor(context, R.color.cardViewLayoutColorAccent))
                .build());

        //For Scroll View
        compositeModelArrayList.add(new CompositeModel.Builder()
                .setRowLayoutId(R.layout.row_layout)
                .setTitle(context.getString(R.string.scroll_view_layout_title))
                .setDescription(context.getString(R.string.scroll_view_layout_desc))
                .setResourceLink(context.getString(R.string.scroll_view_layout_link))
                .setColorPrimary(ContextCompat.getColor(context, R.color.scrollViewLayoutColorPrimary))
                .setColorPrimaryDark(ContextCompat.getColor(context, R.color.scrollViewLayoutColorPrimaryDark))
                .setColorPrimaryLight(ContextCompat.getColor(context, R.color.scrollViewLayoutColorPrimaryLight))
                .setColorAccent(ContextCompat.getColor(context, R.color.scrollViewLayoutColorAccent))
                .build());

        //For Grid View
        compositeModelArrayList.add(new CompositeModel.Builder()
                .setRowLayoutId(R.layout.row_layout)
                .setTitle(context.getString(R.string.grid_view_layout_title))
                .setDescription(context.getString(R.string.grid_view_layout_desc))
                .setResourceLink(context.getString(R.string.grid_view_layout_link))
                .setColorPrimary(ContextCompat.getColor(context, R.color.gridViewLayoutColorPrimary))
                .setColorPrimaryDark(ContextCompat.getColor(context, R.color.gridViewLayoutColorPrimaryDark))
                .setColorPrimaryLight(ContextCompat.getColor(context, R.color.gridViewLayoutColorPrimaryLight))
                .setColorAccent(ContextCompat.getColor(context, R.color.gridViewLayoutColorAccent))
                .build());

        //For List View
        compositeModelArrayList.add(new CompositeModel.Builder()
                .setRowLayoutId(R.layout.row_layout)
                .setTitle(context.getString(R.string.list_view_layout_title))
                .setDescription(context.getString(R.string.list_view_layout_desc))
                .setResourceLink(context.getString(R.string.list_view_layout_link))
                .setColorPrimary(ContextCompat.getColor(context, R.color.listViewLayoutColorPrimary))
                .setColorPrimaryDark(ContextCompat.getColor(context, R.color.listViewLayoutColorPrimaryDark))
                .setColorPrimaryLight(ContextCompat.getColor(context, R.color.listViewLayoutColorPrimaryLight))
                .setColorAccent(ContextCompat.getColor(context, R.color.listViewLayoutColorAccent))
                .build());

        //For Recycler View
        compositeModelArrayList.add(new CompositeModel.Builder()
                .setRowLayoutId(R.layout.row_layout)
                .setTitle(context.getString(R.string.recycler_view_layout_title))
                .setDescription(context.getString(R.string.recycler_view_layout_desc))
                .setResourceLink(context.getString(R.string.recycler_view_layout_link))
                .setColorPrimary(ContextCompat.getColor(context, R.color.recyclerViewLayoutColorPrimary))
                .setColorPrimaryDark(ContextCompat.getColor(context, R.color.recyclerViewLayoutColorPrimaryDark))
                .setColorPrimaryLight(ContextCompat.getColor(context, R.color.recyclerViewLayoutColorPrimaryLight))
                .setColorAccent(ContextCompat.getColor(context, R.color.recyclerViewLayoutColorAccent))
                .build());

        //For the Author Card
        compositeModelArrayList.add(new CompositeModel.Builder().setRowLayoutId(R.layout.author_card_layout).build());

        //Returning the CompositeModel data prepared
        return compositeModelArrayList;
    }
}
