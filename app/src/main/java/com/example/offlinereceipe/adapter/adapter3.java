package com.example.offlinereceipe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.offlinereceipe.R;
import com.example.offlinereceipe.activity.MainActivity3;

import java.util.ArrayList;

public class adapter3 extends BaseAdapter {
    MainActivity3 mainActivity3;
    ArrayList nutrition_id,nutrition_name, daily_values;
    public adapter3(MainActivity3 mainActivity3, ArrayList nutrition_id, ArrayList nutrition_name, ArrayList daily_values) {
        this.mainActivity3=mainActivity3;
        this.nutrition_id=nutrition_id;
        this.nutrition_name=nutrition_name;
        this.daily_values=daily_values;

    }

    @Override
    public int getCount() {
        return nutrition_id.size();
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
        view= LayoutInflater.from(mainActivity3).inflate(R.layout.adpater3_file,viewGroup,false);
        TextView textView =view.findViewById(R.id.text11);
        TextView textView1 =view.findViewById(R.id.text12);
        TextView textView2 =view.findViewById(R.id.text13);


            textView.setText(nutrition_id.get(i).toString());
            textView1.setText(nutrition_name.get(i).toString());
            if(!daily_values.get(i).toString().equals("0"))
            {
                textView2.setText(daily_values.get(i).toString());
            }

        return view;
    }
}
