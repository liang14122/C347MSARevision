package com.example.a16004118.c347msarevision.Activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a16004118.c347msarevision.R;

import java.util.Objects;

public class ScrollViewActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        Objects.requireNonNull(getSupportActionBar()).setTitle("ScrollView");
    }
}
