package com.example.a16004118.c347msarevision.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class SimpleService extends Service{

    private static final String TAG = "MyService";
    private boolean started;

    public SimpleService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {

        Log.d(TAG, "onCreate: Service created");
        Toast.makeText(getApplicationContext(), "Service created", Toast.LENGTH_LONG).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (!started){
            started = true;
            Log.d(TAG, "onStartCommand: Service started");
            Toast.makeText(getApplicationContext(), "Service started", Toast.LENGTH_LONG).show();
        }else{
            Log.d(TAG, "onStartCommand: Service is still running");
            Toast.makeText(getApplicationContext(), "Service is still running", Toast.LENGTH_LONG).show();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

        Log.d(TAG, "onDestroy: Service exited");
        Toast.makeText(getApplicationContext(), "Service exited", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
}
