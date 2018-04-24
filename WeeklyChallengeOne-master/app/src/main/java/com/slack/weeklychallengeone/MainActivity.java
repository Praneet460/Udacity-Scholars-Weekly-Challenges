package com.slack.weeklychallengeone;

import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.slack.weeklychallengeone.Utils.Model;
import com.slack.weeklychallengeone.Utils.MyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Model> mArrayList;
    private MyAdapter mAdapter;
    private RecyclerView mRecyclerView; // added this line
    private Intent mIntent;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // changed xml file name and removed space


        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(" Weekly Challenge One");
        getSupportActionBar().setLogo(R.drawable.ic_favorite_black_24dp);

        initViews();
        loadData();

    }


    private void initViews() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this); // corrected spelling of this
        mRecyclerView.setLayoutManager(layoutManager); // removed extra s from the mRecyclerView

        final SwipeController swipeController = new SwipeController(new SwipeControllerAction() {
            @Override
            public void onButtonClick(int position) {
                mIntent = new Intent(Intent.ACTION_VIEW, mArrayList.get(position).getUri());
                if (mIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mIntent);
                }
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });
    }


    //removed multiline comments
    private void loadData() {

        mArrayList = new ArrayList<>();

        mArrayList.add(new Model("Relative Layout",
                buildUri("https://developer.android.com/guide/topics/ui/layout/relative.html"),R.drawable.card_grad1));
        mArrayList.add(new Model("Card View",
                buildUri("https://developer.android.com/reference/android/support/v7/widget/CardView.html"),R.drawable.card_grad2));
        mArrayList.add(new Model("Scroll Views",
                buildUri("https://developer.android.com/reference/android/widget/ScrollView.html"),R.drawable.card_grad3));
        mArrayList.add(new Model("Grid View",
                buildUri("https://developer.android.com/guide/topics/ui/layout/gridview.html"),R.drawable.card_grad4));
        mArrayList.add(new Model("Constraint Layout",
                buildUri("https://developer.android.com/reference/android/support/constraint/ConstraintLayout.html"), R.drawable.card_grad5));
        mArrayList.add(new Model("Linear Layout",
                buildUri("https://developer.android.com/guide/topics/ui/layout/linear.html"),R.drawable.card_grad6));


        mAdapter = new MyAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter); //removed comment

    }

        private Uri buildUri (String uri){
            return Uri.parse(uri);
        }

    }




