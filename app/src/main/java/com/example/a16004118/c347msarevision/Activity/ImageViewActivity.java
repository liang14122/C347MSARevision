package com.example.a16004118.c347msarevision.Activity;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.a16004118.c347msarevision.R;
import com.squareup.picasso.Picasso;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView ivLocal, ivURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        ivLocal = findViewById(R.id.ivLocal);
        ivURL = findViewById(R.id.ivURL);

        ivLocal.setImageResource(R.drawable.ic_launcher_background);

        Picasso.get().load("https://image.ibb.co/kdYJNy/Millet_Porridge.jpg")
                .error(android.R.drawable.stat_notify_error)
                .into(ivURL);

    }
}
