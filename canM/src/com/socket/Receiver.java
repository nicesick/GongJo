package com.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import com.callback.DataCallback;

public class Receiver extends Thread { // Pad -> IoT -> CAN
	private Socket socket;
	private String ip;
	private int port;

	private InputStream in;
	private DataInputStream din;
	private boolean rflag = true;

	private DataCallback dataCallback;
	
	public Socket getSocket() {
		return socket;
	}
	
	public void setCallback(DataCallback dataCallback) {
		this.dataCallback = dataCallback;
	}
	
	public Receiver(String ip, int port) throws IOException {
		this.ip = ip;
		this.port = port;

		this.socket = connectSocket();
	}

	public void run() {
		while (rflag) {
			try {
				String str = din.readUTF();
				System.out.println("Receiver From Pad : " + str);
				
				dataCallback.getMsg(str);

//				if(str.equals("1th send")) {
//					st.sendData("W28000000000000000000000001");
//				} else if(str.equals("2th send")){
//					st.sendData("W28000000000000000000000010");
//				} else if(str.equals("3th send")){
//					st.sendData("W280000000100000000ABCDABCD");
//				}

			} catch (Exception e) {
				System.out.println("Socket is closed already...");
				
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
				connectSocket();
			}
		}
	}

	public void sendMsg(String msg) throws IOException {
		Sender sender = null;

		if (socket != null && socket.isConnected()) {
			sender = new Sender(socket);
			sender.setMsg(msg);
			sender.start();
		}

		else {
			System.out.println("Socket is closed already...");
			
			if (socket != null) {
				socket.close();
			}

			connectSocket();
		}
	}

	public Socket connectSocket() {
		boolean flag = true;
		Socket socket = null;

		while (flag) {
			try {
				socket = new Socket(ip, port);

				if (socket != null && socket.isConnected()) {
					in = socket.getInputStream();
					din = new DataInputStream(in);

					break;
				}
			} catch (Exception e) { // 서버가 안켜져있으면
				System.out.println("Re-Try");

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		} // End while

		System.out.println("Socket Connect OK");

		return socket;
	}
}