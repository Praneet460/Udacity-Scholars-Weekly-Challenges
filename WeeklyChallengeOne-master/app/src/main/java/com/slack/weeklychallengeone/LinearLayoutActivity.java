package com.slack.weeklychallengeone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class LinearLayoutActivity extends AppCompatActivity {

    Animation animation;
    TextView t1, t2, t3, t4, t5, t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
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
                LinearLayoutActivity.super.onBackPressed();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        animateContent(t1,R.id.hori_item_one);
        animateContent(t2,R.id.hori_item_two);
        animateContent(t3,R.id.hori_item_three);
        animateContent(t4,R.id.veri_item_one);
        animateContent(t5,R.id.veri_item_two);
        animateContent(t6,R.id.veri_item_three);

    }
}
