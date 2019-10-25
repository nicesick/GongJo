package com.callback;

import com.socket.Receiver;

public interface SocketDataCallback {
	public void registerSocket(Receiver receiver, String car_id);
	public void removeSocket(Receiver receiver, String car_id);
}
