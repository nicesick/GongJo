package com.mapper;

import java.util.ArrayList;

import com.vo.DeviceToken;

public interface deviceTokenMapper {
	public void insert(DeviceToken deviceToken);
	public void update(DeviceToken deviceToken);
	public void delete(String key);
	public ArrayList<DeviceToken> selects(String key);
}
