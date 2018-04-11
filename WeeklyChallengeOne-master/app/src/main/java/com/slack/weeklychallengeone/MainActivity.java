package com.slack.weeklychallengeone;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.transition.Scene;
import android.support.transition.Transition;
import android.support.transition.TransitionInflater;
import android.support.transition.TransitionManager;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.slack.weeklychallengeone.Utils.Model;
import com.slack.weeklychallengeone.Utils.MyAdapter;
import com.slack.weeklychallengeone.data.LayoutContract;
import com.slack.weeklychallengeone.data.LayoutDbHelper;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    private MyAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private LayoutDbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyler_view);
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
        dbHelper = new LayoutDbHelper(this);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor c = database.query(
                LayoutContract.LayoutEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                LayoutContract.LayoutEntry.COLUMN_POSITION
                );

        mAdapter = new MyAdapter(c, new MyAdapter.ListClickListener() {
            @Override
            public void onClick(Model m,View v) {
                Intent i = new Intent(MainActivity.this,LayoutDetailsActivity.class);
                i.putExtra(LayoutDetailsActivity.LAYOUT_NAME,m.getName());
                i.putExtra(LayoutDetailsActivity.LAYOUT_LINK,m.getLink());
                Pair<View,String> p1 = Pair.create(v,"layout");
                Pair<View,String> p2 = Pair.create(v.findViewById(R.id.tv_name),"layout_title");
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(MainActivity.this, p1,p2);
                startActivity(i,options.toBundle());
            }
        });
        mRecyclerView.setAdapter(mAdapter);

    }



}
