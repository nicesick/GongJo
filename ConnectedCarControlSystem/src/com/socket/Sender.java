package com.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import com.test.PrintLog;

public class Sender extends Thread {
	private Socket socket;
	private String msg;
	
	public Sender(Socket socket) {
		this.socket = socket;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public void run() {
		OutputStream out = null;
		
		try {
			out = socket.getOutputStream();
			DataOutputStream dout = new DataOutputStream(out);
			
			PrintLog.printLog("Sender", msg + " is sent");
			dout.writeUTF(msg);
		} catch (IOException e) {
		}
	}
}
