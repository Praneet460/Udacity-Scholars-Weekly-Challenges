package com.slack.weeklychallengeone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.slack.weeklychallengeone.Utils.Model;
import com.slack.weeklychallengeone.Utils.MyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        loadData();
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void loadData() {
        ArrayList<Model> mArrayList = new ArrayList<>();

        mArrayList.add(new Model("Constraint Layout", "extends ViewGroup", "A ConstraintLayout is a ViewGroup which allows you to position and size widgets in a flexible way."));
        mArrayList.add(new Model("Linear Layout", "extends ViewGroup", "A layout that arranges other views either horizontally in a single column or vertically in a single row."));
        mArrayList.add(new Model("Relative Layout", "extends ViewGroup", "A Layout where the positions of the children can be described in relation to each other or to the parent."));
        mArrayList.add(new Model("Card View", "extends FrameLayout", "A FrameLayout with a rounded corner background and shadow. CardView uses elevation property on Lollipop for shadows and falls back to a custom emulated shadow implementation on older platforms."));
        mArrayList.add(new Model("Scroll Views", "extends FrameLayout ", "A view group that allows the view hierarchy placed within it to be scrolled. Scroll view may have only one direct child placed within it."));
        mArrayList.add(new Model("Grid View", "extends AbsListView", "GridView is a ViewGroup that displays items in a two-dimensional, scrollable grid. The grid items are automatically inserted to the layout using a ListAdapter."));

        MyAdapter mAdapter = new MyAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
