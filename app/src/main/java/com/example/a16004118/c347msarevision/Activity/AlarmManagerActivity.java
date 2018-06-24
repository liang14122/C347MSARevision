package com.example.a16004118.c347msarevision.Activity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a16004118.c347msarevision.R;

import java.util.Calendar;

public class AlarmManagerActivity extends AppCompatActivity {

    private Button btnInstant, btnDelayed;
    private AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);

        btnInstant = findViewById(R.id.btnInstant);
        btnDelayed = findViewById(R.id.btnDelayed);

        btnInstant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();

                Intent intent = new Intent(AlarmManagerActivity.this,
                        AlarmReceiverActivity.class);

                intent.putExtra("type", "It an instant alarm");

                int requestCode = 38324;
                PendingIntent pendingIntent = PendingIntent.getActivity(AlarmManagerActivity.this,
                        requestCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                alarmManager = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

            }
        });

        btnDelayed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.SECOND, 5);

                Intent intent = new Intent(AlarmManagerActivity.this,
                        AlarmReceiverActivity.class);

                intent.putExtra("type", "It a delayed alarm");

                int requestCode = 38324;
                PendingIntent pendingIntent = PendingIntent.getActivity(AlarmManagerActivity.this,
                        requestCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                alarmManager = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        });

    }
}
