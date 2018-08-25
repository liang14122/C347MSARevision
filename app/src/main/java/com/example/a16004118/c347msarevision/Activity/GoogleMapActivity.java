package com.example.a16004118.c347msarevision.Activity;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a16004118.c347msarevision.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapActivity extends AppCompatActivity
        implements View.OnClickListener{

    private Button btnNormal, btnSatellite, btnTerrain, btnHybrid, btnNorth, btnCentral, btnEast;
    private GoogleMap map;
    private static final String TAG = "GoogleMapActivity";
    private final LatLng north = new LatLng(1.461723, 103.815623);
    private final LatLng central = new LatLng(1.312465, 103.846745);
    private final LatLng east = new LatLng(1.363721, 103.931733);
    private static final String northTitle = "HQ-North";
    private static final String northSnippet = "Block 333, Admiralty Ave 3, 765654";
    private static final String centralTitle = "Central";
    private static final String centralSnippet = "Block 3A, Orchard Ave 3, 134542";
    private static final String eastTitle = "East";
    private static final String eastSnippet = "Block 555, Tampines Ave 3, 287788";
    private Marker markerNorth, markerCentral, markerEast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        btnNormal = findViewById(R.id.btnNormal);
        btnSatellite = findViewById(R.id.btnSatellite);
        btnTerrain = findViewById(R.id.btnTerrain);
        btnHybrid = findViewById(R.id.btnHybrid);
        btnNorth = findViewById(R.id.btnNorth);
        btnCentral = findViewById(R.id.btnCentral);
        btnEast = findViewById(R.id.btnEast);

        btnNormal.setOnClickListener(this);
        btnSatellite.setOnClickListener(this);
        btnTerrain.setOnClickListener(this);
        btnHybrid.setOnClickListener(this);
        btnNorth.setOnClickListener(this);
        btnCentral.setOnClickListener(this);
        btnEast.setOnClickListener(this);

        FragmentManager fm = getSupportFragmentManager();
        final SupportMapFragment mapFragment =
                (SupportMapFragment) fm.findFragmentById(R.id.googleMap);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                map = googleMap;

                //map controls
                UiSettings ui = map.getUiSettings();
                ui.setCompassEnabled(true);
                ui.setMyLocationButtonEnabled(true);
                ui.setZoomControlsEnabled(true);
                ui.setMapToolbarEnabled(true);

                //init markers
                markerNorth = map.addMarker(new MarkerOptions()
                        .position(north)
                        .title(northTitle)
                        .snippet(northSnippet)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                markerCentral = map.addMarker(new MarkerOptions()
                        .position(central)
                        .title(centralTitle)
                        .snippet(centralSnippet)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                markerEast = map.addMarker(new MarkerOptions()
                        .position(east)
                        .title(eastTitle)
                        .snippet(eastSnippet)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                markerNorth.hideInfoWindow();
                markerEast.hideInfoWindow();
                markerCentral.hideInfoWindow();

                //init map move camera
                LatLng poi_Singapore = new LatLng(1.290270, 103.851959);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_Singapore, 10));

                //permission check
                int permissionCheck = ContextCompat.checkSelfPermission
                        (GoogleMapActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED){
                    map.setMyLocationEnabled(true);
                }else{
                    Log.e(TAG, "onMapReady: GPS access has not been granted" );
                    ActivityCompat.requestPermissions(GoogleMapActivity.this, new String[]
                            {
                                    Manifest.permission.ACCESS_COARSE_LOCATION,
                                    Manifest.permission.ACCESS_FINE_LOCATION
                            }, 1);

                }

                map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        Toast.makeText(GoogleMapActivity.this, marker.getTitle(), Toast.LENGTH_LONG).show();
                        return false;
                    }
                });
            }


        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnNormal:
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                moveCamera(north);
                break;

            case R.id.btnSatellite:
                map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                moveCamera(central);
                break;

            case R.id.btnTerrain:
                map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                moveCamera(east);
                break;

            case R.id.btnHybrid:
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                moveCamera(east);
                break;

            case R.id.btnNorth:
                updateMarkers(0);
                moveCamera(north);
                break;

            case R.id.btnCentral:
                updateMarkers(1);
                moveCamera(central);
                break;

            case R.id.btnEast:
                updateMarkers(2);
                moveCamera(east);
                break;

            default:
                break;
        }
    }

    private void moveCamera(LatLng latLng) {
        if (map != null) {
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12));
        }
    }

    private void updateMarkers(int position) {
        Marker[] markers = new Marker[]{markerNorth, markerCentral, markerEast};
        for (int i = 0; i < markers.length; i++) {
            if (i == position) {
                markers[i].setIcon(BitmapDescriptorFactory.fromResource(android.R.drawable.star_big_on));
                markers[i].showInfoWindow();
            } else {
                markers[i].setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                markers[i].hideInfoWindow();
            }
        }
    }

}
