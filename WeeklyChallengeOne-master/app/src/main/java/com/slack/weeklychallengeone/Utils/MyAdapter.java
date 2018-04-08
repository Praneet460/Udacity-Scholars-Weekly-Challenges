package com.slack.weeklychallengeone.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import com.slack.weeklychallengeone.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Model> mArrayList;
    private ItemClickListener mItemClickListener;
    private Context mContext;

    public MyAdapter(Context context, ArrayList<Model> mArrayList, ItemClickListener itemClickListener) {
        this.mArrayList = mArrayList;
        mItemClickListener = itemClickListener;
        mContext = context;
    }

    public interface ItemClickListener{
        void onItemClick(View view, View buttonView);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(mArrayList.get(position).getName());
        holder.tv_detail.setText(mArrayList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv_name;
        private TextView tv_detail;
        private ImageButton mImageButton;
        MyViewHolder(View view) {
            super(view);
            mImageButton = view.findViewById(R.id.imageButton);
            tv_name = view.findViewById(R.id.tv_name);
            tv_detail = view.findViewById(R.id.tv_detail);
            mImageButton.setOnClickListener(this);
            tv_name.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            mItemClickListener.onItemClick(tv_detail, mImageButton);
        }
    }
}
