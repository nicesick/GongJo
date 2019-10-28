package com.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import com.callback.SocketDataCallback;
import com.test.PrintLog;

public class Receiver extends Thread {
	private Socket socket;
	private SocketDataCallback socketDataCallback;
	private boolean isRegistered;
	
	private String car_id;
	
	public Receiver(Socket socket) {
		this.socket = socket;
		isRegistered = false;
		
		car_id = "";
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	public void setCallback(SocketDataCallback socketDataCallback) {
		this.socketDataCallback = socketDataCallback;
	}
	
	@Override
	public void run() {
		InputStream in = null;
		
		try {
			in = socket.getInputStream();
			DataInputStream din = new DataInputStream(in);
			
			while(true) {
				String msg = din.readUTF();
				car_id = msg;
				
				PrintLog.printLog("Receiver", msg);
				
				if (isRegistered == false) {
					socketDataCallback.registerSocket(this, car_id);
					isRegistered = true;
				}
			}
		} catch (IOException e) {
		} finally {
			socketDataCallback.removeSocket(this, car_id);
			
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
