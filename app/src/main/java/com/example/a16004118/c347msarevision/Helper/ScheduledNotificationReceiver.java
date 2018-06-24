package com.example.a16004118.c347msarevision.Helper;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.example.a16004118.c347msarevision.Activity.NotificationActivity;

public class ScheduledNotificationReceiver extends BroadcastReceiver {

    private int requestCode = 12345;
    private int notificationId = 14122;

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel =
                    new NotificationChannel("default", "Default Channel",
                            NotificationManager.IMPORTANCE_DEFAULT);

            notificationChannel.setDescription("This is for default notification");
            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel);
        }

        Intent i = new Intent(context, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity
                (context, requestCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder
                (context, "default");
        builder.setContentTitle("Scheduled Notification Title");
        builder.setContentText("Scheduled Notification Content");
        builder.setSmallIcon(android.R.drawable.star_big_on);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        Notification notification = builder.build();

        assert notificationManager != null;
        notificationManager.notify(notificationId, notification);

    }
}
