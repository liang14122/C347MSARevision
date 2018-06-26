package com.example.a16004118.c347msarevision.Activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a16004118.c347msarevision.R;

public class ContentProviderActivity extends AppCompatActivity {

    private Button btnRetrieveALLSMS, btnRetrieveSMSWithFilter;
    private TextView tvSMS;
    private static final String TAG = "ContentProviderActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        btnRetrieveALLSMS = findViewById(R.id.btnRetrieveALLSMS);
        btnRetrieveSMSWithFilter = findViewById(R.id.btnRetrieveSMSWithFilter);
        tvSMS = findViewById(R.id.tvSMS);

        btnRetrieveALLSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int permissionCheck = PermissionChecker.checkSelfPermission
                        (ContentProviderActivity.this, Manifest.permission.READ_SMS);

                if (permissionCheck != PermissionChecker.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(ContentProviderActivity.this,
                            new String[]{Manifest.permission.READ_SMS}, 0);
                    return;
                }

                Uri uri = Uri.parse("content://sms");
                String[] reqCols = new String[]{"date", "address", "body", "type"};

                ContentResolver contentResolver = getContentResolver();
                Cursor cursor = contentResolver.query(uri, reqCols, null, null, null);
                String smsBody = "";

                if (cursor.moveToFirst()){

                    do {
                        long dateImMIlls = cursor.getLong(0);
                        String date = (String) DateFormat.format("dd MMM yyyy h:mm:ss aa", dateImMIlls);
                        String address = cursor.getString(1);
                        String body = cursor.getString(2);
                        String type = cursor.getString(3);

                        if (type.equalsIgnoreCase("1")){
                            type = "Inbox: ";
                        }else{
                            type = "Sent: ";
                        }
                        smsBody += type + " " + address + "\n at " + date + "\n \"" + body + "\"\n\n";
                    }while (cursor.moveToNext());

                }
                tvSMS.setText(smsBody);

            }
        });

        btnRetrieveALLSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permissionCheck = PermissionChecker.checkSelfPermission
                        (ContentProviderActivity.this, Manifest.permission.READ_SMS);

                if (permissionCheck != PermissionChecker.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(ContentProviderActivity.this,
                            new String[]{Manifest.permission.READ_SMS}, 0);
                    return;
                }

                Uri uri = Uri.parse("content://sms");
                String[] reqCols = new String[]{"date", "address", "body", "type"};

                ContentResolver contentResolver = getContentResolver();

                String filter = "body LIKE ? AND body LIKE ?";
                String[] filterArgs = {"%1%"};


                @SuppressLint("Recycle") Cursor cursor = contentResolver.query(uri, reqCols, filter, filterArgs, null);
                String smsBody = "";

                assert cursor != null;
                if (cursor.moveToFirst()){

                    do {
                        long dateImMIlls = cursor.getLong(0);
                        String date = (String) DateFormat.format("dd MMM yyyy h:mm:ss aa", dateImMIlls);
                        String address = cursor.getString(1);
                        String body = cursor.getString(2);
                        String type = cursor.getString(3);

                        if (type.equalsIgnoreCase("1")){
                            type = "Inbox: ";
                        }else{
                            type = "Sent: ";
                        }
                        smsBody += type + " " + address + "\n at " + date + "\n \"" + body + "\"\n\n";
                    }while (cursor.moveToNext());

                }
                tvSMS.setText(smsBody);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case  0: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_DENIED){
                    btnRetrieveALLSMS.performClick();
                }else{
                    Log.e(TAG, "onRequestPermissionsResult: Permission id not granted");
                }
            }
        }

    }
}
