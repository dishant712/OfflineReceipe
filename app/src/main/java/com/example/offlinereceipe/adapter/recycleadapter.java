package com.example.offlinereceipe.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.offlinereceipe.R;
import com.example.offlinereceipe.activity.MainActivity;
import com.example.offlinereceipe.config;


public class recycleadapter extends RecyclerView.Adapter<recycleadapter.myclass> {
    MainActivity mainActivity;

    public recycleadapter(MainActivity mainActivity) {
        this.mainActivity=mainActivity;

    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mainActivity).inflate(R.layout.fitness_item,parent,false);
        myclass m =  new myclass(view);
        return m;
    }


    class myclass extends RecyclerView.ViewHolder {
        ImageView linearLayout;
        public myclass(@NonNull View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.view_item_img);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull myclass holder, @SuppressLint("RecyclerView") int position) {
        holder.linearLayout.setImageResource(config.fitness[position]);

                holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

//                            Intent intent = new Intent(mainActivity,MainActivity4.class);
//                            intent.putExtra("pos", position);
//                            mainActivity.startActivity(intent);

                    }
                });

    }


    @Override
    public int getItemCount() {
        return config.fitness.length;
    }
}
