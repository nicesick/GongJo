package com.example.ecusimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    TextView textview, textview2, textview3,textViewSpeed,textViewDistance,textViewFuel,textViewBattery,textViewCO2,textViewDust,textViewSdust,textViewTemperature,textViewHumidity;
    SeekBar seekBar, seekBar2, seekBar3,seekBar4,seekBar5, seekBar6, seekBar7,seekBar8,seekBar9;
    Button button2,button3;



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
        seekBar3 = findViewById(R.id.seekBar3);
        seekBar4 = findViewById(R.id.seekBar4);
        seekBar5 = findViewById(R.id.seekBar5);
        seekBar6 = findViewById(R.id.seekBar6);
        seekBar7 = findViewById(R.id.seekBar7);
        seekBar8 = findViewById(R.id.seekBar8);
        seekBar9 = findViewById(R.id.seekBar9);

        seekBar.setMax(200);
        seekBar2.setMax(1000);
        seekBar3.setMax(100);
        seekBar4.setMax(15);
        seekBar5.setMax(4700);
        seekBar6.setMax(200);
        seekBar7.setMax(150);
        seekBar8.setMax(90);
        seekBar9.setMax(100);

        textViewCO2 = findViewById(R.id.textViewCO2);
        textViewDust = findViewById(R.id.textViewDust);
        textViewSdust = findViewById(R.id.textViewSdust);
        textViewTemperature = findViewById(R.id.textViewTemperature);
        textViewHumidity = findViewById(R.id.textViewHumidity);
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
                textViewFuel.setText(fuel + "");
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
                textViewBattery.setText(battery + "");
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
        seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int co2 = seekBar5.getProgress()+300;

                textViewCO2.setText(co2 + "");
                String temp = "";
                if(co2<1000){
                    temp = "0"+co2;
                }else if(co2<=5000){
                    temp = " "+co2;
                }
                final String finalTemp = temp;
                Runnable testSendIoTRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {

                            out = socket.getOutputStream();
                            dout = new DataOutputStream(out);
                            dout.writeUTF("00020020000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });


        seekBar6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int dust = seekBar6.getProgress();
                textViewDust.setText(dust + "");
                String temp = "";
                if(dust<10){
                    temp = "00"+dust;
                }else if(dust<100){
                    temp = "0"+dust;
                }else{
                    temp = ""+dust;
                }
                final String finalTemp = temp;
                Runnable testSendIoTRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {

                            out = socket.getOutputStream();
                            dout = new DataOutputStream(out);
                            dout.writeUTF("000200300000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });
        seekBar7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int sdust = seekBar7.getProgress();
                textViewSdust.setText(sdust + "");
                String temp = "";
                if(sdust<10){
                    temp = "00"+sdust;
                }else if(sdust<100){
                    temp = "0"+sdust;
                }else{
                    temp = ""+sdust;
                }
                final String finalTemp = temp;
                Runnable testSendIoTRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {

                            out = socket.getOutputStream();
                            dout = new DataOutputStream(out);
                            dout.writeUTF("000200350000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });
        seekBar8.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int  temperature = seekBar8.getProgress();
                int temp4text = temperature -40;
                textViewTemperature.setText(temp4text + "");
                String temp = "";
                if(temperature<10){
                    temp = "00"+temperature;
                }else if(temperature<100){
                    temp = "0"+temperature;
                }else{
                    temp = ""+temperature;
                }
                final String finalTemp = temp;
                Runnable testSendIoTRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {

                            out = socket.getOutputStream();
                            dout = new DataOutputStream(out);
                            dout.writeUTF("000200400000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });
        seekBar9.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int  humidity = seekBar9.getProgress();
                textViewHumidity.setText(humidity + "");
                String temp = "";
                if(humidity<10){
                    temp = "00"+humidity;
                }else if(humidity<100){
                    temp = "0"+humidity;
                }else{
                    temp = ""+humidity;
                }
                final String finalTemp = temp;
                Runnable testSendIoTRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {

                            out = socket.getOutputStream();
                            dout = new DataOutputStream(out);
                            dout.writeUTF("000200450000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });

    }//End OnCreate


}
