package com.example.a16004118.c347msarevision.Activity;

import android.Manifest;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a16004118.c347msarevision.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class LocationUpdatingActivity extends AppCompatActivity
        implements View.OnClickListener{

    private Button btnGetLastLocation, btnGetLocationUpdate, btnRemoveLocationUpdate;
    private static final String TAG = "LocationUpdatingActivity";
    private FusedLocationProviderClient client;
    private LocationCallback mLocationCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_updating);

        btnGetLastLocation = findViewById(R.id.btnGetLastLocation);
        btnGetLocationUpdate = findViewById(R.id.btnGetLocationUpdate);
        btnRemoveLocationUpdate = findViewById(R.id.btnRemoveLocationUpdate);

        btnGetLastLocation.setOnClickListener(this);
        btnGetLocationUpdate.setOnClickListener(this);
        btnRemoveLocationUpdate.setOnClickListener(this);

        client = LocationServices.getFusedLocationProviderClient(this);

        mLocationCallBack = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult != null) {
                    Location data = locationResult.getLastLocation();
                    double lat = data.getLatitude();
                    double lng = data.getLongitude();
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnGetLastLocation:
                if (checkPermission()) {
                    Task<Location> task = client.getLastLocation();
                    task.addOnSuccessListener(LocationUpdatingActivity.this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                String msg = "Lat: " + location.getLatitude() +
                                        " Lng: " + location.getLongitude();
                                Toast.makeText(LocationUpdatingActivity.this, msg, Toast.LENGTH_LONG).show();
                            } else {
                                String msg = "No Last Known Location Found";
                                Toast.makeText(LocationUpdatingActivity.this, msg, Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                } else {
                    String msg = "Permission not granted to retrieve location info";
                    Toast.makeText(LocationUpdatingActivity.this, msg, Toast.LENGTH_LONG).show();
                    ActivityCompat.requestPermissions(LocationUpdatingActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                    Manifest.permission.ACCESS_COARSE_LOCATION}, 0);
                }

                break;

            case R.id.btnGetLocationUpdate:
                if (checkPermission()){

                    LocationRequest mLocationRequest = LocationRequest.create();
                    mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                    mLocationRequest.setInterval(10000);
                    mLocationRequest.setFastestInterval(5000);
                    mLocationRequest.setSmallestDisplacement(100);

                    client.requestLocationUpdates(mLocationRequest, mLocationCallBack, null);
                    Task<Location> task = client.getLastLocation();
                    task.addOnSuccessListener(LocationUpdatingActivity.this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                String msg = "New Location Detected\nLat: " + location.getLatitude() +
                                        " Lng: " + location.getLongitude();
                                Toast.makeText(LocationUpdatingActivity.this, msg, Toast.LENGTH_LONG).show();
                            } else {
                                String msg = "No Last Known Location Found";
                                Toast.makeText(LocationUpdatingActivity.this, msg, Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                }else{
                    String msg = "Permission not granted to retrieve location info";
                    Toast.makeText(LocationUpdatingActivity.this, msg, Toast.LENGTH_LONG).show();
                    ActivityCompat.requestPermissions(LocationUpdatingActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                    Manifest.permission.ACCESS_COARSE_LOCATION}, 0);
                }
                break;

            case R.id.btnRemoveLocationUpdate:
                client.removeLocationUpdates(mLocationCallBack);
                break;

            default:
                break;
        }
    }

    private boolean checkPermission(){
        int permissionCheck_Coarse = ContextCompat.checkSelfPermission(
                LocationUpdatingActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int permissionCheck_Fine = ContextCompat.checkSelfPermission(
                LocationUpdatingActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);

        if (permissionCheck_Coarse == PermissionChecker.PERMISSION_GRANTED ||
                permissionCheck_Fine == PermissionChecker.PERMISSION_GRANTED){
            return true;
        }else{
            return false;
        }

    }
}
