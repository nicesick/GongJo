package com.example.serveriotcommunicationexcerise;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class SendStateWithHttp {
    URL url;
    RealTimeController realTimeController;
    ConsumableController consumableController;

    public SendStateWithHttp(URL url) {
        this.url = url;
        realTimeController = new RealTimeController();
        consumableController = new ConsumableController();
    }

    public void sendMsg(String string) throws IOException {

//        BufferedReader reader = new BufferedReader((new InputStreamReader(conn.getInputStream())));


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection urlConnection = null;

                try {
                    JSONObject postData = new JSONObject();
                    postData.put("car_id",realTimeController.getCar_id());
                    postData.put("car_speed",realTimeController.getCar_speed());
                    postData.put("car_distance",realTimeController.getCar_distance());
                    postData.put("car_air",realTimeController.getCar_air());
                    postData.put("car_dust",realTimeController.getCar_dust());
                    postData.put("car_finedust",realTimeController.getCar_finedust());
                    postData.put("car_temp",realTimeController.getCar_temp());
                    postData.put("car_ext_temperature",realTimeController.getCar_ext_temperature());
                    postData.put("car_ext_dust",realTimeController.getCar_ext_dust());
                    postData.put("car_ext_finedust",realTimeController.getCar_ext_finedust());
                    postData.put("car_humidity",realTimeController.getCar_humidity());
                    postData.put("car_fuel",realTimeController.getCar_fuel());
                    postData.put("car_bat",realTimeController.getCar_bat());
                    postData.put("car_date",realTimeController.getCar_date());
                    postData.put("car_hms",realTimeController.getCar_hms());
                    postData.put("car_lat",realTimeController.getCar_lat());
                    postData.put("car_log",realTimeController.getCar_log());

                    postData.put("car_filter",consumableController.getCar_filter());
                    postData.put("car_eng_oil",consumableController.getCar_eng_oil());
                    postData.put("car_brakeoil",consumableController.getCar_brakeoil());
                    postData.put("car_accoil",consumableController.getCar_accoil());
                    postData.put("car_coolwat",consumableController.getCar_coolwat());

                    postData.put("car_accel_pressure",realTimeController.getCar_accel_pressure());
                    postData.put("car_brake_pressure",realTimeController.getCar_brake_pressure());

                   /* postData.put("CO2",realTimeController.getCO2());
                    postData.put("dust",realTimeController.getDust());
                    postData.put("humidity",realTimeController.getHumidity());
                    postData.put("inAir",realTimeController.getInAir());
                    postData.put("inTemperature",realTimeController.getInTpt());
                    postData.put("outAir",realTimeController.getOutAir());
                    postData.put("outTemperature",realTimeController.getOutTpt());
                    postData.put("ultraDust",realTimeController.getUltraDust());
                    postData.put("Total",realTimeController.getTotal());*/

                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setDoOutput(true);
                    urlConnection.setDoInput(true);
                    urlConnection.setChunkedStreamingMode(0);

                    OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                            out, "UTF-8"));
                    Log.d("JSON",postData.toString());
                    writer.write(postData.toString());
                    writer.flush();

                    int code = urlConnection.getResponseCode();
                    if (code !=  201) {
                        throw new IOException("Invalid response from server: " + code);
                    }

                    BufferedReader rd = new BufferedReader(new InputStreamReader(
                            urlConnection.getInputStream()));
                    String line;
                    while ((line = rd.readLine()) != null) {
                        Log.i("data", line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            }
        });
        thread.start();
    }
}
