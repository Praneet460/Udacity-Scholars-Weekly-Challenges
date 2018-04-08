package com.slack.weeklychallengeone.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.slack.weeklychallengeone.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Model> mArrayList;
    Context mContext;


    public MyAdapter(ArrayList<Model> mArrayList, Context context) {
        this.mArrayList = mArrayList;
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        holder.tv_name.removeAllViews();
        switch (position){
            case 0:
                holder.tv_name.addView(inflater.inflate(R.layout.contraint_layout_item, null));
                break;
            case 1:
                holder.tv_name.addView(inflater.inflate(R.layout.linear_layout_item, null));
                break;
            case 2:
                holder.tv_name.addView(inflater.inflate(R.layout.relative_layout_item, null));
                break;
            case 3:
                holder.tv_name.addView(inflater.inflate(R.layout.card_view_item, null));
                break;
            case 4:
                holder.tv_name.addView(inflater.inflate(R.layout.scroll_view_item, null));
                break;
            case 5:
                holder.tv_name.addView(inflater.inflate(R.layout.grid_view_item, null));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout tv_name;
        MyViewHolder(View view) {
            super(view);

            tv_name = view.findViewById(R.id.myIncludes);

        }
    }


}
