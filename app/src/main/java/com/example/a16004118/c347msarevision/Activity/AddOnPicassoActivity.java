package com.example.a16004118.c347msarevision.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a16004118.c347msarevision.R;
import com.jsibbold.zoomage.ZoomageView;
import com.squareup.picasso.Picasso;

public class AddOnPicassoActivity extends AppCompatActivity {

    ZoomageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_on_picasso);

        iv = findViewById(R.id.ivAddOn);
//        iv.setImageResource(R.mipmap.ic_launcher);

        String imageUrl = "http://square.github.io/picasso/static/sample.png";
        Picasso.get().load(imageUrl).into(iv);
    }
}
