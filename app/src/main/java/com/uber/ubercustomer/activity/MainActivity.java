package com.uber.ubercustomer.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.uber.ubercustomer.R;
import com.uber.ubercustomer.retrofit.location.ILocationService;
import com.uber.ubercustomer.retrofit.location.LocationServiceBuilder;
import com.uber.ubercustomer.services.updatemap.Service;
import com.uber.ubercustomer.tools.IActivityBase;

public class MainActivity extends AppCompatActivity implements IActivityBase {

    private LocationManager locationManager;
    private LocationListener locationListener;
    private ILocationService locationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestLocationPermission();
        initViewRefrences();
        initViewActions();
        initInitialValues();
    }

    @Override
    public void initViewRefrences() {
       /* locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationService = new LocationServiceBuilder().getService();
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {

            }
        };*/
    }

    @Override
    public void initViewActions() {

      //  setLocationUpdateListener();
        startUpdateMapSerivce();
    }

    @Override
    public void initInitialValues() {

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void requestLocationPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 2);
        }
    }

    private void setLocationUpdateListener() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
        )
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);
    }

    private  void startUpdateMapSerivce(){
        try {
            Intent intent = new Intent(MainActivity.this, Service.class);
            startForegroundService(intent);
        }catch (Exception e ){
            Log.e("Receiver",e.getMessage());
        }
    }
}