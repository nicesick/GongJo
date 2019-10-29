package com.example.serveriotcommunicationexcerise;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ConnectServerTask {
    int port;
    String IP;
    Socket socket = null;
    ArrayList<Socket> socketList;
    ServerSocket serverSocketTask;
    TextView textView;
    boolean flag;
    final String CarId = "서울1234";
    OutputStream out;
    DataOutputStream dout;
    LocationResgist locationResgist;

    public ConnectServerTask(final int port, String ip, ArrayList<Socket> socketList, TextView textView) {
        this.port = port;
        this.IP = ip;
        this.socketList = socketList;
        this.textView = textView;
        makeSocket();
        startServerSocket();
    }
    public void startServerSocket(){
        flag = true;
        serverSocketTask = new ServerSocket(socket,socketList);
        if(serverSocketTask!=null){
            serverSocketTask.execute();
        }
    }
    public Socket makeSocket(){
        if(socket==null) {
            Thread makeServerSocket = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        socket = new Socket(IP, port);
                        out = socket.getOutputStream();
                        dout = new DataOutputStream(out);
                        dout.writeUTF(CarId);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            makeServerSocket.start();
            try {
                makeServerSocket.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return socket;
    }
    public Socket getSocket(){
        return socket;
    }
    public void endProcess() throws IOException {

        out = socket.getOutputStream();
        dout = new DataOutputStream(out);
        dout.writeUTF("!q"); //send msg when process is out;
        flag = false;
    }

    class ServerSocket extends AsyncTask<Void,Object,Void> {

        Socket serverSocket = null;
        ArrayList<Socket> socketList;

        InputStream in;
        DataInputStream din;

        public ServerSocket(Socket serverSocket, ArrayList<Socket> socketList) {
            this.serverSocket = serverSocket;
            this.socketList = socketList;
            locationResgist = new LocationResgist();
        }

        @Override
        protected void onProgressUpdate(Object... values) {


                String msg = (String)values[1];
                if(msg.substring(0,5).equals("Danger")){
                    String[] areaToken = msg.split("/");
                    ArrayList<Location> locationArrayList = new ArrayList<>();
                    for(int i=1;i<areaToken.length;i++) {
                        String[] locationToken = areaToken[i].split(",");
                        locationArrayList.add(
                                new Location(Double.parseDouble(locationToken[0]),Double.parseDouble((locationToken[1]))));
                    }
                    locationResgist.setLocationsList(locationArrayList);
                }
                else {
                    try {
                        textView.append("\nServer send Msg : " + msg);
                        sendMsg(msg, socketList);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

        }


        @Override
        protected Void doInBackground(Void... voids) {

            if(serverSocket!=null && serverSocket.isBound()){
                try {
                    while(flag) {
                        in = serverSocket.getInputStream();
                        din = new DataInputStream(in);

                        String Msg = din.readUTF();
                        if(!serverSocket.isConnected()){
                            flag = false;
                            break;
                        }
                        Object[] container = {new String("msg"), Msg};
                        publishProgress(container);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        protected void sendMsg(String msg, ArrayList<Socket> list) throws IOException {
            final String Msg = msg;
            for(final Socket socket1:socketList){
                if(socket1!=null && socket1.isConnected()) {
                    Log.d("iot address", String.valueOf(socket1.getInetAddress()));
                    Runnable sendRunable = new Runnable() {
                        @Override
                        public void run() {
                            try {
                                out = socket1.getOutputStream();
                                dout = new DataOutputStream(out);
                                dout.writeUTF(Msg);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    Thread sendThread = new Thread(sendRunable);
                    sendThread.start();
                }
            }
        }
    }
}
