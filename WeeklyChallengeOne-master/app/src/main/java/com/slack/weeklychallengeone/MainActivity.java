package com.slack.weeklychallengeone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.slack.weeklychallengeone.Utils.Model;
import com.slack.weeklychallengeone.Utils.MyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Model> mArrayList;
    MyAdapter mAdapter;
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();
        initViews();

    }


    private void initViews() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));
        mAdapter = new MyAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter);
    }


    private void loadData() {

        mArrayList = new ArrayList<>();

        mArrayList.add(new Model("Constraint Layout", getResources().getString(R.string.cons_layout_desc)));
        mArrayList.add(new Model("Linear Layout", getResources().getString(R.string.linear_layout_desc)));
        mArrayList.add(new Model("Relative Layout", getResources().getString(R.string.rel_layout_Desc)));
        mArrayList.add(new Model("Card View", getResources().getString(R.string.cardview_desc)));
        mArrayList.add(new Model("Scroll Views", getResources().getString(R.string.scrollview_desc)));
        mArrayList.add(new Model("Grid View", getResources().getString(R.string.gridview_desc)));
    }

}
