package com.cargroup;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.CarGroup;

@Component("CarGroupBiz")
public class CarGroupBiz implements Biz<Object, CarGroup> {
	
	@Resource(name = "CarGroupDao")
	Dao<Object, CarGroup> carGroupDao;
	
	@Override
	public void insert(CarGroup v) {
		carGroupDao.insert(v);
	}

	@Override
	public void update(CarGroup v) {
		carGroupDao.update(v);
	}

	@Override
	public void delete(Object k) {
		carGroupDao.delete(k);
	}

	@Override
	public CarGroup select(Object k) {
		return null;
	}

	@Override
	public ArrayList<CarGroup> selects(Object k) {
		ArrayList<CarGroup> carGroups = carGroupDao.selects(k);
		
		return carGroups;
	}

	@Override
	public ArrayList<CarGroup> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
