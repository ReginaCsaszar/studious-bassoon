package com.example.khadr.randomcats;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity {

    private ImageView imgw;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.more);
        imgw = findViewById(R.id.cimage);

        Glide.with(getApplicationContext()).load("http://thecatapi.com/api/images/get?type=jpg").into(imgw);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(getApplicationContext()).load("http://thecatapi.com/api/images/get?type=jpg").into(imgw);
            }
        });
    }

}
