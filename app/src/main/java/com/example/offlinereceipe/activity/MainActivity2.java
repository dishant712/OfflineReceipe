package com.example.offlinereceipe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.offlinereceipe.R;
import com.example.offlinereceipe.config;


public class MainActivity2 extends AppCompatActivity {

    ImageView imageView;
    int pos,pos1,a,b;
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView=findViewById(R.id.image2);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);

        pos=getIntent().getIntExtra("pos",0);
        pos1=getIntent().getIntExtra("pos1",0);
        a=getIntent().getIntExtra("a",0);
        b=getIntent().getIntExtra("b",0);


            imageView.setImageResource(config.category_image[pos1]);

//        else if(b==1)
//        {
//            imageView.setImageResource(config.allrecie[pos1]);
//        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                intent.putExtra("posi1",pos1);

                startActivity(intent);
            }
        });

    }
}