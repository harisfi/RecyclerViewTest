package com.example.recyclerviewtest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class RLAdapter extends RecyclerView.Adapter<RLHolder> {
    Context context;
    ArrayList<Model> models;

    public RLAdapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public RLHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);
        return new RLHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RLHolder holder, final int position) {
        holder.textView.setText(models.get(position).getJudul());
        holder.textView2.setText(models.get(position).getDesc());
        holder.imageView.setImageResource(models.get(position).getPict());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View view, int postition) {
                String gJudul = models.get(position).getJudul();
                String gDesc = models.get(position).getDesc();  //get data from prev. activity
                BitmapDrawable bitmapDrawable = (BitmapDrawable) holder.imageView.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] bytes = stream.toByteArray();

                Intent intent = new Intent(context, Activity2.class);
                intent.putExtra("iJudul", gJudul);
                intent.putExtra("iDesc", gDesc);
                intent.putExtra("iImg", bytes);
                context.startActivity(intent);
            }
        });

        /*holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View view, int postition) {
                if (models.get(position).getJudul().equals("Judul list")){

                }
                if (models.get(position).getJudul().equals("Judul list0")){

                }
                if (models.get(position).getJudul().equals("Judul list1")){

                }
                if (models.get(position).getJudul().equals("Judul list2")){

                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
