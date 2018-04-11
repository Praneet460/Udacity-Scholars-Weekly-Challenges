package com.slack.weeklychallengeone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.slack.weeklychallengeone.Utils.Model;
import com.slack.weeklychallengeone.Utils.MyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Model> mArrayList;
    private MyAdapter mAdapter;
    private  RecyclerView mRecyclerView;

    private final String name[] ={
            "Constraint Layout",
             "Linear Layout",
            "Relative Layout",
            "Card View",
            "Scroll Views",
            "Grid View"
    };

    private final String description[]={
            "ConstraintLayout allows you to create large and complex layouts with a flat view hierarchy (no nested view groups). It's similar to RelativeLayout in that all views are laid out according to relationships between sibling views and the parent layout, but it's more flexible than RelativeLayout and easier to use with Android Studio's Layout Editor.",
            "Android LinearLayout is a view group that aligns all children in either vertically or horizontally.",
            "RelativeLayout is a view group that displays child views in relative positions. The position of each view can be specified as relative to sibling elements (such as to the left-of or below another view) or in positions relative to the parent RelativeLayout area (such as aligned to the bottom, left or center).",
            "Card View. A card is a sheet of material that serves as an entry point to more detailed information. Cards may contain a photo, text, and a link about a single subject. They may display content containing elements of varying size, such as photos with captions of variable length.",
            "A view group that allows the view hierarchy placed within it to be scrolled. ... To add multiple views within the scroll view, make the direct child you add a view group, for example LinearLayout , and place additional views within that LinearLayout. Scroll view supports vertical scrolling only.",
            "GridView layout in one of the most useful layouts in android. Gridview is mainly useful when we want show data in grid layout like displaying images or icons. This layout can be used to build applications like image viewer, audio or video players in order to show elements in grid manner."
    };

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

        for(int i=0;i<name.length;i++){
            Model model = new Model(name[i], description[i]);
            mArrayList.add(model);
        }


        mAdapter = new MyAdapter(this ,mArrayList);
        mRecyclerView.setAdapter(mAdapter);
    }



}
