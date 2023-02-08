package com.example.offlinereceipe.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.offlinereceipe.R;
import com.example.offlinereceipe.activity.MainActivity;
import com.example.offlinereceipe.activity.MainActivity1;
import com.example.offlinereceipe.config;


public class recycleadapter1 extends RecyclerView.Adapter<recycleadapter1.myclass> {
    MainActivity mainActivity;

    public recycleadapter1(MainActivity mainActivity) {
        this.mainActivity=mainActivity;

    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mainActivity).inflate(R.layout.view1_item,parent,false);
        myclass m =  new myclass(view);
        return m;
    }


    class myclass extends RecyclerView.ViewHolder {
        ImageView linearLayout;
        TextView textView;

        public myclass(@NonNull View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.view_item_img);
            textView=itemView.findViewById(R.id.view_item_txt);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull myclass holder, @SuppressLint("RecyclerView") int position) {
        holder.linearLayout.setImageResource(config.category_image[position]);
        holder.textView.setText(config.category_name[position]);

                holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(mainActivity, MainActivity1.class);
                        intent.putExtra("pos",position);
                        int a=1;
                        intent.putExtra("a",a);
                        mainActivity.startActivity(intent);
                    }
                });

    }

    @Override
    public int getItemCount() {
        return config.category_image.length;
    }
}
