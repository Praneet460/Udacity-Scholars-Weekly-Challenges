package com.slack.weeklychallengeone.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.slack.weeklychallengeone.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Model> mArrayList;
    private Context context;

    public MyAdapter(ArrayList<Model> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        context = parent.getContext();
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_item_name.setText(mArrayList.get(position).getItemName());
        holder.tv_item_extends.setText(mArrayList.get(position).getItemExtends());
        holder.tv_item_description.setText(mArrayList.get(position).getItemDescription());

        Log.d("MyAdapter", "position: " + position);

        switch (position) {
            case 0:
                holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.colorCard_1));
                break;
            case 1:
                holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.colorCard_2));
                break;
            case 2:
                holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.colorCard_3));
                break;
            case 3:
                holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.colorCard_4));
                break;
            case 4:
                holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.colorCard_5));
                break;
            case 5:
                holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.colorCard_6));
        }
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_item_name, tv_item_extends, tv_item_description;
        private CardView cardView;
        private LinearLayout linearLayout;

        MyViewHolder(View view) {
            super(view);
            tv_item_name = view.findViewById(R.id.tv_itemName);
            tv_item_extends = view.findViewById(R.id.tv_itemExtends);
            tv_item_description = view.findViewById(R.id.tv_itemDescription);
            cardView = view.findViewById(R.id.card_view);
            linearLayout = view.findViewById(R.id.contentLayout);
        }
    }
}
