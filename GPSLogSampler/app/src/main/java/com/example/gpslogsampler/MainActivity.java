package com.example.gpslogsampler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    private LinearLayout linearLayoutTMap;
    private TMapView tMapView;

    private Button logSaveButton;
    private Button logSameButton;
    private Button logRemoveButton;

    private ArrayList<LocationInfo> locationInfos;
    private ArrayList<LocationInfo> originalLocationInfos;

    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationInfos = new ArrayList<>();
        originalLocationInfos = new ArrayList<>();

        String[] permissions = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
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
        getDataFromFile();
        mapValues();
        setEvents();
    }

    private void setValuesUnUsable() {
        logSaveButton.setEnabled(false);
        logSameButton.setEnabled(false);
        logRemoveButton.setEnabled(false);
    }

    private void saveTheNewData(Date date) {
        File file = null;
        FileOutputStream fos = null;
        String dataName = "Sampled_GPSData" + "_" + dayFormat.format(date) + "_" + hmsFormat.format(date) + ".txt";

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
        if(!setLocationInfos()) {
            setValuesUnUsable();
            saveTheNewData(new Date());
        }

        logSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationInfos.add(originalLocationInfos.get(currentIndex));
                currentIndex++;

                if(!setLocationInfos()) {
                    setValuesUnUsable();
                    saveTheNewData(new Date());
                }
            }
        });

        logSameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (locationInfos.size() != 0) {
                    removeMarkers("marker" + currentIndex);

                    LocationInfo pointChangedLocationInfo = new LocationInfo(locationInfos.get(locationInfos.size() - 1).getLatitude(),
                            locationInfos.get(locationInfos.size() - 1).getLongitude(), originalLocationInfos.get(currentIndex).getDate());

                    setMarkers(pointChangedLocationInfo.getLatitude(), pointChangedLocationInfo.getLongitude(), pointChangedLocationInfo.getDate());

                    locationInfos.add(pointChangedLocationInfo);
                    currentIndex++;

                    if(!setLocationInfos()) {
                        setValuesUnUsable();
                        saveTheNewData(new Date());
                    }
                }

                else {
                    Toast.makeText(MainActivity.this, "This Point is First Point", Toast.LENGTH_LONG).show();
                }
            }
        });

        logRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeMarkers("marker" + currentIndex);
                currentIndex++;

                if (!setLocationInfos()) {
                    setValuesUnUsable();
                    saveTheNewData(new Date());
                }
            }
        });
    }

    private boolean setLocationInfos() {
        if (currentIndex == originalLocationInfos.size()) {
            return false;
        }

        LocationInfo locationInfo = originalLocationInfos.get(currentIndex);
        setMarkers(locationInfo.getLatitude(), locationInfo.getLongitude(), locationInfo.getDate());

        return true;
    }

    private void mapValues() {
        logSaveButton = findViewById(R.id.logSaveButton);
        logSameButton = findViewById(R.id.logSameButton);
        logRemoveButton = findViewById(R.id.logRemoveButton);

        linearLayoutTMap = findViewById(R.id.linearLayoutTMap);
        tMapView = new TMapView(this);
        tMapView.setSKTMapApiKey("6d5f3c67-c735-4bca-93bc-672be00adaac");

        linearLayoutTMap.addView(tMapView);
    }

    private void getDataFromFile() {
        // 파일 이름 바꿔주기
        String fileName = "GPSData_2019-10-28_12:37:44.txt";

        File file = new File(Environment.getExternalStorageDirectory(), fileName);
        FileInputStream fin = null;
        BufferedReader br = null;

        String oneLine = null;

        try {
            fin = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fin));

            while((oneLine = br.readLine()) != null) {
                String[] lineInfos = oneLine.split(",");

                String date = lineInfos[0];
                String hms = lineInfos[1];
                String latitude = lineInfos[2];
                String longitude = lineInfos[3];

                String[] dateInfos = date.split("-");
                String year = dateInfos[0];
                String month = dateInfos[1];
                String day = dateInfos[2];

                Date reBuildedDate = new Date(year + "/" + month + "/" + day + "/" + hms);
                LocationInfo locationInfo = new LocationInfo(Double.parseDouble(latitude), Double.parseDouble(longitude), reBuildedDate);

                originalLocationInfos.add(locationInfo);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void removeMarkers(String markerId) {
        tMapView.removeMarkerItem(markerId);
    }

    private void setMarkers(double latitude, double longitude, Date date) {
        TMapMarkerItem tMapMarkerItem = new TMapMarkerItem();
        TMapPoint tMapPoint = new TMapPoint(latitude, longitude);
        Bitmap iconBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.pin);

        tMapMarkerItem.setIcon(iconBitmap);
        tMapMarkerItem.setPosition(0.5f, 1.0f);
        tMapMarkerItem.setTMapPoint(tMapPoint);
        tMapMarkerItem.setName(dayFormat.format(date) + " " + hmsFormat.format(date));

        tMapView.addMarkerItem("marker" + currentIndex, tMapMarkerItem);
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
