package com.example.offlinereceipe.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.offlinereceipe.R;
import com.example.offlinereceipe.adapter.adapter;
import com.example.offlinereceipe.adapter.recycleadapter;
import com.example.offlinereceipe.adapter.recycleadapter1;
import com.example.offlinereceipe.config;

import java.io.File;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    Gallery view3;
    ActionBar actionBar;
    int r;
    int min=1;
    int max=35;
    RecyclerView recyclerView,view1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");



        searchView=findViewById(R.id.search);
        view1=findViewById(R.id.view1);
        view3=findViewById(R.id.view3);
        recyclerView=findViewById(R.id.view2);

        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);

//        Random r = new Random();
//        int ran = r.nextInt(max - min + 1) + min;
//        System.out.println("Random+"+ran);




        recycleadapter1  recycleadapter1 = new recycleadapter1(this);
        view1.setAdapter(recycleadapter1);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        view1.setLayoutManager(linearLayoutManager);


        recycleadapter adapter1 = new recycleadapter(this);
        recyclerView.setAdapter(adapter1);

        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager1);



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);

        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            //noinspection RestrictedApi
            m.setOptionalIconsVisible(true);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {

        case R.id.allreceipe:
        Intent intent = new Intent(MainActivity.this,allrecipe.class);
        this.startActivity(intent);
        break;

        case R.id.share:
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            String shareSubText = "WhatsApp - The Great Chat App";
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubText);
            startActivity(Intent.createChooser(shareIntent, "Share"));
            break;


            default:
        return super.onOptionsItemSelected(item);
        }


        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    config.file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)+"/recipel");
                    if (config.file.exists())
                    {

                    }
                    else
                    {
                        config.file.mkdir();
                    }
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            1);
                    Toast.makeText(MainActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}