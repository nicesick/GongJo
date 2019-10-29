package com.devicetoken;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.frame.Dao;
import com.mapper.deviceTokenMapper;
import com.vo.DeviceToken;

@Component("DeviceTokenDao")
public class DeviceTokenDao implements Dao<String, DeviceToken> {

	@Resource(name = "deviceTokenMapper")
	deviceTokenMapper deviceTokenMapper;

	@Override
	public void insert(DeviceToken v) {
		deviceTokenMapper.insert(v);
	}

	@Override
	public void update(DeviceToken v) {
		deviceTokenMapper.update(v);
	}

	@Override
	public void delete(String k) {
		deviceTokenMapper.delete(k);
	}

	@Override
	public DeviceToken select(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DeviceToken> selects(String k) {
		ArrayList<DeviceToken> tokens = deviceTokenMapper.selects(k);
		
		return tokens;
	}

	@Override
	public ArrayList<DeviceToken> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
