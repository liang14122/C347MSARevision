package com.example.a16004118.c347msarevision.Activity;

import android.Manifest;
import android.location.Location;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a16004118.c347msarevision.R;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileReadWritingActivity extends AppCompatActivity
        implements View.OnClickListener {

    private Button btnWriteToInternal, btnReadFromInternal,
            btnWriteToExternal, btnReadFromExternal;
    private TextView tvResult;
    private EditText etText;
    private static final String TAG = "FileReadWritingActivity";
    private String folderLocation;
    private File targetFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_read_writing);

        btnWriteToInternal = findViewById(R.id.btnWriteToInternal);
        btnReadFromInternal = findViewById(R.id.btnReadFromInternal);
        btnWriteToExternal = findViewById(R.id.btnWriteToExternal);
        btnReadFromExternal = findViewById(R.id.btnReadFromExternal);

        btnWriteToInternal.setOnClickListener(this);
        btnReadFromInternal.setOnClickListener(this);
        btnWriteToExternal.setOnClickListener(this);
        btnReadFromExternal.setOnClickListener(this);

        tvResult = findViewById(R.id.tvResult);
        etText = findViewById(R.id.etText);

        folderLocation = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Folder";
        targetFile = new File(folderLocation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnWriteToInternal:

                break;

            case R.id.btnReadFromInternal:

                break;

            case R.id.btnWriteToExternal:
                if (checkPermission()) {
                    try {
                        File targetFile = new File(folderLocation, "data.txt");

                        FileWriter writer = new FileWriter(targetFile, true);
                        String text = etText.getText().toString().trim();
                        writer.write(text + "\n");
                        writer.flush();
                        writer.close();
                    } catch (Exception e) {
                        Toast.makeText(FileReadWritingActivity.this, "Failed to write", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                } else {
                    String msg = "Permission not granted to Write";
                    Toast.makeText(FileReadWritingActivity.this, msg, Toast.LENGTH_LONG).show();
                    ActivityCompat.requestPermissions(FileReadWritingActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
                }
                break;

            case R.id.btnReadFromExternal:

                if (checkPermission()) {
                    String data = "";

                    try {

                        File targetFile = new File(folderLocation, "data.txt");
                        FileReader reader = new FileReader(targetFile);
                        BufferedReader bufferedReader = new BufferedReader(reader);

                        String line = bufferedReader.readLine();
                        while (line != null) {
                            data += line + "\n";
                            line = bufferedReader.readLine();
                        }
                        tvResult.setText(data);
                        bufferedReader.close();
                        reader.close();

                    } catch (Exception e) {
                        Toast.makeText(FileReadWritingActivity.this, "Failed to read", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                    Log.d(TAG, "onClick: " + data);
                }else{
                    String msg = "Permission not granted to Read";
                    Toast.makeText(FileReadWritingActivity.this, msg, Toast.LENGTH_LONG).show();
                    ActivityCompat.requestPermissions(FileReadWritingActivity.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
                }
                break;

            default:
                break;
        }
    }

    private boolean checkPermission() {
        int permissionCheck_Write = ContextCompat.checkSelfPermission(
                FileReadWritingActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permissionCheck_Read = ContextCompat.checkSelfPermission(
                FileReadWritingActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);

        return permissionCheck_Write == PermissionChecker.PERMISSION_GRANTED ||
                permissionCheck_Read == PermissionChecker.PERMISSION_GRANTED;

    }
}
