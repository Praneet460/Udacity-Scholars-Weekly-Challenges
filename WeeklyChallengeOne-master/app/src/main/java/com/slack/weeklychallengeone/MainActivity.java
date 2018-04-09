package com.slack.weeklychallengeone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
    }






    private void loadData(){

        mArrayList = new ArrayList<>();

        mArrayList.add(new Model("Constraint Layout"));
        mArrayList.add(new Model("Linear Layout"));
        mArrayList.add(new Model("Relative Layout"));
        mArrayList.add(new Model("Card View"));
        mArrayList.add(new Model("Scroll Views"));
        mArrayList.add(new Model("Grid View"));



        mAdapter = new MyAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter);

    }



}
