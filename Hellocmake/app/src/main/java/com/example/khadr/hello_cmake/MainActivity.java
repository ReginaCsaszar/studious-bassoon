package com.example.khadr.hello_cmake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    private ImageSwitcher sw;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.more);
        sw = findViewById(R.id.catImage);

        sw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imgw = new ImageView(getApplicationContext());
                imgw.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imgw;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context c = getApplicationContext();
                int id = c.getResources().getIdentifier(stringFromJNI(), null, c.getPackageName());
                sw.setImageResource(id);
            }
        });
    }

    public native String stringFromJNI();
}