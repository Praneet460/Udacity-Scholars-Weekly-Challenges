package com.slack.weeklychallengeone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.slack.weeklychallengeone.Utils.Model;
import com.slack.weeklychallengeone.Utils.MyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.MyAdapterListener{

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
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(layoutManager);
    }






    private void loadData(){

        mArrayList = new ArrayList<>();

        mArrayList.add(new Model("Constraint Layout", getString(R.string.constraint_description),
                "https://developer.android.com/reference/android/support/constraint/ConstraintLayout.html"));
        mArrayList.add(new Model("Linear Layout",getString(R.string.linear_description),
                "https://developer.android.com/reference/android/widget/LinearLayout.html"));
        mArrayList.add(new Model("Relative Layout", getString(R.string.relative_description),
                "https://developer.android.com/reference/android/widget/RelativeLayout.html"));
        mArrayList.add(new Model("Card View", getString(R.string.cardview_description),
                "https://developer.android.com/reference/android/support/v7/widget/CardView.html"));
        mArrayList.add(new Model("Scroll Views", getString(R.string.scrollview_description),
                "https://developer.android.com/reference/android/widget/ScrollView.html"));
        mArrayList.add(new Model("Grid View", getString(R.string.gridview_description),
                "https://developer.android.com/reference/android/widget/GridView.html"));



        mAdapter = new MyAdapter(this, mArrayList, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void toggleSelection(int position) {
        mAdapter.toggleSelection(position);
    }


    @Override
    public void onItemClicked(int position) {
        toggleSelection(position);
    }

    @Override
    public void onIconBookmarkClicked(int position) {
        Model model = mArrayList.get(position);
        model.setImportant(!model.isImportant());
        mArrayList.set(position, model);
        mAdapter.notifyDataSetChanged();
    }
}
