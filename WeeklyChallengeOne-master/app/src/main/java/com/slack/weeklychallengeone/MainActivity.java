package com.slack.weeklychallengeone;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.slack.weeklychallengeone.Utils.Model;
import com.slack.weeklychallengeone.Utils.MyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(getString(R.string.app_name));
        mToolbar = findViewById(R.id.toolbar);
        ImageView imageView = findViewById(R.id.im_background);
        Glide.with(this).load(getDrawable(R.drawable.background_image)).apply(RequestOptions.centerCropTransform()).into(imageView);
        mRecyclerView = findViewById(R.id.recycler_view);
        setSupportActionBar(mToolbar);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        loadData();
    }

    private void loadData() {
        ArrayList<Model> mArrayList = new ArrayList<>();
        mArrayList.add(new Model("Constraint Layout", "A ConstraintLayout is a ViewGroup which allows you to position and size widgets in a flexible way."));
        mArrayList.add(new Model("Linear Layout", "LinearLayout is a view group that aligns all children in a single direction, vertically or horizontally."));
        mArrayList.add(new Model("Relative Layout", "RelativeLayout is a view group that displays child views in relative positions. The position of each view can be specified as relative to sibling elements (such as to the left-of or below another view) or in positions relative to the parent RelativeLayout area (such as aligned to the bottom, left or center)."));
        mArrayList.add(new Model("Card View", "CardView uses elevation property on Lollipop for shadows and falls back to a custom emulated shadow implementation on older platforms."));
        mArrayList.add(new Model("Scroll Views", "A view group that allows the view hierarchy placed within it to be scrolled. Scroll view may have only one direct child placed within it."));
        mArrayList.add(new Model("Grid View", "GridView is a ViewGroup that displays items in a two-dimensional, scrollable grid. The grid items are automatically inserted to the layout using a ListAdapter."));

        MyAdapter mAdapter = new MyAdapter(this, mArrayList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
