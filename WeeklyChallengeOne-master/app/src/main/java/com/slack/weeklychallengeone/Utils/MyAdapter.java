package com.slack.weeklychallengeone.Utils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.slack.weeklychallengeone.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private static int FADE_ANIMATION = 1000;

    private ArrayList<Model> mArrayList;


    public MyAdapter(ArrayList<Model> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(mArrayList.get(position).getName());
        animateItem(holder.tv_name);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    private void animateItem(View view){
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.2f);
        alphaAnimation.setDuration(FADE_ANIMATION);
        view.startAnimation(alphaAnimation);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;


        MyViewHolder(View view) {
            super(view);
            tv_name = view.findViewById(R.id.tv_name);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.startAnimation(AnimationUtils.loadAnimation(view.getContext(),R.anim.bingbong));
                }
            });

        }
    }


}
