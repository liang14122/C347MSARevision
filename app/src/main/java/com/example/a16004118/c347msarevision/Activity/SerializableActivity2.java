package com.example.a16004118.c347msarevision.Activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a16004118.c347msarevision.Object.SerializableItem;
import com.example.a16004118.c347msarevision.R;

public class SerializableActivity2 extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serializable2);

        TextView tv = findViewById(R.id.tv);

        SerializableItem item = (SerializableItem) getIntent().getSerializableExtra("object");
        tv.setText(item.getName() + "\n" + item.getId());
    }
}
