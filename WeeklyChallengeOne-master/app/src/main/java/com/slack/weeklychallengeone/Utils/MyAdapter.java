package com.slack.weeklychallengeone.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.slack.weeklychallengeone.CardActivity;
import com.slack.weeklychallengeone.GridActivity;
import com.slack.weeklychallengeone.InfoActivity;
import com.slack.weeklychallengeone.LinearActivity;
import com.slack.weeklychallengeone.MainActivity;
import com.slack.weeklychallengeone.R;
import com.slack.weeklychallengeone.RelativeActivity;
import com.slack.weeklychallengeone.ScrollActivity;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Model> mArrayList;


    public MyAdapter(ArrayList<Model> mArrayList) {
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
        holder.tv_name.setText(mArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final Context context;
        private TextView tv_name;
        public MyViewHolder(View view) {
            super(view);

            tv_name = (TextView) view.findViewById(R.id.tv_name);
            view.setOnClickListener(this);
            context=view.getContext();
        }

        @Override
        public void onClick(View v) {
            Intent i;
            switch (getAdapterPosition())
            {
                case 0: {

                    i = new Intent(context,InfoActivity.class);
                    break;
                }
                case 1:
                {
                    i = new Intent(context,LinearActivity.class);
                    break;
                }
                case 2:
                {
                    i = new Intent(context, RelativeActivity.class);
                    break;
                }
                case 3:
                {
                    i = new Intent(context,CardActivity.class);
                    break;
                }
                case 4:
                {
                    i = new Intent(context, ScrollActivity.class);
                    break;
                }
                case 5:
                {
                    i = new Intent(context,GridActivity.class);
                    break;
                }
                default:{
                    i=new Intent(context,MainActivity.class);
                }
            }



            context.startActivity(i);
        }
    }


}
