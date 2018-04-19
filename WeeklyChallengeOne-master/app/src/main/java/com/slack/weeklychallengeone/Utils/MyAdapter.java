package com.slack.weeklychallengeone.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.slack.weeklychallengeone.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Model> mArrayList;


    public MyAdapter(Context context, ArrayList<Model> mArrayList) {
        this.mContext = context;
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
        switch (position) {
            case 0:
                holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.cardColor1));
                break;
            case 1:
                holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.cardColor2));
                break;
            case 2:
                holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.cardColor3));
                break;
            case 3:
                holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.cardColor4));
                break;
            case 4:
                holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.cardColor5));
                break;
            case 5:
                holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.cardColor6));
                break;
            default:
                holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.cardColorDefault));
                break;
        }
        holder.layoutTitle.setText(mArrayList.get(position).getName());
        holder.layoutDesciption.setText(mArrayList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private TextView layoutTitle;
        private TextView layoutDesciption;

        MyViewHolder(View view) {
            super(view);
            cardView = view.findViewById(R.id.card_view);
            layoutTitle = view.findViewById(R.id.tv_layout_title);
            layoutDesciption = view.findViewById(R.id.tv_layout_description);
        }
    }
}
