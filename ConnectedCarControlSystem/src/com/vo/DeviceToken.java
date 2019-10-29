package com.vo;

public class DeviceToken {
	String user_id;
	String device_token;
	
	public DeviceToken() {
	}
	
	public DeviceToken(String user_id, String device_token) {
		this.user_id = user_id;
		this.device_token = device_token;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDevice_token() {
		return device_token;
	}

	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}

	@Override
	public String toString() {
		return "DeviceToken [user_id=" + user_id + ", device_token=" + device_token + "]";
	}
}
