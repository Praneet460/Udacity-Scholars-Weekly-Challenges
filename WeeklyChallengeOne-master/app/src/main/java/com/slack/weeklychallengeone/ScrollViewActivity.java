package com.slack.weeklychallengeone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

public class ScrollViewActivity extends AppCompatActivity {

    android.widget.RelativeLayout relativeLayout;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        relativeLayout = findViewById(R.id.content_sv);
        relativeLayout.setVisibility(View.VISIBLE);
        animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        animation.setDuration(2000);
        relativeLayout.startAnimation(animation);
    }

    @Override
    public void onBackPressed() {
        relativeLayout = findViewById(R.id.content_sv);
        relativeLayout.setVisibility(View.VISIBLE);
        animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        relativeLayout.startAnimation(animation);
        relativeLayout.setVisibility(View.INVISIBLE);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ScrollViewActivity.super.onBackPressed();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
