package com.carstatus;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.CarStatus;

@Component("CarStatusBiz")
public class CarStatusBiz implements Biz<String, CarStatus> {

	@Resource(name = "CarStatusDao")
	Dao<String, CarStatus> carStatusDao;
	
	@Override
	public void insert(CarStatus v) {
		carStatusDao.insert(v);
	}

	@Override
	public void update(CarStatus v) {
		carStatusDao.update(v);
	}

	@Override
	public void delete(String k) {
		carStatusDao.delete(k);
	}

	@Override
	public CarStatus select(String k) {
		CarStatus carStatus = carStatusDao.select(k);
		return carStatus;
	}

	@Override
	public ArrayList<CarStatus> selects(String k) {
		return null;
	}

	@Override
	public ArrayList<CarStatus> selectAll() {
		ArrayList<CarStatus> carStatuses = carStatusDao.selectAll();
		
		return carStatuses;
	}
}
