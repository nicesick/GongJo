package com.carstatus;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.frame.Dao;
import com.mapper.carStatusMapper;
import com.vo.CarStatus;

@Component("CarStatusDao")
public class CarStatusDao implements Dao<String, CarStatus> {

	@Resource(name = "carStatusMapper")
	carStatusMapper carStatusMapper;
	
	@Override
	public void insert(CarStatus v) {
		carStatusMapper.insert(v);
	}

	@Override
	public void update(CarStatus v) {
		carStatusMapper.update(v);
	}

	@Override
	public void delete(String k) {
		carStatusMapper.delete(k);
	}

	@Override
	public CarStatus select(String k) {
		CarStatus carStatus = carStatusMapper.select(k);
		return carStatus;
	}

	@Override
	public ArrayList<CarStatus> selects(String k) {
		return null;
	}

	@Override
	public ArrayList<CarStatus> selectAll() {
		ArrayList<CarStatus> carStatuses = carStatusMapper.selectAll();
		
		return carStatuses;
	}

}
