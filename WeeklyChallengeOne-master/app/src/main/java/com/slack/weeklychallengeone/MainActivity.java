package com.slack.weeklychallengeone;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageButton;

import com.slack.weeklychallengeone.Utils.Model;
import com.slack.weeklychallengeone.Utils.MyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.ItemClickListener{

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

        mArrayList.add(new Model("Constraint Layout", "A ConstraintLayout is a ViewGroup which allows you to position and size widgets in a flexible way."));
        mArrayList.add(new Model("Linear Layout", "A layout that arranges other views either horizontally in a single column or vertically in a single row."));
        mArrayList.add(new Model("Relative Layout", "A Layout where the positions of the children can be described in relation to each other or to the parent."));
        mArrayList.add(new Model("Card View", "A FrameLayout with a rounded corner background and shadow.\n" +
                "CardView uses elevation property on Lollipop for shadows and falls back to a custom emulated shadow implementation on older platforms."));
        mArrayList.add(new Model("Scroll Views", "A view group that allows the view hierarchy placed within it to be scrolled. Scroll view may have only one direct child placed within it. "));
        mArrayList.add(new Model("Grid View", "A view that shows items in two-dimensional scrolling grid. The items in the grid come from the ListAdapter associated with this view."));

        mAdapter = new MyAdapter(this, mArrayList, this);
        mRecyclerView.setAdapter(mAdapter);

    }


    @Override
    public void onItemClick(View view, View buttonView) {
        int visibility = view.getVisibility();
        if(visibility == View.GONE){
            view.setVisibility(View.VISIBLE);
            ((ImageButton)buttonView).setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));
        } else {
            view.setVisibility(View.GONE);
            ((ImageButton)buttonView).setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_drop_down_black_24dp));
        }
    }
}
