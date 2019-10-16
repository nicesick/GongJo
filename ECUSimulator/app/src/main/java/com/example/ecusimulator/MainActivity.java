package com.example.ecusimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textview, textview2, textview3,textViewSpeed,textViewDistance,textViewFuel,textViewBattery;
    SeekBar seekBar, seekBar2, seekBar3,seekBar4;

    Socket socket;
    ConnectServerTask connectServerTask = null;


    OutputStream out;
    DataOutputStream dout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        seekBar2 = findViewById(R.id.seekBar2);

        seekBar.setMax(200);
        seekBar2.setMax(1000);

        seekBar3 = findViewById(R.id.seekBar3);
        seekBar4 = findViewById(R.id.seekBar4);

        textViewSpeed = findViewById(R.id.textViewSpeed);
        textViewDistance = findViewById(R.id.textViewDistance);
        textViewFuel = findViewById(R.id.textViewFuel);
        textViewBattery = findViewById(R.id.textViewBattery);



        //Connection
        connectServerTask = new ConnectServerTask(8888, "70.12.60.106");
        socket = connectServerTask.getSocket();

        //Speed SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int speed = seekBar.getProgress();

                textViewSpeed.setText(speed + "");
                String temp = "";
                if(speed<10){
                    temp = "00"+speed;
                }else if(speed<100){
                    temp = "0"+speed;
                }else{
                    temp = ""+speed;
                }
                final String finalTemp = temp;
                Runnable testSendIoTRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {

                            out = socket.getOutputStream();
                            dout = new DataOutputStream(out);
                            dout.writeUTF("000100100000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });


        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int distance = seekBar2.getProgress();
                textViewDistance.setText(distance + "");
                String temp = "";
                if(distance<10){
                    temp = "00"+distance;
                }else if(distance<100){
                    temp = "0"+distance;
                }else{
                    temp = ""+distance;
                }
                final String finalTemp = temp;
                Runnable testSendIoTRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {

                            out = socket.getOutputStream();
                            dout = new DataOutputStream(out);
                            dout.writeUTF("000100150000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int fuel = seekBar3.getProgress();
                textViewSpeed.setText(fuel + "");
                String temp = "";
                if(fuel<10){
                    temp = "00"+fuel;
                }else if(fuel<100){
                    temp = "0"+fuel;
                }else{
                    temp = ""+fuel;
                }
                final String finalTemp = temp;
                Runnable testSendIoTRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {

                            out = socket.getOutputStream();
                            dout = new DataOutputStream(out);
                            dout.writeUTF("000100500000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });
        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int  battery = seekBar4.getProgress();
                textViewSpeed.setText(battery + "");
                String temp = "";
                if(battery<10){
                    temp = "00"+battery;
                }else if(battery<100){
                    temp = "0"+battery;
                }else{
                    temp = ""+battery;
                }
                final String finalTemp = temp;
                Runnable testSendIoTRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {

                            out = socket.getOutputStream();
                            dout = new DataOutputStream(out);
                            dout.writeUTF("000100550000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });




        class ssend extends AsyncTask<Integer, Integer, Integer>{
            public ssend(){

            }

            @Override
            protected Integer doInBackground(Integer... integers) {
                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

        }
    }//End OnCreate


}
