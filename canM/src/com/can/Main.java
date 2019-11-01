package com.can;

import java.io.IOException;

import com.callback.DataCallback;
import com.socket.Receiver;

class DataCallbackImpl implements DataCallback {
	private Receiver receiver;
	private SerialTestS st;
	
	public DataCallbackImpl(Receiver receiver, SerialTestS st) {
		this.receiver = receiver;
		this.st = st;
	}
	
	@Override
	public void getData(String data) {
		if (receiver != null) {
			try {
				receiver.sendMsg(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void getMsg(String msg) {
		if (st != null) {
			st.sendData(msg);
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Receiver receiver = null;
		SerialTestS st = null;
		DataCallbackImpl callback = new DataCallbackImpl(receiver, st);
		
		try {
			receiver = new Receiver("70.12.227.247", 8888);
			receiver.setCallback(callback);
			receiver.start();

			st = new SerialTestS("COM8");
			st.setCallback(callback);

//			SerialTestS st = new SerialTestS("COM8","70.12.225.203", 8788);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
