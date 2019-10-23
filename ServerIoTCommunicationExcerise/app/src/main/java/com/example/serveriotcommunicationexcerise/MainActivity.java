package com.example.serveriotcommunicationexcerise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ArrayList<Socket> socketList;
    Socket serverSocket;
    ConnectIoTTask connectIoTTask = null;
    ConnectServerTask connectServerTask = null;
    int index;
    int clickedButton;
    OutputStream out;
    DataOutputStream dout;

    TextView timeTextView;

    FragmentManager fragmentManager;
    comsumableFragment comsumableFragment;
    mapFragment mapFragment;
    SettingFragment settingFragment;
    RealTimeFragment realTimeFragment;

    private FragmentTransaction transaction;
    URL url;

    ChangeTimeInRealTime changeTimeInRealTime;
    SendStateWithHttp sendStateWithHttp;
    RealTimeController realTimeController;

    Button mapFragmentButton,settingFragmentButton,realTimeFragmentButton,consumableFragmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url = null;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setViewControl();
        setFragment();
        changeTimeInRealTime = new ChangeTimeInRealTime(timeTextView);
        changeTimeInRealTime.start();
        setURL();
        index = 0;
        sendStateWithHttp = new SendStateWithHttp(url);
        checkPermission();
        openSocket();

    }
    void checkPermission(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}
                ,101);//실제로 물어보는 코드
    }
    void setURL(){
        try {
            url = new URL("http://70.12.60.95/ConnectedCarControlSystem/sendData.mc");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        changeTimeInRealTime.endProcess();
//        try {
//            connectServerTask.endProcess();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    void setFragment(){
        fragmentManager =getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        comsumableFragment = new comsumableFragment();
        mapFragment = new mapFragment();
        settingFragment = new SettingFragment();
        realTimeFragment = new RealTimeFragment();

        realTimeController = new RealTimeController();

        transaction.replace(R.id.FragmentLayout,comsumableFragment).commit();
        clickedButton = R.id.csmFragmentButton;
    }
    void setViewControl(){
        mapFragmentButton = findViewById(R.id.mapFragmentButton);
        settingFragmentButton = findViewById(R.id.settingFragmentButton);
        realTimeFragmentButton = findViewById(R.id.envFragmentButton);
        consumableFragmentButton = findViewById(R.id.csmFragmentButton);

        timeTextView= findViewById(R.id.TimeVIew);
//        changeTimeInRealTime = new ChangeTimeInRealTime(timeTextView);

        textView = findViewById(R.id.textView2);


    }

    private class TestSender extends Thread {
        private Socket socket;

        public TestSender(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                OutputStream out = socket.getOutputStream();
                DataOutputStream dout = new DataOutputStream(out);

                dout.writeUTF("HaHa");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void openSocket(){
        socketList = new ArrayList<Socket>();

        connectServerTask = new ConnectServerTask(8890, "70.12.60.99",socketList,textView);
        serverSocket = connectServerTask.getSocket();

        TestSender testSender = new TestSender(serverSocket);
        testSender.start();

        if(serverSocket == null) Log.i("Server","socket is empty");
        try {
            connectIoTTask = new ConnectIoTTask(socketList,serverSocket,textView);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(connectIoTTask !=null) {
            connectIoTTask.acceptSocket();
            Log.i("IoT","client is ready");
        }
    }

    public void onClick(View v){
        setButtonClickable(clickedButton);

        switch (v.getId()){
            case R.id.mapFragmentButton:
                Log.d("button","map");
                setButtonUI(mapFragmentButton);
                clickedButton = R.id.mapFragmentButton;
                int permission = PermissionChecker.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
                if(permission == PackageManager.PERMISSION_GRANTED){
                    getSupportFragmentManager().beginTransaction().replace(R.id.FragmentLayout,mapFragment).commit();
                }
                break;
            case R.id.envFragmentButton:
                Log.d("button","environment");
                clickedButton = R.id.envFragmentButton;
                setButtonUI(realTimeFragmentButton);
                getSupportFragmentManager().beginTransaction().replace(R.id.FragmentLayout,realTimeFragment).commit();
                break;
            case R.id.csmFragmentButton:
                Log.d("button","consumable");
                setButtonUI(consumableFragmentButton);
                clickedButton = R.id.csmFragmentButton;
                getSupportFragmentManager().beginTransaction().replace(R.id.FragmentLayout,comsumableFragment).commit();

                break;
            case R.id.settingFragmentButton:
                Log.d("button","setting");
                setButtonUI(settingFragmentButton);
                clickedButton = R.id.settingFragmentButton;
                realTimeController.setInTpt(index+"");
                index++;
                getSupportFragmentManager().beginTransaction().replace(R.id.FragmentLayout,settingFragment).commit();
                try {
                    sendStateWithHttp.sendMsg("aaa");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
    void setButtonUI(Button button){
        realTimeFragmentButton.setSelected(false);
        consumableFragmentButton.setSelected(false);
        settingFragmentButton.setSelected(false);
        mapFragmentButton.setSelected(false);
        button.setClickable(false);
        button.setTextColor(Color.BLACK);
        button.setSelected(true);

    }
    void setButtonClickable(int id){
        switch (id) {
            case R.id.mapFragmentButton:
                mapFragmentButton.setClickable(true);
                mapFragmentButton.setTextColor(Color.WHITE);
                break;
            case R.id.envFragmentButton:
                realTimeFragmentButton.setClickable(true);
                realTimeFragmentButton.setTextColor(Color.WHITE);
                break;
            case R.id.csmFragmentButton:
                consumableFragmentButton.setClickable(true);
                consumableFragmentButton.setTextColor(Color.WHITE);
                break;
            case R.id.settingFragmentButton:
                settingFragmentButton.setClickable(true);
                settingFragmentButton.setTextColor(Color.WHITE);
                break;
        }
    }

    public void SendMsgToLetterPanda(){
        for(final Socket socket:socketList){
            Runnable testSendIoTRunnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        out = socket.getOutputStream();
                        dout = new DataOutputStream(out);
                        dout.writeUTF("Test : android is send "+ 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            };
            Thread testThread = new Thread(testSendIoTRunnable);
            testThread.start();
        }
        index++;
    }
}
