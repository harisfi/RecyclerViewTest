package com.example.recyclerviewtest;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RLHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    ImageView imageView;
    TextView textView, textView2;
    ItemClickListener itemClickListener;

    RLHolder(@NonNull View itemView) {
        super(itemView);

        this.imageView = itemView.findViewById(R.id.imageV);
        this.textView = itemView.findViewById(R.id.titleV);
        this.textView2 = itemView.findViewById(R.id.desc);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClickListener(view, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
}
