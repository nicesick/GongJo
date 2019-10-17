package com.example.serveriotcommunicationexcerise;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendStateWithHttp {
    URL url;

    public SendStateWithHttp(URL url) {
        this.url = url;
    }

    public void SendMsg(String string) throws IOException {

//        BufferedReader reader = new BufferedReader((new InputStreamReader(conn.getInputStream())));


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection conn = null;

                try {
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(1000);

                    conn.getInputStream();

                    Log.d("http Msg","send");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    conn.disconnect();
                }
            }
        });
        thread.start();
    }
}
