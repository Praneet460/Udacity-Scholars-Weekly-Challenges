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

        mArrayList.add(new Model("Constraint Layout","A ConstraintLayout allows you to position and size widgets in a flexible way.","C"));
        mArrayList.add(new Model("Linear Layout","Easy to use, orientation specific", "L"));
        mArrayList.add(new Model("Relative Layout","Most Flexible and commonly used layout","R"));
        mArrayList.add(new Model("Card View","Card View. Looks beautiful!","C"));
        mArrayList.add(new Model("Scroll Views","Lets you scroll content easily.","S"));
        mArrayList.add(new Model("Grid View","Best for photo albums!","G"));

        mAdapter = new MyAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
