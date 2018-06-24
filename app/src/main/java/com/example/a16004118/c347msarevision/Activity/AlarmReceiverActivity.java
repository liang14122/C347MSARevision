package com.example.a16004118.c347msarevision.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a16004118.c347msarevision.R;

import org.w3c.dom.Text;

public class AlarmReceiverActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_receiver);

        tv = findViewById(R.id.tv);

        Intent i = getIntent();

        tv.setText(i.getStringExtra("type"));

    }
}
