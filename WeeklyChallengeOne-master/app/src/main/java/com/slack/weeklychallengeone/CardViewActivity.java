package com.slack.weeklychallengeone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class CardViewActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        linearLayout = findViewById(R.id.content_card);
        linearLayout.setVisibility(View.VISIBLE);
        animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        animation.setDuration(2000);
        linearLayout.startAnimation(animation);

     }

    @Override
    public void onBackPressed() {
        linearLayout = findViewById(R.id.content_card);
        linearLayout.setVisibility(View.VISIBLE);
        animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        linearLayout.startAnimation(animation);
        linearLayout.setVisibility(View.INVISIBLE);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                CardViewActivity.super.onBackPressed();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
