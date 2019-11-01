package com.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Sender extends Thread {
//	Socket socket;
	OutputStream out;
	DataOutputStream dout;
	String msg;

	public Sender(Socket socket) throws IOException {
		out = socket.getOutputStream();
		dout = new DataOutputStream(out);
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void run() {
		if(dout != null) {
			try {
				dout.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}