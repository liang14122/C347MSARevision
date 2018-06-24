package com.example.a16004118.c347msarevision.Activity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a16004118.c347msarevision.R;
import com.example.a16004118.c347msarevision.Helper.ScheduledNotificationReceiver;

import java.util.Calendar;

public class NotificationActivity extends AppCompatActivity {

    private int requestCode = 14122;
    private int notificationId = 38324;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Button btnBigText = findViewById(R.id.btnBigText);
        Button btnNormalNoti = findViewById(R.id.btnNormalNoti);
        Button btnScheduledNoti = findViewById(R.id.btnScheduledNoti);

        btnNormalNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationChannel notificationChannel =
                            new NotificationChannel("default", "Default Channel",
                                    NotificationManager.IMPORTANCE_DEFAULT);

                    notificationChannel.setDescription("This is for default notification");
                    assert notificationManager != null;
                    notificationManager.createNotificationChannel(notificationChannel);
                }

                Intent intent = new Intent(NotificationActivity.this, NotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity
                        (NotificationActivity.this, requestCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                NotificationCompat.Builder builder = new NotificationCompat.Builder
                        (NotificationActivity.this, "default");
                builder.setContentTitle("Normal Notification Title");
                builder.setContentText("Normal Notification Content");
                builder.setSmallIcon(android.R.drawable.star_big_on);
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);

                Notification notification = builder.build();

                assert notificationManager != null;
                notificationManager.notify(notificationId, notification);

            }
        });

        btnBigText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationChannel notificationChannel =
                            new NotificationChannel("default", "Default Channel",
                                    NotificationManager.IMPORTANCE_DEFAULT);

                    notificationChannel.setDescription("This is for default notification");
                    assert notificationManager != null;
                    notificationManager.createNotificationChannel(notificationChannel);
                }

                Intent intent = new Intent(NotificationActivity.this, NotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity
                        (NotificationActivity.this, requestCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
                bigTextStyle.setBigContentTitle("It is a Big Text Notification");
                bigTextStyle.bigText("This \n is \n a \n big \n text \n notification");
                bigTextStyle.setSummaryText("Show all Text");

                NotificationCompat.Builder builder = new NotificationCompat.Builder
                        (NotificationActivity.this, "default");
                builder.setContentTitle("Notification Title");
                builder.setContentText("Notification Content");
                builder.setSmallIcon(android.R.drawable.star_big_on);
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);
                builder.setStyle(bigTextStyle);

                Notification notification = builder.build();

                assert notificationManager != null;
                notificationManager.notify(notificationId, notification);

            }
        });

        btnScheduledNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.SECOND, 5);

                Intent intent = new Intent(NotificationActivity.this,
                        ScheduledNotificationReceiver.class);

                intent.putExtra("type", "It a delayed alarm");

                PendingIntent pendingIntent = PendingIntent.getBroadcast(NotificationActivity.this,
                        requestCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager alarmManager = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                assert alarmManager != null;
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        });
    }
}
