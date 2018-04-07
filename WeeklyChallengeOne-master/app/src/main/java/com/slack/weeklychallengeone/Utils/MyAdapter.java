package com.slack.weeklychallengeone.Utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.slack.weeklychallengeone.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Model> mArrayList;
    private Context context;
    private int lastPosition = 1;

    public MyAdapter(Context context, ArrayList<Model> mArrayList) {
        this.context = context;
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(mArrayList.get(position).getName());
        switch (mArrayList.get(position).getNumber()) {
            case 1:
                holder.cardView.setBackgroundColor(context.getResources().getColor(R.color.red_200));
                break;
            case 2:
                holder.cardView.setBackgroundColor(context.getResources().getColor(R.color.deep_purple_200));
                break;
            case 3:
                holder.cardView.setBackgroundColor(context.getResources().getColor(R.color.light_blue_200));
                break;
            case 4:
                holder.cardView.setBackgroundColor(context.getResources().getColor(R.color.green_200));
                break;
            case 5:
                holder.cardView.setBackgroundColor(context.getResources().getColor(R.color.cyan_200));
                break;
            case 6:
                holder.cardView.setBackgroundColor(context.getResources().getColor(R.color.orange_200));
                break;
            default:
                break;
        }

        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.up_from_bottom);
            holder.cardView.startAnimation(animation);
            lastPosition = position;
        }

    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private CardView cardView;
        private LottieAnimationView mAnimViewLove, mAnimViewSave;

        MyViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.tv_name);
            cardView = view.findViewById(R.id.cv_layout);
            mAnimViewLove = itemView.findViewById(R.id.anim_view_love);
            mAnimViewSave = itemView.findViewById(R.id.anim_view_save);

            mAnimViewLove.setOnClickListener(v-> startCheckAnim(mAnimViewLove));
            mAnimViewSave.setOnClickListener(v-> startCheckAnim(mAnimViewSave));
        }

        private void startCheckAnim(LottieAnimationView view) {
            ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f).setDuration(1000);
            animator.addUpdateListener(valueAnimator -> view.setProgress((Float) valueAnimator.getAnimatedValue()));
            if (view.getProgress() == 0f) {
                animator.start();
            } else {
                view.setProgress(0f);
            }
        }
    }


}
