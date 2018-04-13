package com.slack.weeklychallengeone.Utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.slack.weeklychallengeone.R;
import com.slack.weeklychallengeone.helper.FlipAnimator;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Model> mArrayList;
    private MyAdapterListener listener;
    private SparseBooleanArray selectedItems;

    private SparseBooleanArray animationItemsIndex;

    private static int currentSelectedIndex = -1;


    public MyAdapter(Context context, ArrayList<Model> mArrayList, MyAdapterListener listener) {
        mContext = context;
        this.mArrayList = mArrayList;
        this.listener = listener;
        selectedItems = new SparseBooleanArray();
        animationItemsIndex = new SparseBooleanArray();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        Model model = mArrayList.get(position);
        holder.tv_name.setText(model.getName());
        holder.tv_title.setText(model.getName());
        holder.description.setText(model.getDescription());

        holder.more_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(mArrayList.get(holder.getAdapterPosition()).getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                if(intent.resolveActivity(mContext.getPackageManager()) != null) {
                    mContext.startActivity(intent);
                }
            }
        });

        holder.bookmark_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onIconBookmarkClicked(holder.getAdapterPosition());
                v.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
            }
        });

        applyImportant(holder, model);

        applyIconAnimation(holder, position);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    private void applyImportant(MyViewHolder holder, Model model) {
        if(model.isImportant()) {
            holder.bookmark_image.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_bookmark));
            //holder.iconImageView.setColorFilter(ContextCompat.getColor(mContext, R.color.icon_tint_selected));
        } else {
            holder.bookmark_image.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_bookmark_border));
            //holder.iconImageView.setColorFilter(ContextCompat.getColor(mContext, R.color.icon_tint_normal));
        }
    }

    private void applyIconAnimation(MyViewHolder holder, int position) {
        if(selectedItems.get(position, false)) {
            holder.mFrontView.setVisibility(View.GONE);
            resetIconYAxis(holder.mBackView);
            holder.mBackView.setVisibility(View.VISIBLE);
            holder.mBackView.setAlpha(1);
            if(currentSelectedIndex == position) {
                FlipAnimator.flipView(mContext, holder.mBackView, holder.mFrontView, true);
                resetCurrentIndex();
            }
        } else {
            holder.mBackView.setVisibility(View.GONE);
            resetIconYAxis(holder.mFrontView);
            holder.mFrontView.setVisibility(View.VISIBLE);
            holder.mFrontView.setAlpha(1);
            if(animationItemsIndex.get(position, false) || currentSelectedIndex == position ){
            FlipAnimator.flipView(mContext, holder.mBackView, holder.mFrontView, false);
                resetCurrentIndex();
            }
        }

    }

    public void toggleSelection(int pos) {
        currentSelectedIndex = pos;
        if(selectedItems.get(pos, false)) {
            selectedItems.delete(pos);
            animationItemsIndex.delete(pos);
        } else {
            selectedItems.put(pos, true);
            animationItemsIndex.put(pos, true);
        }
        notifyItemChanged(pos);
    }

    private void resetIconYAxis(View view) {
        if(view.getRotationY() != 0) {
            view.setRotationY(0);
        }
    }

    private void resetCurrentIndex() {
        currentSelectedIndex = -1;
    }

    public interface MyAdapterListener {
        void onItemClicked(int position);

        void onIconBookmarkClicked(int position);
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv_name;
        private CardView mFrontView;
        private CardView mBackView;
        private TextView tv_title;
        private TextView description;
        private Button more_button;
        private ImageView bookmark_image;
        MyViewHolder(View view) {
            super(view);

            tv_name = view.findViewById(R.id.tv_name);
            mFrontView = view.findViewById(R.id.front_card_view);
            mBackView = view.findViewById(R.id.back_card_view);
            tv_title = view.findViewById(R.id.view_title);
            description = view.findViewById(R.id.description);
            more_button = view.findViewById(R.id.more);
            bookmark_image = view.findViewById(R.id.bookmark_image);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.onItemClicked(getAdapterPosition());
            v.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        }
    }


}
