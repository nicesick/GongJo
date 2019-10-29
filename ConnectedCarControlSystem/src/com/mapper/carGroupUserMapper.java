package com.mapper;

import java.util.ArrayList;

import com.vo.CarGroup;

public interface carGroupUserMapper {
	public void insert(CarGroup carGroup);
	public void update(CarGroup carGroup);
	public void delete(String key);
	public ArrayList<CarGroup> selects(String key);
}
