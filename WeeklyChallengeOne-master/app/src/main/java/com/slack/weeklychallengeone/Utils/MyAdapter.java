package com.slack.weeklychallengeone.Utils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.slack.weeklychallengeone.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Model> mArrayList;
    private final ListItemClickListner mListItemClickListner;


    public MyAdapter(ArrayList<Model> mArrayList, ListItemClickListner mListItemClickListner) {
        this.mArrayList = mArrayList;
        this.mListItemClickListner = mListItemClickListner;
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


    //To Handel the click listner
   public  interface ListItemClickListner{
        void ListItemClick(int clickedItemIndex);
    }
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv_name;
        MyViewHolder(View view) {
            super(view);
    
            tv_name = view.findViewById(R.id.tv_name);
            view.setOnClickListener(this);

        }
    
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mListItemClickListner.ListItemClick(position);
        }
    }


}
