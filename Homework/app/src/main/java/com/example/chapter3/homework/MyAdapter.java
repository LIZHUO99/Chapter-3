package com.example.chapter3.homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder>{

    private int mItemNumber;


    public MyAdapter(int itemNumber){
        mItemNumber = itemNumber;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_list, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int position) {
        itemViewHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mItemNumber;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        private final TextView index;

        public ItemViewHolder(@NonNull View itemView){
            super(itemView);
            index = (TextView) itemView.findViewById(R.id.item_index);
        }

        public void bind(int position){
            index.setText("ITEM" + String.valueOf(position));

        }
    }
}
