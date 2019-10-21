package com.example.ecusimulator;

import android.util.Log;

import java.io.IOException;

import java.net.Socket;


public class ConnectServerTask {
    int port;
    String IP;
    Socket socket = null;

    public ConnectServerTask(final int port, String ip) {
        this.port = port;
        this.IP = ip;

        Thread makeServerSocket = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        socket = new Socket(IP,port);

                        if(socket != null && socket.isConnected()) {
                            Log.d("[ConnectServerTask]","socket is connected");

                            break;
                        }

                    } catch (IOException e) {
                        e.printStackTrace();

                        Log.d("[ConnectServerTask]","Re-Try");
                    }
                }
            }
        });
        makeServerSocket.start();

        try {
            makeServerSocket.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        serverSocketTask = new ServerSocket(socket);
//        if(serverSocketTask!=null){
//            serverSocketTask.execute();
//        }
    }

    public Socket getSocket(){
        return socket;
    }

//    class ServerSocket extends AsyncTask<Void,Object,Void> {
//
//        Socket serverSocket = null;
//
//        OutputStream out;
//        DataOutputStream dout;
//
//        InputStream in;
//        DataInputStream din;
//
//        public ServerSocket(Socket serverSocket) {
//            this.serverSocket = serverSocket;
//        }
//
//        @Override
//        protected void onProgressUpdate(Object... values) {
//
//
//                String msg = (String)values[1];
//                try {
//                    textView.append("\nServer send Msg : " + msg);
//                    sendMsg(msg,socketList);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//        }
//
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//
//            if(serverSocket!=null && serverSocket.isBound()){
//                try {
//                    while(true) {
//                        in = serverSocket.getInputStream();
//                        din = new DataInputStream(in);
//
//                        String Msg = din.readUTF();
//                        Object[] container = {new String("msg"), Msg};
//                        publishProgress(container);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return null;
//        }
//
//        protected void sendMsg(String msg, ArrayList<Socket> list) throws IOException {
//            final String Msg = msg;
//            for(final Socket socket1:socketList){
//                if(socket1!=null && socket1.isConnected()) {
//                    Runnable sendRunable = new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                out = socket1.getOutputStream();
//                                dout = new DataOutputStream(out);
//                                dout.writeUTF(Msg);
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    };
//                    Thread sendThread = new Thread(sendRunable);
//                    sendThread.start();
//                }
//            }
//        }
//    }
}
