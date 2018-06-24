package com.example.a16004118.c347msarevision.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a16004118.c347msarevision.R;

public class ImplicitIntentActivity extends AppCompatActivity {

    private Button btnSendEmail, btnStartInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        btnSendEmail = findViewById(R.id.btnSendEmail);
        btnStartInternet = findViewById(R.id.btnStartInternet);

        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);

                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"yaoliang0112@gmail.com"});
                i.putExtra(Intent.EXTRA_TEXT, "Email Content");
                i.putExtra(Intent.EXTRA_SUBJECT, "Email Subject");
                i.setType("message/rfc822");

                startActivity(Intent.createChooser(i, "Choose a email client: "));
            }
        });

        btnStartInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);

                i.setData(Uri.parse("http://www.google.com"));

                startActivity(i);
            }
        });
    }
}
