package com.example.offlinereceipe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.offlinereceipe.R;
import com.example.offlinereceipe.activity.MainActivity;
import com.example.offlinereceipe.config;


public class adapter extends BaseAdapter{
    MainActivity mainActivity;

    public adapter(MainActivity mainActivity) {

        this.mainActivity=mainActivity;

    }

    @Override
    public int getCount() {
        return config.category_image.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view= LayoutInflater.from(mainActivity).inflate(R.layout.view1_item,viewGroup,false);

        ImageView imageView=view.findViewById(R.id.view_item_img);
        TextView textView=view.findViewById(R.id.view_item_txt);

        imageView.setImageResource(config.category_image[i]);
        textView.setText(config.category_name[i]);
        return view;
    }
}
