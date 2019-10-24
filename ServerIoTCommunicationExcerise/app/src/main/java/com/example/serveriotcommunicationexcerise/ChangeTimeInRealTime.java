package com.example.serveriotcommunicationexcerise;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeTimeInRealTime {
    private URL url;

    TextView timeView;
    boolean flag;
    ChangeTimeAsyncTask changeTimeAsyncTask;
    RealTimeController realTimeController;
    SendStateWithHttp sendStateWithHttp;

    public ChangeTimeInRealTime(TextView timeView) {
        this.timeView = timeView;
        changeTimeAsyncTask = new ChangeTimeAsyncTask();
        flag = true;
        realTimeController = new RealTimeController();
    }

    public void start(){
        changeTimeAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    void endProcess(){
        flag =false;
    }

    class ChangeTimeAsyncTask extends AsyncTask<Void,Date,Void>{
        @Override
        protected void onPreExecute() {
            timeView.setText("time is not running qq");

            setURL();
            sendStateWithHttp = new SendStateWithHttp(url);
        }

        @Override
        protected void onProgressUpdate(Date... values) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd \n HH:mm:ss");
            SimpleDateFormat timeForHms = new SimpleDateFormat("HH:mm:ss");
            java.sql.Date date = new java.sql.Date(values[0].getTime());

            timeView.setText(sdf.format(values[0]));
            realTimeController.setCar_date(date);
            realTimeController.setCar_hms(timeForHms.format(date));

            try {
                sendStateWithHttp.sendMsg("aaa");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected Void doInBackground(Void... voids) {
            while(flag){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(new Date());
            }

            return null;
        }
    }

    void setURL(){
        try {
            url = new URL("http://70.12.60.99/sendData.mc");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
