package com.slack.weeklychallengeone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.slack.weeklychallengeone.Utils.Model;
import com.slack.weeklychallengeone.Utils.MyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Model> mArrayList;
    private MyAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        loadData();
    }

    private void initViews(){
        mRecyclerView = findViewById(R.id.recyler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void loadData(){
        mArrayList = new ArrayList<>();
        mArrayList.add(new Model("Constraint Layout", 1));
        mArrayList.add(new Model("Linear Layout", 2));
        mArrayList.add(new Model("Relative Layout", 3));
        mArrayList.add(new Model("Card View", 4));
        mArrayList.add(new Model("Scroll Views", 5));
        mArrayList.add(new Model("Grid View", 6));
        mAdapter = new MyAdapter(this, mArrayList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
