package com.slack.weeklychallengeone.Utils;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.slack.weeklychallengeone.R;
import com.slack.weeklychallengeone.data.LayoutContract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Cursor result;
    private ListClickListener clickListener;
    public interface ListClickListener{
        public void onClick(Model m,View v);
    }

    public MyAdapter(Cursor c,ListClickListener clickListener) {
        result = c;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        view.setOnClickListener(viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(!result.moveToPosition(position))
            return;
        holder.tv_name.setText(result.getString(result.getColumnIndex(LayoutContract.LayoutEntry.COLUMN_NAME)));
    }

    @Override
    public int getItemCount() {return result.getCount();}



    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv_name;
        private View view;
        MyViewHolder(View view) {
            super(view);
            this.view = view;
            tv_name = (TextView) view.findViewById(R.id.tv_name);
        }

        @Override
        public void onClick(View view) {
            if(!result.moveToPosition(getAdapterPosition()))
                return;
            clickListener.onClick(new Model(
                    result.getString(result.getColumnIndex(LayoutContract.LayoutEntry.COLUMN_NAME)),
                    result.getString(result.getColumnIndex(LayoutContract.LayoutEntry.COLUMN_LINK))),
                    view);
        }

    }



}
