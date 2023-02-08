package com.example.offlinereceipe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.offlinereceipe.R;
import com.example.offlinereceipe.adapter.adapter1;
import com.example.offlinereceipe.adapter.allrecipe_adapter;


public class allrecipe extends AppCompatActivity {

    GridView gridView;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allrecipe);
        setTitle("All Recipe");

        gridView=findViewById(R.id.grid);


        allrecipe_adapter allrecipe_adapter = new allrecipe_adapter(this);
        gridView.setAdapter(allrecipe_adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(allrecipe.this,MainActivity2.class);
                intent.putExtra("pos1",i);
                startActivity(intent);
            }
        });
    }
}