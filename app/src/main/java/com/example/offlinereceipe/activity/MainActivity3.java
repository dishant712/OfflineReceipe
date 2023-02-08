package com.example.offlinereceipe.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import com.example.offlinereceipe.R;
import com.example.offlinereceipe.adapter.DataBaseHelper;
import com.example.offlinereceipe.adapter.adapter3;
import com.example.offlinereceipe.config;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    ImageView imageView;
    int posi,posi1,a,b;
    ListView listView;
    ArrayList nutrition_name,daily_values,nutrition_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        imageView=findViewById(R.id.image3);
        listView=findViewById(R.id.list3);

        ActivityCompat.requestPermissions(MainActivity3.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);

        posi1=getIntent().getIntExtra("posi1",0);

        imageView.setImageResource(config.category_image[posi1]);



//        if (a==1)
//        {
//            imageView.setImageResource(config.category_image[posi]);
//        }
//        else
//        {
//
//        }




    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {


                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    DataBaseHelper mydb = new DataBaseHelper(this);
                    Cursor c = mydb.getnutrition();

                    nutrition_name= new ArrayList();
                    daily_values=new ArrayList();
                    nutrition_id=new ArrayList();

                    while (c.moveToNext())
                    {
                        nutrition_id.add(c.getInt(0));
                        nutrition_name.add(c.getString(1));
                        daily_values.add(c.getInt(2));
                        System.out.println(c.getInt(2));
                    }
                    adapter3 adapter = new adapter3(this,nutrition_id,nutrition_name,daily_values);
                    listView.setAdapter(adapter);
                } else {


                    Toast.makeText(MainActivity3.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

        }
    }
}