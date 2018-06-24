package com.example.a16004118.c347msarevision.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a16004118.c347msarevision.R;

public class ContentProviderActivity extends AppCompatActivity {

    private Button btnRetrieveALLSMS, btnRetrieveSMSWithFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        btnRetrieveALLSMS = findViewById(R.id.btnRetrieveALLSMS);
        btnRetrieveSMSWithFilter = findViewById(R.id.btnRetrieveSMSWithFilter);

        btnRetrieveALLSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnRetrieveALLSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
