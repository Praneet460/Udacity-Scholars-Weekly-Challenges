package com.slack.weeklychallengeone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.slack.weeklychallengeone.Utils.Model;
import com.slack.weeklychallengeone.Utils.MyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Model> mArrayList;
    private MyAdapter mAdapter;

    //Create a RecyclerView object.
    private RecyclerView mRecyclerView;
    CardView constCardView, llCardView, rlCardView, glCardView, svCardView, cvCardView;
    ImageView constImageOne, constImageTwo, constImageThree, constImageFour;
    View llItemOne, llItemTwo, llItemThree, llItemFour, llItemFive, llItemSix;
    View rlItemOne, rlItemTwo, rlItemThree, rlItemFour, rlItemFive;
    View glItemOne, glItemTwo, glItemThree, glItemFour, glItemFive, glItemSix, svItem, cvItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.list_layout);// Change the layout typo.
        constImageOne = findViewById(R.id.const_one_img);
        constImageTwo = findViewById(R.id.const_two_img);
        constImageThree = findViewById(R.id.const_three_img);
        constImageFour = findViewById(R.id.const_four_img);

        llItemOne = findViewById(R.id.ll_item_one);
        llItemTwo = findViewById(R.id.ll_item_two);
        llItemThree = findViewById(R.id.ll_item_three);
        llItemFour = findViewById(R.id.ll_item_four);
        llItemFive = findViewById(R.id.ll_item_five);
        llItemSix = findViewById(R.id.ll_item_six);


        rlItemOne = findViewById(R.id.rl_item_one);
        rlItemTwo = findViewById(R.id.rl_item_two);
        rlItemThree = findViewById(R.id.rl_item_three);
        rlItemFour = findViewById(R.id.rl_item_four);
        rlItemFive = findViewById(R.id.rl_item_five);

        glItemOne = findViewById(R.id.gl_item_one);
        glItemTwo = findViewById(R.id.gl_item_two);
        glItemThree = findViewById(R.id.gl_item_three);
        glItemFour = findViewById(R.id.gl_item_four);
        glItemFive = findViewById(R.id.gl_item_five);
        glItemSix = findViewById(R.id.gl_item_six);

        svItem = findViewById(R.id.scroll_view_item);
        cvItem = findViewById(R.id.card_view_item);

        constCardView = findViewById(R.id.card_const_layout);
        llCardView = findViewById(R.id.card_ll_layout);
        rlCardView = findViewById(R.id.card_rl_layout);
        glCardView = findViewById(R.id.card_gl_layout);
        svCardView = findViewById(R.id.card_sv_layout);
        cvCardView = findViewById(R.id.card_cv_layout);

        constCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair<View, String> pair1 = Pair.create((View) constImageOne, "const_one_img");
                Pair<View, String> pair2 = Pair.create((View) constImageTwo, "const_two_img");
                Pair<View, String> pair3 = Pair.create((View) constImageThree, "const_three_img");
                Pair<View, String> pair4 = Pair.create((View) constImageFour, "const_four_img");
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, pair1, pair2, pair3, pair4);

                startActivity(new Intent(MainActivity.this, ConstraintLayoutActivity.class), optionsCompat.toBundle());
//                startActivity(new Intent(MainActivity.this, ConstraintLayoutActivity.class));
            }
        });


        llCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair<View, String> pair1 = Pair.create((View) llItemOne, "ll_item_one");
                Pair<View, String> pair2 = Pair.create((View) llItemTwo, "ll_item_two");
                Pair<View, String> pair3 = Pair.create((View) llItemThree, "ll_item_three");
                Pair<View, String> pair4 = Pair.create((View) llItemFour, "ll_item_four");
                Pair<View, String> pair5 = Pair.create((View) llItemFive, "ll_item_five");
                Pair<View, String> pair6 = Pair.create((View) llItemSix, "ll_item_six");
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, pair1, pair2, pair3, pair4, pair5, pair6);

                startActivity(new Intent(MainActivity.this, LinearLayoutActivity.class), optionsCompat.toBundle());
            }
        });

        rlCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair<View, String> pair1 = Pair.create((View) rlItemOne, "rl_item_one");
                Pair<View, String> pair2 = Pair.create((View) rlItemTwo, "rl_item_two");
                Pair<View, String> pair3 = Pair.create((View) rlItemThree, "rl_item_three");
                Pair<View, String> pair4 = Pair.create((View) rlItemFour, "rl_item_four");
                Pair<View, String> pair5 = Pair.create((View) rlItemFive, "rl_item_five");
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, pair1, pair2, pair3, pair4, pair5);

                startActivity(new Intent(MainActivity.this, RelativeLayout.class), optionsCompat.toBundle());
            }
        });

        glCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair<View, String> pair1 = Pair.create((View) glItemOne, "gl_item_one");
                Pair<View, String> pair2 = Pair.create((View) glItemTwo, "gl_item_two");
                Pair<View, String> pair3 = Pair.create((View) glItemThree, "gl_item_three");
                Pair<View, String> pair4 = Pair.create((View) glItemFour, "gl_item_four");
                Pair<View, String> pair5 = Pair.create((View) glItemFive, "gl_item_five");
                Pair<View, String> pair6 = Pair.create((View) glItemSix, "gl_item_six");
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, pair1, pair2, pair3, pair4, pair5, pair6);

                startActivity(new Intent(MainActivity.this, GridLayoutActivity.class), optionsCompat.toBundle());

            }
        });

        svCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair<View, String> pair = Pair.create((View) svItem, "scroll_view_item");
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, pair);

                startActivity(new Intent(MainActivity.this, ScrollViewActivity.class), optionsCompat.toBundle());
            }
        });

        cvCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair<View, String> pair = Pair.create((View) cvItem, "card_view_item");
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, pair);

                startActivity(new Intent(MainActivity.this, CardViewActivity.class), optionsCompat.toBundle());

            }
        });


//        initViews();
//        loadData();

    }


    private void initViews() {
        mRecyclerView = findViewById(R.id.recyler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);// Change the typo from mRecyclerViews to mRecyclerView
    }


    //Uncomment this loadData() method.
    private void loadData() {

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
