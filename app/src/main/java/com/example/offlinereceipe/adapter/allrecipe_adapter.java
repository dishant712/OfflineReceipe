
package com.example.offlinereceipe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.offlinereceipe.R;
import com.example.offlinereceipe.activity.MainActivity1;
import com.example.offlinereceipe.activity.allrecipe;
import com.example.offlinereceipe.config;


public class allrecipe_adapter extends BaseAdapter {

    allrecipe allrecipe;

    public allrecipe_adapter(allrecipe allrecipe) {

        this.allrecipe=allrecipe;
    }

    @Override
    public int getCount() {
        return config.category_name.length;
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
        view= LayoutInflater.from(allrecipe).inflate(R.layout.allrecipe_item,viewGroup,false);

        ImageView imageView=view.findViewById(R.id.view_item_img);
        TextView textView=view.findViewById(R.id.view_item_txt);

        imageView.setImageResource(config.category_image[i]);
        textView.setText(config.category_name[i]);

        return view;
    }
}
