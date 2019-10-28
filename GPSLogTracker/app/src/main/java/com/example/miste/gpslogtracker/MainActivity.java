package com.example.miste.gpslogtracker;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class LocationInfo {
    private double latitude;
    private double longitude;
    private Date date;

    public LocationInfo(double latitude, double longitude, Date date) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Date getDate() {
        return date;
    }
}

public class MainActivity extends AppCompatActivity {
    private static final SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat hmsFormat = new SimpleDateFormat("kk:mm:ss");

    private ArrayList<LocationInfo> locationInfos;
    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            setMarkers(location.getLatitude(), location.getLongitude(), new Date());
            locationInfos.add(new LocationInfo(location.getLatitude(), location.getLongitude(), new Date()));
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    private TextView progressTextView;
    private Button controlButton;
    private LinearLayout linearLayoutTMap;
    private TMapView tMapView;
    private int markerIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationInfos = new ArrayList<>();

        String[] permissions = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        checkPermissions(permissions);
    }

    private void checkPermissions(String[] permissions) {
        ArrayList<String> targets = new ArrayList<String>();
        
        for (int i = 0 ; i < permissions.length ; i++) {
            String target = permissions[i];

            int checkSelfPermission = ContextCompat.checkSelfPermission(this, target);
            
            if (checkSelfPermission != PackageManager.PERMISSION_GRANTED) {
                targets.add(target);
            }
        }

        if (targets.size() > 0) {
            String[] targetPermissions = new String[targets.size()];

            targets.toArray(targetPermissions);
            ActivityCompat.requestPermissions(this, targetPermissions, 101);
        }

        else {
            init();
        }
    }

    private void init() {
        mapValues();
        setEvents();
    }

    private void removeMarkers() {
        tMapView.removeAllMarkerItem();
    }

    private void setMarkers(double latitude, double longitude, Date date) {
        TMapMarkerItem tMapMarkerItem = new TMapMarkerItem();
        TMapPoint tMapPoint = new TMapPoint(latitude, longitude);
        Bitmap iconBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.pin);

        tMapMarkerItem.setIcon(iconBitmap);
        tMapMarkerItem.setPosition(0.5f, 1.0f);
        tMapMarkerItem.setTMapPoint(tMapPoint);
        tMapMarkerItem.setName(dayFormat.format(date) + " " + hmsFormat.format(date));

        tMapView.addMarkerItem("marker" + markerIndex++, tMapMarkerItem);
        tMapView.setCenterPoint(longitude, latitude, true);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad / Math.PI * 180.0);
    }

    private double calcDistance(double latitude, double longitude, double tLatitude, double tLongitude) {
        double distance = Math.sin(deg2rad(latitude)) * Math.sin(deg2rad(tLatitude)) +
                Math.cos(deg2rad(latitude)) * Math.cos(deg2rad(tLatitude)) * Math.cos(deg2rad(longitude - tLongitude));

        distance = Math.acos(distance);
        distance = rad2deg(distance);
        distance = distance * 60 * 1.1515;
        distance = distance * 1.609344;

        // change the distance standard from kilometer to meter
        distance = distance * 1000;
        return distance;

        // reference : https://sijoo.tistory.com/165
    }

    private double calcSpeed(double distance, long time) {
        // change the time standard from millisecond to second
        double speed = distance / (time / 1000.0d);
        return speed;
    }

    private void saveTheData(Date date) {
        File file = null;
        FileOutputStream fos = null;
        String dataName = "GPSData" + "_" + dayFormat.format(date) + "_" + hmsFormat.format(date) + ".txt";

        try {
            file = new File(Environment.getExternalStorageDirectory(),dataName);
            fos = new FileOutputStream(file);

            String msg = "";

            double beforeLatitude = 0;
            double beforeLongitude = 0;
            Date beforeDate = null;

            for (LocationInfo locationInfo : locationInfos) {
                if (beforeLatitude != 0 && beforeLongitude != 0 && beforeDate != null) {
                    double distance = calcDistance(beforeLatitude, beforeLongitude, locationInfo.getLatitude(), locationInfo.getLongitude());
                    double speed = calcSpeed(distance, locationInfo.getDate().getTime() - beforeDate.getTime());

                    msg = dayFormat.format(locationInfo.getDate()) +
                            "," + hmsFormat.format(locationInfo.getDate()) +
                            "," + locationInfo.getLatitude() +
                            "," + locationInfo.getLongitude() +
                            "," + distance +
                            "," + speed + "\n";
                }

                else {
                    msg = dayFormat.format(locationInfo.getDate()) +
                            "," + hmsFormat.format(locationInfo.getDate()) +
                            "," + locationInfo.getLatitude() +
                            "," + locationInfo.getLongitude() +
                            "," + 0 +
                            "," + 0 + "\n";
                }

                beforeLatitude = locationInfo.getLatitude();
                beforeLongitude = locationInfo.getLongitude();
                beforeDate = locationInfo.getDate();

                fos.write(msg.getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Toast.makeText(this, dataName + " is saved", Toast.LENGTH_LONG).show();
    }

    private void setEvents() {
        controlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (controlButton.getText().toString().equals("StartTracking")) {
                    controlButton.setText("StopTracking");
                    progressTextView.setText("측정 중");

                    locationInfos.clear();
                    startLocationManager();
                }

                else {
                    controlButton.setText("StartTracking");
                    progressTextView.setText("측정 전");

                    saveTheData(new Date());
                    removeMarkers();

                    locationInfos.clear();
                    stopLocationManager();
                }
            }
        });
    }

    private void mapValues() {
        progressTextView = findViewById(R.id.progressTextView);
        progressTextView.setText("측정 전");

        controlButton = findViewById(R.id.controlButton);
        controlButton.setText("StartTracking");

        linearLayoutTMap = findViewById(R.id.linearLayoutTMap);
        tMapView = new TMapView(this);
        tMapView.setSKTMapApiKey("6d5f3c67-c735-4bca-93bc-672be00adaac");

        linearLayoutTMap.addView(tMapView);
        markerIndex = 0;
    }

    private void stopLocationManager() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.removeUpdates(locationListener);
    }

    private void startLocationManager() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 10, locationListener);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 101) {
            for (int i = 0 ; i < permissions.length ; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this,permissions[i] + " : denied", Toast.LENGTH_LONG).show();
                    return;
                }
            }

            init();
        }
    }
}
