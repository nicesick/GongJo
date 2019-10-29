package com.devicetoken;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.DeviceToken;

@Component("DeviceTokenBiz")
public class DeviceTokenBiz implements Biz<String, DeviceToken> {

	@Resource(name = "DeviceTokenDao")
	Dao<String, DeviceToken> deviceTokenDao;

	@Override
	public void insert(DeviceToken v) {
		deviceTokenDao.insert(v);
	}

	@Override
	public void update(DeviceToken v) {
		deviceTokenDao.update(v);
	}

	@Override
	public void delete(String k) {
		deviceTokenDao.delete(k);
	}

	@Override
	public DeviceToken select(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DeviceToken> selects(String k) {
		ArrayList<DeviceToken> tokens = deviceTokenDao.selects(k);
		
		return tokens;
	}

	@Override
	public ArrayList<DeviceToken> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
