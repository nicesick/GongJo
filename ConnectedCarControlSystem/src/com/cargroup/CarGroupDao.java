package com.cargroup;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.frame.Dao;
import com.mapper.carGroupMapper;
import com.vo.CarGroup;

@Component("CarGroupDao")
public class CarGroupDao implements Dao<String, CarGroup> {

	@Resource(name = "carGroupMapper")
	carGroupMapper carGroupMapper;
	
	@Override
	public void insert(CarGroup v) {
		carGroupMapper.insert(v);
	}

	@Override
	public void update(CarGroup v) {
		carGroupMapper.update(v);
	}

	@Override
	public void delete(String k) {
		carGroupMapper.delete(k);
	}

	@Override
	public CarGroup select(String k) {
		return null;
	}

	@Override
	public ArrayList<CarGroup> selects(String k) {
		ArrayList<CarGroup> carGroups = carGroupMapper.selects(k);
		
		return carGroups;
	}

	@Override
	public ArrayList<CarGroup> selectAll() {
		return null;
	}

}
