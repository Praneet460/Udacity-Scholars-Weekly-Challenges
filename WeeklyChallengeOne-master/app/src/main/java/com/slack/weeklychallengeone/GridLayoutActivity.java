package com.slack.weeklychallengeone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class GridLayoutActivity extends AppCompatActivity {

    Animation animation;
    TextView t1,t2,t3,t4,t5,t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
    }


    private void animateContent(TextView textView, int id) {

        textView = findViewById(id);
        textView.setVisibility(View.VISIBLE);
        animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        textView.startAnimation(animation);
        textView.setVisibility(View.INVISIBLE);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                GridLayoutActivity.super.onBackPressed();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        animateContent(t1,R.id.gl_text_one);
        animateContent(t2,R.id.gl_text_two);
        animateContent(t3,R.id.gl_text_three);
        animateContent(t4,R.id.gl_text_four);
        animateContent(t5,R.id.gl_text_five);
        animateContent(t6,R.id.gl_text_six);

    }
}
