package com.example.android.tourguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Belal on 10/18/2017.
 */


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private ArrayList<items> itemList;

    private  int mFrag_number;

    //getting the context and product list with constructor
    public ProductAdapter(Context mCtx, ArrayList<items> itemList, int frag_number) {
        this.mCtx = mCtx;
        this.itemList = itemList;
        this.mFrag_number = frag_number;
    }

    @Override
//    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        //inflating and returning our view holder
//        LayoutInflater inflater = LayoutInflater.from(mCtx);
//        View view = inflater.inflate(R.layout.grid_design, null);
//        return new ProductViewHolder(view);
//    }
    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int position){

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_design, viewGroup, false);
        ProductViewHolder pvh = new ProductViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        items item = itemList.get(position);
        //binding the data with the viewholder views
        holder.textViewName.setText(item.getmPlaceName());
        holder.textViewRating.setText(item.getmRating());
        holder.textViewTime.setText(item.getmTime());
        holder.textViewAddress.setText(item.getmAddressId());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(item.getmImageResourceId()));
        //item click
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick)
                    Toast.makeText(mCtx,"Long Clcik: "+itemList.get(position),Toast.LENGTH_SHORT).show();
            else if(mFrag_number == 1){
                    Intent intent = new Intent(mCtx, ItemDescription.class);
                    //creating bundle to send the position in the array
                    Bundle b = new Bundle();
                    b.putInt("key",position);
                    intent.putExtras(b);
                    //creating bundle to send the activity name/number
                    Bundle activity = new Bundle();
                    activity.putInt("activity_number",1);
                    intent.putExtras(activity);
                    //start the activity playMusic
                    mCtx.startActivity(intent);
                }
                else if (mFrag_number ==2){
                    Intent intent = new Intent(mCtx, ItemDescription.class);
                    //creating bundle to send the position in the array
                    Bundle b = new Bundle();
                    b.putInt("key",position);
                    intent.putExtras(b);
                    //creating bundle to send the activity name/number
                    Bundle activity = new Bundle();
                    activity.putInt("activity_number",2);
                    intent.putExtras(activity);
                    //start the activity playMusic
                    mCtx.startActivity(intent);
                }
                else{
                    Intent intent = new Intent(mCtx, ItemDescription.class);
                    //creating bundle to send the position in the array
                    Bundle b = new Bundle();
                    b.putInt("key",position);
                    intent.putExtras(b);
                    //creating bundle to send the activity name/number
                    Bundle activity = new Bundle();
                    activity.putInt("activity_number",3);
                    intent.putExtras(activity);
                    //start the activity playMusic
                    mCtx.startActivity(intent);
                }
            }
        });
  }


    @Override
    public int getItemCount() {
        return itemList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

        public TextView textViewName, textViewRating, textViewTime, textViewAddress;
        public ImageView imageView;
        private ItemClickListener itemClickListener;
        public ProductViewHolder(View itemView) {

            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.name);
            textViewRating = (TextView)itemView.findViewById(R.id.rating);
            textViewTime = (TextView)itemView.findViewById(R.id.time);
            textViewAddress =(TextView) itemView.findViewById(R.id.address);
            imageView = (ImageView) itemView.findViewById(R.id.image);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),true);
            return true;
        }

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}