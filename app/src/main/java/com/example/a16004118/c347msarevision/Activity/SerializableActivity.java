package com.example.a16004118.c347msarevision.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a16004118.c347msarevision.Object.SerializableItem;
import com.example.a16004118.c347msarevision.R;

public class SerializableActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serializable);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SerializableActivity.this, SerializableActivity2.class);
                i.putExtra("object", new SerializableItem("Yao Liang", 16004118));
                startActivity(i);
            }
        });
    }
}
