package com.example.serveriotcommunicationexcerise;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeTimeInRealTime {
    TextView timeView;
    boolean flag;
    ChangeTimeAsyncTask changeTimeAsyncTask;
    public ChangeTimeInRealTime(TextView timeView) {
        this.timeView = timeView;
        changeTimeAsyncTask = new ChangeTimeAsyncTask();
        flag = true;
    }
    public void start(){
        changeTimeAsyncTask.execute();
    }
    void endProcess(){
        flag =false;
    }
    class ChangeTimeAsyncTask extends AsyncTask<Void,String,Void>{


        @Override
        protected void onPreExecute() {
            timeView.setText("time is not running qq");
        }

        @Override
        protected void onProgressUpdate(String... values) {
            timeView.setText(values[0]);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd \n HH:mm:ss");

            while(flag){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(sdf.format(new Date()));
            }

            return null;
        }
    }
}
