package com.cargroupuser;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.frame.Dao;
import com.mapper.carGroupUserMapper;
import com.vo.CarGroup;

@Component("CarGroupUserDao")
public class CarGroupUserDao implements Dao<String, CarGroup> {

	@Autowired
	carGroupUserMapper carGroupUserMapper;
	
	@Override
	public void insert(CarGroup v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CarGroup v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CarGroup select(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CarGroup> selects(String k) {
		ArrayList<CarGroup> carGroups = carGroupUserMapper.selects(k);
		
		return carGroups;
	}

	@Override
	public ArrayList<CarGroup> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
