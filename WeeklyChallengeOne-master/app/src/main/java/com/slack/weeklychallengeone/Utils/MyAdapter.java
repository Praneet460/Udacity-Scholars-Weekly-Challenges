package com.slack.weeklychallengeone.Utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.slack.weeklychallengeone.R;

import java.util.ArrayList;
import java.util.Random;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Model> mArrayList;
    Context context;


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
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.tv_description.setVisibility(View.GONE);
        holder.tv_share.setVisibility(View.GONE);
        holder.tv_link.setVisibility(View.GONE);
        holder.tv_name.setText(mArrayList.get(position).getName());
        holder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.tv_name.setVisibility(View.VISIBLE);
                holder.tv_description.setText(mArrayList.get(position).getDescription());
                holder.tv_description.setVisibility(View.VISIBLE);
                holder.tv_share.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.v("Details", mArrayList.get(position).getName() );
                        shareItem(mArrayList.get(position).getName(), mArrayList.get(position).getDescription());
                    }
                });
                holder.tv_share.setVisibility(View.VISIBLE);

                holder.tv_link.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.v("Details", mArrayList.get(position).getLinks() );
                        openLink(mArrayList.get(position).getLinks());
                    }
                });
                holder.tv_link.setVisibility(View.VISIBLE);
            }
        });

        holder.tv_description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.tv_description.setVisibility(View.GONE);
                holder.tv_share.setVisibility(View.GONE);
                holder.tv_link.setVisibility(View.GONE);
                holder.tv_name.setVisibility(View.VISIBLE);
            }
        });

        Random rnd = new Random();
        if(position == 0){
            holder.tv_card.setCardBackgroundColor(context.getResources().getColor(R.color.teallight));
        } else if(position == 1){
            holder.tv_card.setCardBackgroundColor(context.getResources().getColor(R.color.teallight));
        } else if(position == 2){
            holder.tv_card.setCardBackgroundColor(context.getResources().getColor(R.color.teallight));
        } else if(position == 3){
            holder.tv_card.setCardBackgroundColor(context.getResources().getColor(R.color.teallight));
        } else if (position == 4){
            holder.tv_card.setCardBackgroundColor(context.getResources().getColor(R.color.teallight));
        } else if(position == 5) {
            holder.tv_card.setCardBackgroundColor(context.getResources().getColor(R.color.teallight));
        }

       /* Random rnd = new Random();
        //Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        switch(position){
            case 0:
                holder.tv_card.setCardBackgroundColor(Color.argb(255, rnd.nextInt(50), rnd.nextInt(50), rnd.nextInt(50)));
                holder.tv_card.setRadius(10);
            case 1:
                holder.tv_card.setBackgroundColor(Color.argb(255, rnd.nextInt(50), rnd.nextInt(50), rnd.nextInt(50)));
                holder.tv_card.setRadius(10);
            case 2:
                holder.tv_card.setBackgroundColor(Color.argb(255, rnd.nextInt(50), rnd.nextInt(150), rnd.nextInt(150)));
                holder.tv_card.setRadius(10);
            case 3:
                holder.tv_card.setBackgroundColor(Color.argb(255, rnd.nextInt(50), rnd.nextInt(150), rnd.nextInt(150)));
                holder.tv_card.setRadius(10);
            case 4:
                holder.tv_card.setBackgroundColor(Color.argb(255, rnd.nextInt(50), rnd.nextInt(150), rnd.nextInt(150)));
                holder.tv_card.setRadius(10);
            case 5:
                holder.tv_card.setBackgroundColor(Color.argb(255, rnd.nextInt(50), rnd.nextInt(150), rnd.nextInt(150)));
                holder.tv_card.setRadius(10);
        }*/


    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name;
        private TextView tv_description;
        private ImageButton tv_share;
        private ImageButton tv_link;
        private CardView tv_card;
        MyViewHolder(View view) {
            super(view);

            tv_name = view.findViewById(R.id.tv_name);
            tv_description= view.findViewById(R.id.description);
            tv_share = view.findViewById(R.id.share);
            tv_card = view.findViewById(R.id.card_view);
            tv_link = view.findViewById(R.id.link);

        }
    }

    public void shareItem(String name, String description) {

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, description);
        context.startActivity(i);

    }

    public void openLink(String links){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(links));
        context.startActivity(browserIntent);
    }

}
