package com.example.a16004118.c347msarevision.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a16004118.c347msarevision.R;

public class ExplicitIntentActivity extends AppCompatActivity {

    private TextView tvReturnCode;
    private Button btnCode1, btnCode2;
    private int code1 = 0001;
    private int code2 = 0002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        tvReturnCode = findViewById(R.id.tvReturnCode);
        btnCode1 = findViewById(R.id.btnCode1);
        btnCode2 = findViewById(R.id.btnCode2);

        btnCode1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ExplicitIntentActivity.this, ExplicitIntentActivity2.class);
                i.putExtra("code", code1);
                startActivityForResult(i, code1);

            }
        });

        btnCode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ExplicitIntentActivity.this, ExplicitIntentActivity2.class);
                i.putExtra("code", code2);
                startActivityForResult(i, code2);

            }
        });

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (data != null) {
                String returnCode = data.getStringExtra("returnCode");

                tvReturnCode.setText("Request Code: " + requestCode + "\n"
                            + "Return Code: " + returnCode);
            }
        }
    }
}
