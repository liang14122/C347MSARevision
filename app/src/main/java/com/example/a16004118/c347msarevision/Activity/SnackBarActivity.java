package com.example.a16004118.c347msarevision.Activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a16004118.c347msarevision.R;

public class SnackBarActivity extends AppCompatActivity {

    private Button btnLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);

        btnLauncher = findViewById(R.id.btnLauncher);

        btnLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar sb =  Snackbar.make(v, "Yum Yum!!", Snackbar.LENGTH_SHORT);

                sb.setAction("Get a Toast!", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SnackBarActivity.this, "Missed me?", Toast.LENGTH_SHORT).show();

                    }
                });

                sb.show();

            }
        });
    }
}
