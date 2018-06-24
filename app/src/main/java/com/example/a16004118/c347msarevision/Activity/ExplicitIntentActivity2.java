package com.example.a16004118.c347msarevision.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a16004118.c347msarevision.R;

public class ExplicitIntentActivity2 extends AppCompatActivity {

    private TextView tvRequestCode;
    private Button btnCode1, btnCode2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent2);

        tvRequestCode = findViewById(R.id.tvRequestCode);
        btnCode1 = findViewById(R.id.btnCode1);
        btnCode2 = findViewById(R.id.btnCode2);

        Intent i = getIntent();
        tvRequestCode.setText("Request Code: " + i.getIntExtra("code", -1));

        btnCode1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.putExtra("returnCode", "A");
                setResult(RESULT_OK, i);
                finish();

            }
        });

        btnCode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.putExtra("returnCode", "B");
                setResult(RESULT_OK, i);
                finish();

            }
        });

    }
}
