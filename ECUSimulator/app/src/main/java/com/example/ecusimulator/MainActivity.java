package com.example.ecusimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    TextView textview, textview2, textview3,textViewSpeed,
            textViewDistance,textViewFuel,textViewBattery,
            textViewCO2,textViewDust,textViewSdust,textViewExtDust,textViewExtSdust,textViewExtTemperature,textViewTemperature,
            textViewHumidity,textViewAircon,textViewEngine,textViewBrake,textViewAccoil,
            textViewCoolwater,textViewAccPressure,textViewBrakePressure;
    SeekBar seekBar, seekBar2, seekBar3,seekBar4,seekBar5, seekBar6, seekBar7,seekBar8,
            seekBar9,seekBar10,seekBar11,seekBar12,seekBar13,seekBar14,seekBar15,seekBar16,
            seekBar17,seekBar18,seekBar19;
    ImageView imageView,imageView25,imageView26,imageView27,imageView24,imageView28;



    Socket socket;
    ConnectServerTask connectServerTask = null;


    OutputStream out;
    DataOutputStream dout;

    InputStream in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView24=findViewById(R.id.imageView24);
        imageView25 = findViewById(R.id.imageView25);
        imageView27 = findViewById(R.id.imageView27);
        imageView26 = findViewById(R.id.imageView26);
        imageView28 = findViewById(R.id.imageView28);



        imageView.setOnClickListener(new View.OnClickListener() {
            int temp = 0;
            public void onClick(View v) {
                if (temp == 0) {
                    imageView.setImageResource(R.drawable.cartopviewoff);
                    temp = 1;
                } else if (temp == 1) {
                    imageView.setImageResource(R.drawable.cartopviewon);
                    temp = 0;
                }
            }
        });
       imageView26.bringToFront();
        imageView26.setOnClickListener(new View.OnClickListener() {
            int temp = 0;
            public void onClick(View v) {
                if (temp == 0) {
                    imageView26.setImageResource(R.drawable.lock);
                    temp = 1;
                } else if (temp == 1) {
                    imageView26.setImageResource(R.drawable.unlock);
                    temp = 0;
                }
            }
        });
        imageView28.bringToFront();
        imageView28.setOnClickListener(new View.OnClickListener() {
            int temp = 0;
            public void onClick(View v) {
                if (temp == 0) {
                    imageView28.setImageResource(R.drawable.lock);
                    temp = 1;
                } else if (temp == 1) {
                    imageView28.setImageResource(R.drawable.unlock);
                    temp = 0;
                }
            }
        });

        imageView25.bringToFront();
        imageView25.setOnClickListener(new View.OnClickListener() {
            int temp = 0;
            public void onClick(View v) {
                if (temp == 0) {
                    imageView25.setImageResource(R.drawable.beltoff);
                    temp = 1;
                } else if (temp == 1) {
                    imageView25.setImageResource(R.drawable.belton);
                    temp = 0;
                }
            }
        });

        imageView27.bringToFront();
        imageView27.setOnClickListener(new View.OnClickListener() {
            int temp = 0;
            public void onClick(View v) {
                if (temp == 0) {
                    imageView27.setImageResource(R.drawable.beltoff);
                    temp = 1;
                } else if (temp == 1) {
                    imageView27.setImageResource(R.drawable.belton);
                    temp = 0;
                }
            }
        });

        seekBar = findViewById(R.id.seekBar);
        seekBar2 = findViewById(R.id.seekBar2);
        seekBar3 = findViewById(R.id.seekBar3);
        seekBar4 = findViewById(R.id.seekBar4);
        seekBar5 = findViewById(R.id.seekBar5);
        seekBar6 = findViewById(R.id.seekBar6);
        seekBar7 = findViewById(R.id.seekBar7);
        seekBar8 = findViewById(R.id.seekBar8);
        seekBar9 = findViewById(R.id.seekBar9);
        seekBar10 = findViewById(R.id.seekBar10);
        seekBar11 = findViewById(R.id.seekBar11);
        seekBar12 = findViewById(R.id.seekBar12);
        seekBar13 = findViewById(R.id.seekBar13);
        seekBar14 = findViewById(R.id.seekBar14);
        seekBar15 = findViewById(R.id.seekBar15);
        seekBar16 = findViewById(R.id.seekBar16);
        seekBar17 = findViewById(R.id.seekBar17);
        seekBar18 = findViewById(R.id.seekBar18);
        seekBar19 = findViewById(R.id.seekBar19);

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
        textViewAircon = findViewById(R.id.textViewAircon);
        textViewEngine = findViewById(R.id.textViewEngine);
        textViewBrake = findViewById(R.id.textViewBrake);
        textViewAccoil = findViewById(R.id.textViewAccoil);
        textViewCoolwater = findViewById(R.id.textViewCoolwater);
        textViewAccPressure = findViewById(R.id.textViewAccPressure);
        textViewBrakePressure = findViewById(R.id.textViewBrakePressure);
        textViewExtDust = findViewById(R.id.textViewExtDust);
        textViewExtSdust = findViewById(R.id.textViewExtSdust);
        textViewExtTemperature = findViewById(R.id.textViewExtTemperature);

        textViewCO2.bringToFront();
        textViewDust.bringToFront();
        textViewSdust.bringToFront();
        textViewTemperature.bringToFront();
        textViewHumidity.bringToFront();
        textViewSpeed.bringToFront();
        textViewDistance.bringToFront();
        textViewFuel.bringToFront();
        textViewBattery.bringToFront();
        textViewAircon.bringToFront();
        textViewEngine.bringToFront();
        textViewBrake.bringToFront();
        textViewAccoil.bringToFront();
        textViewEngine.bringToFront();
        textViewBrake.bringToFront();
        textViewAccoil.bringToFront();
        textViewCoolwater.bringToFront();
        textViewAccPressure.bringToFront();
        textViewBrakePressure.bringToFront();
        textViewExtDust.bringToFront();
        textViewExtSdust.bringToFront();
        textViewExtTemperature.bringToFront();
        //Connection

        while(true) {
            connectServerTask = new ConnectServerTask(8888, "70.12.225.75");
            socket = connectServerTask.getSocket();
            try{
            if(socket != null){
                break;
            }}catch (Exception e){
                Log.d("connection to ECU","Re-try ");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }

        }

        Receiver receiver = new Receiver(socket);
        receiver.execute();



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
                }else{
                    temp = ""+co2;
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

        seekBar17.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int dust = seekBar17.getProgress();
                textViewExtDust.setText(dust + "");
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
                            dout.writeUTF("000200500000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });
        seekBar18.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int sdust = seekBar18.getProgress();
                textViewExtSdust.setText(sdust + "");
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
                            dout.writeUTF("000200550000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });
        seekBar19.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int  temperature = seekBar19.getProgress();
                int temp4text = temperature -40;
                textViewExtTemperature.setText(temp4text + "");
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
                            dout.writeUTF("000200600000000000000"+ finalTemp);
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

        seekBar10.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int  aircon = seekBar10.getProgress();
                textViewAircon.setText(aircon + "");
                String temp = "";
                if(aircon<10){
                    temp = "00"+aircon;
                }else if(aircon<100){
                    temp = "0"+aircon;
                }else{
                    temp = ""+aircon;
                }
                final String finalTemp = temp;
                Runnable testSendIoTRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {

                            out = socket.getOutputStream();
                            dout = new DataOutputStream(out);
                            dout.writeUTF("000300600000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });
        seekBar11.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int engine = seekBar11.getProgress();
                textViewEngine.setText(engine + "");
                String temp = "";
                if(engine<10){
                    temp = "00"+engine;
                }else if(engine<100){
                    temp = "0"+engine;
                }else{
                    temp = ""+engine;
                }
                final String finalTemp = temp;
                Runnable testSendIoTRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {

                            out = socket.getOutputStream();
                            dout = new DataOutputStream(out);
                            dout.writeUTF("000300700000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });
        seekBar12.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int  brakeoil = seekBar12.getProgress();
                textViewBrake.setText(brakeoil + "");
                String temp = "";
                if(brakeoil<10){
                    temp = "00"+brakeoil;
                }else if(brakeoil<100){
                    temp = "0"+brakeoil;
                }else{
                    temp = ""+brakeoil;
                }
                final String finalTemp = temp;
                Runnable testSendIoTRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {

                            out = socket.getOutputStream();
                            dout = new DataOutputStream(out);
                            dout.writeUTF("000300750000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });
        seekBar13.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int accoil = seekBar13.getProgress();
                textViewAccoil.setText(accoil + "");
                String temp = "";
                if(accoil<10){
                    temp = "00"+accoil;
                }else if(accoil<100){
                    temp = "0"+accoil;
                }else{
                    temp = ""+accoil;
                }
                final String finalTemp = temp;
                Runnable testSendIoTRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {

                            out = socket.getOutputStream();
                            dout = new DataOutputStream(out);
                            dout.writeUTF("000300800000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });
        seekBar14.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int  cool = seekBar14.getProgress();
                textViewCoolwater.setText(cool + "");
                String temp = "";
                if(cool<10){
                    temp = "00"+cool;
                }else if(cool<100){
                    temp = "0"+cool;
                }else{
                    temp = ""+cool;
                }
                final String finalTemp = temp;
                Runnable testSendIoTRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {

                            out = socket.getOutputStream();
                            dout = new DataOutputStream(out);
                            dout.writeUTF("000300850000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });
        seekBar15.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int  accpad = seekBar15.getProgress();
                textViewAccPressure.setText(accpad + "");
                String temp = "";
                if(accpad<10){
                    temp = "00"+accpad;
                }else if(accpad<100){
                    temp = "0"+accpad;
                }else{
                    temp = ""+accpad;
                }
                final String finalTemp = temp;
                Runnable testSendIoTRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {

                            out = socket.getOutputStream();
                            dout = new DataOutputStream(out);
                            dout.writeUTF("000300900000000000000"+ finalTemp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread testThread = new Thread(testSendIoTRunnable);
                testThread.start();
            }
        });
        seekBar16.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                final int brakepad = seekBar16.getProgress();
                textViewBrakePressure.setText(brakepad + "");
                String temp = "";
                if(brakepad<10){
                    temp = "00"+brakepad;
                }else if(brakepad<100){
                    temp = "0"+brakepad;
                }else{
                    temp = ""+brakepad;
                }
                final String finalTemp = temp;
                Runnable testSendIoTRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {

                            out = socket.getOutputStream();
                            dout = new DataOutputStream(out);
                            dout.writeUTF("000300950000000000000"+ finalTemp);
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

    public class Receiver extends AsyncTask<String,String,Void>{
        Socket socket;

        public Receiver(Socket socket) {
            this.socket = socket;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            int data = Integer.parseInt(values[0].substring(13,28));

            if(values[0].substring(4,12).equals("00020040")) {
                seekBar8.setProgress(data);
                int temp = data - 40;
                textViewTemperature.setText(temp + "");
            }
    }

        @Override
        protected Void doInBackground(String... strings) {
            try {
                while(true){
                    in = socket.getInputStream();
                    DataInputStream din = new DataInputStream(in);

                    String Msg = din.readUTF();
                    Log.i("IoT",socket.getInetAddress()+" is send "+Msg);

                    publishProgress(Msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


  /*  public void onclick(View view){
        if (imageView24 != null) {
            imageView24.setSelected(!imageView24.isSelected());
        }
    }*/


}
