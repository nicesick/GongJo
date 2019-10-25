package com.mapper;

import java.util.ArrayList;

import com.vo.CarGroup;

public interface carGroupMapper {
	public void insert(CarGroup carGroup);
	public void update(CarGroup carGroup);
	public void delete(String key);
	public ArrayList<CarGroup> select(String key);
}
