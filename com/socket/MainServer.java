package com.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.callback.SocketDataCallback;
import com.test.PrintLog;

public class MainServer extends Thread implements SocketDataCallback {
	private static int PORT = 8890;
	
	private Map<String, Receiver> socketMap;
	private boolean threadFlag;
	
	public MainServer() {
		socketMap = new HashMap<String, Receiver>();
		threadFlag = true;
	}
	
	public void setFlag() {
		threadFlag = !threadFlag;
	}
	
	public Map<String, Receiver> getSocketMap() {
		return socketMap;
	}
	
	@Override
	public void run() {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(PORT);
			PrintLog.printLog("MainServer", "MainServer is Ready...");
			
			while(threadFlag) {
				Socket socket = null;
				socket = serverSocket.accept();
				
				PrintLog.printLog("MainServer", socket.getInetAddress() + " is coming...");
				
				Receiver receiver = new Receiver(socket);
				receiver.setCallback(this);
				receiver.start();
			}
		} catch (IOException e) {
		} finally {
			PrintLog.printLog("MainServer", "MainServer will be closed");
			
			for (Receiver receiver : socketMap.values()) {
				if (receiver.getSocket() != null && receiver.getSocket().isConnected()) {
					try {
						receiver.getSocket().close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			
			socketMap.clear();
		}
	}

	@Override
	public void registerSocket(Receiver receiver, String car_id) {
		socketMap.put(car_id, receiver);
		
		PrintLog.printLog("MainServer", car_id + " is entered");
	}

	@Override
	public void removeSocket(Receiver receiver, String car_id) {
		if (socketMap.containsKey(car_id)) {
			socketMap.remove(car_id);
			
			PrintLog.printLog("MainServer", car_id + " is closed");
		}
	}
}
