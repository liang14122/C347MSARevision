package com.example.a16004118.c347msarevision.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.a16004118.c347msarevision.R;

public class RadioGroupActivity extends AppCompatActivity {

    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_group);

        rg = findViewById(R.id.rg);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rbSelected = findViewById(selectedButtonId);
                Toast.makeText(RadioGroupActivity.this, rbSelected.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
